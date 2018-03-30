package dp.shop.Service.Imp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import dp.shop.Contst.OrderStatusEnum;
import dp.shop.Dao.CartMyBatis_Dao_Interface;
import dp.shop.Dao.Shop_Dao_Interface;
import dp.shop.Dao.UserOrderItemMyBatis_Dao_Interface;
import dp.shop.Dao.UserOrderMyBatis_Dao_Interface;
import dp.shop.Dao.Imp.CartMyBatis_Dao_impl;
import dp.shop.Dao.Imp.Shop_Dao_Imp;
import dp.shop.Dao.Imp.UserOrderItemMyBatis_Dao_Impl;
import dp.shop.Dao.Imp.UserOrderMyBatis_Dao_Impl;
import dp.shop.Entity.Cart;
import dp.shop.Entity.PageModel;
import dp.shop.Entity.Product;
import dp.shop.Entity.UserOrder;
import dp.shop.Entity.UserOrderItem;
import dp.shop.Entity.VO.OrderVO;
import dp.shop.Exception.orderException;
import dp.shop.Service.Order_Service_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单---业务逻辑层
 * 
 * */
@Service
public class Order_Service_Impl implements Order_Service_Interface {
	@Autowired
	private CartMyBatis_Dao_Interface CartDao;
	//private CartMyBatis_Dao_Interface CartDao=new CartMyBatis_Dao_impl();
	@Autowired
	private UserOrderMyBatis_Dao_Interface UserOrderDao;
	//private UserOrderMyBatis_Dao_Interface UserOrderDao=new UserOrderMyBatis_Dao_Impl();
	@Autowired
	private Shop_Dao_Interface product;
	//private Shop_Dao_Interface product=Shop_Dao_Imp.getShopDao();
	@Autowired
	private UserOrderItemMyBatis_Dao_Interface UserOrderItemDao;
	//private UserOrderItemMyBatis_Dao_Interface UserOrderItemDao=new UserOrderItemMyBatis_Dao_Impl();
	@Override
	
	/**
	 * 提交订单
	 * */
	public UserOrder createOrder(Integer user_id, HttpServletRequest request) throws orderException {
		// TODO Auto-generated method stub
		//step1：获取地址	
		String shipping=request.getParameter("shipping_id");
		if(shipping==null||shipping.equals("")) {
			throw new orderException("配送地址必填");
		}
		Integer shipping_id=null;
		try {
			shipping_id=Integer.parseInt(shipping);
		}catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new orderException("配送地址填写错误");
		}
		//step2：查询用户下单的商品
		List<Cart> carts=CartDao.findCartListByUserid(user_id);
		
		//step3：将购物车商品添加到商品明细
		List<UserOrderItem> userOrderItem=this.convertCartToOrderItem(user_id,carts);
		
		//step4：创建订单
			//计算总价
		BigDecimal payment=new BigDecimal("0");
		for(UserOrderItem uoi:userOrderItem) {
			payment=payment.add(uoi.getTotal_price());
		}	
			//为订单赋值并插入数据库
		UserOrder order=createOrder(user_id, shipping_id, payment);
		
			//为订单明细表插入订单编号并插入数据库
		if(order!=null) {//订单插入数据库成功
			for(UserOrderItem uoi:userOrderItem) {
				uoi.setOrder_no(order.getOrder_no());
			}
			UserOrderItemDao.addOrderItem(userOrderItem);
		}
		//step5：清空购物车
		Integer product_id=null;
		for(UserOrderItem uoi:userOrderItem) {
			product_id=uoi.getProduct_id();
			CartDao.deletUserCartByUseridAndProduct_id(user_id, product_id);
		}
		
		
		return null;
	}
	
	/*** 购物车将商品放入订单明细表* */
	private List<UserOrderItem> 	convertCartToOrderItem(Integer user_id,List<Cart> carts){
		List<UserOrderItem> list=new ArrayList<UserOrderItem>();
		
		for(Cart c:carts) {
			UserOrderItem userOrderItem=new UserOrderItem();
			
			Product p=product.findProductById(c.getProduct_id());
			if(p==null) {
				throw new orderException("商品信息有误");
			}
			Integer num=p.getStock()-c.getQuantity();
			if(num>0) {
				userOrderItem.setUser_id(user_id);				//用户id
				userOrderItem.setProduct_id(c.getProduct_id());	//商品ID
				userOrderItem.setProduct_name(p.getName());	//商品名字
				userOrderItem.setProduct_image(p.getMain_image());//商品图片
				userOrderItem.setCurrent_unit_price(p.getPrice());//商品单价
				userOrderItem.setQuantity(c.getQuantity());//商品数量
				
				BigDecimal quantity=new BigDecimal(c.getQuantity());
				BigDecimal avg=p.getPrice().multiply(quantity);
				
				userOrderItem.setTotal_price(avg);	//商品总价格
				
				list.add(userOrderItem);
				
				p.setStock(num);
				product.updateProduct(p);
			}else {
				
				throw new orderException("库存数量不足");
				
			}

		}
		
		return list;
	}
	/**生成订单编号*/
	private long MakeOrder_No() {
		long order_no=0;
		long random=(long) (Math.random()*101);
		order_no=System.currentTimeMillis()+random;
		return order_no;
	}
	
	/*** 将订单明细信息放入订单表中* */
	private UserOrder createOrder(Integer user_id,Integer shipping_id,BigDecimal payment) {
		UserOrder userOrder=new UserOrder();
		//订单编号
		userOrder.setOrder_no(MakeOrder_No());//订单编号
		userOrder.setUser_id(user_id);				//用户id
		userOrder.setShipping_id(shipping_id);//地址id
		userOrder.setPayment(payment);			//付款金额
		userOrder.setPayment_type(1);				//付款方式
		userOrder.setPostage(0);						//邮费
		userOrder.setStatus(OrderStatusEnum.UNPAY.getStatus());
		
		//插入数据库
		int num=UserOrderDao.addOrder(userOrder);
		if(num>0) {
			return userOrder;
		}else {
			throw new orderException("订单插入失败");
		}
	}
	
	/**
	 * 分页查看订单
	 * */
	public PageModel<OrderVO> findUserOrder(HttpServletRequest request, Integer user_id) throws orderException{
		String _pageNo=request.getParameter("pageNo");
		String _pageSize=request.getParameter("pageSize");
		if(_pageNo==null||_pageNo.equals("")||_pageSize==null||_pageSize.equals("")) {
			throw new orderException("页码信息必填");
		}
		Integer pageNo=null;
		Integer pageSize=null;
		try {
			pageNo=Integer.parseInt(_pageNo);
			pageSize=Integer.parseInt(_pageSize);
		}catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new orderException("页码信息填写错误");
		}
		//页面实体PageModel<OrderVO>
		PageModel<OrderVO> userOrderVO=new PageModel<OrderVO>();
		
		List<OrderVO> list=new ArrayList<>();
		//获得dao层实体PageModel<UserOrder>
		PageModel<UserOrder> userOrderDO=UserOrderDao.findUserOrder(pageNo, pageSize, user_id);
	
		//判断userOrderDO是否为空
		if(userOrderDO!=null) {
			
			//将dao层实体类转换为页面实体类
			userOrderVO.setTotalPage(userOrderDO.getTotalPage());
			List<UserOrder> orders=userOrderDO.getData();
			
			for(UserOrder order:orders) {
				OrderVO orderVO=new OrderVO();
				orderVO.UserOrderIntoOrderVO(order);	
				list.add(orderVO);
			}
			userOrderVO.setData(list);
			return userOrderVO;
		}else {
			throw new orderException("转化错误");
		}
	}
	/**
	 * 根据订单编号查询订单(使用模糊查询)
	 * */
	@Override
	public PageModel<OrderVO> findUserOrderDetailByOrderNo(HttpServletRequest request,Integer user_id) throws orderException {
		// TODO Auto-generated method stub
		String _pageNo=request.getParameter("pageNo");
		String _pageSize=request.getParameter("pageSize");
		String _order_no=request.getParameter("order_no");
		
		if(_pageNo==null||_pageNo.equals("")||_pageSize==null||_pageSize.equals("")) {
			throw new orderException("页码信息必填");
		}
		Integer pageNo=null;
		Integer pageSize=null;
		Long order_no=null;
		try {
			pageNo=Integer.parseInt(_pageNo);
			pageSize=Integer.parseInt(_pageSize);
			if(_order_no==null||_order_no.equals("")) {
				order_no=null;
				System.out.println("=================");
			}else {
				order_no=Long.parseLong(_order_no);
			}
		}catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new orderException("页码信息填写错误");
		}
		
		//页面实体PageModel<OrderVO>
		PageModel<OrderVO> userOrderVO=new PageModel<OrderVO>();
				
		List<OrderVO> list=new ArrayList<OrderVO>();
		//获得dao层实体PageModel<UserOrder>
		PageModel<UserOrder> userOrderDO=UserOrderDao.findUserOrderDetailByOrderNo(pageNo, pageSize, order_no, user_id);
		
		//判断userOrderDO是否为空
		if(userOrderDO!=null) {
			
			//将dao层实体类转换为页面实体类
			userOrderVO.setTotalPage(userOrderDO.getTotalPage());
			List<UserOrder> orders=userOrderDO.getData();
			
			for(UserOrder order:orders) {
				OrderVO orderVO=new OrderVO();
				orderVO.UserOrderIntoOrderVO(order);	
				list.add(orderVO);
			}
			userOrderVO.setData(list);
			return userOrderVO;
		}else {
			throw new orderException("转化错误");
		}
	}
	/**
	 * 查询订单明细
	 * */
	@Override
	public OrderVO findUserOrderItemByOrderNo(Integer user_id, HttpServletRequest request) throws orderException {
		// TODO Auto-generated method stub
		String _order_no=request.getParameter("order_no");
		
		if(_order_no==null||_order_no.equals("")) {
			throw new orderException("页码信息必填");
		}
		Long order_no=null;
		try {
				order_no=Long.parseLong(_order_no);
			
		}catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new orderException("页码信息填写错误");
		}
		
		//页面实体OrderVO
		OrderVO userOrderVO=new OrderVO();

		//获得dao层实体UserOrder
		UserOrder userOrderDO=UserOrderItemDao.findUserOrderItemByOrderNo(user_id, order_no);
				
		//判断userOrderDO是否为空
		if(userOrderDO!=null) {
			//将dao层实体类转换为页面实体类
			userOrderVO.UserOrderIntoOrderVO(userOrderDO);
			return userOrderVO;
		}else {
			throw new orderException("转化错误");
		}

	}

	@Override
	public int updateOrderByOrderNo(HttpServletRequest request) throws orderException {
		// TODO Auto-generated method stub
		String _order_no=request.getParameter("order_no");
		String _status=request.getParameter("status");
		if(_order_no==null||_order_no.equals("")) {
			throw new orderException("页码信息必填");
		}
		Long order_no=null;
		Integer status=null;
		try {
				order_no=Long.parseLong(_order_no);
				status=Integer.parseInt(_status);
		}catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new orderException("页码信息填写错误");
		}
		
		int num=UserOrderDao.updateOrderByOrderNo(order_no, status);

		return num;
	
		
	}

}
	
	
	

