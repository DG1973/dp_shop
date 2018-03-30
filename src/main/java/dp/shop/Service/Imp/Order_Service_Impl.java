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
 * ����---ҵ���߼���
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
	 * �ύ����
	 * */
	public UserOrder createOrder(Integer user_id, HttpServletRequest request) throws orderException {
		// TODO Auto-generated method stub
		//step1����ȡ��ַ	
		String shipping=request.getParameter("shipping_id");
		if(shipping==null||shipping.equals("")) {
			throw new orderException("���͵�ַ����");
		}
		Integer shipping_id=null;
		try {
			shipping_id=Integer.parseInt(shipping);
		}catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new orderException("���͵�ַ��д����");
		}
		//step2����ѯ�û��µ�����Ʒ
		List<Cart> carts=CartDao.findCartListByUserid(user_id);
		
		//step3�������ﳵ��Ʒ��ӵ���Ʒ��ϸ
		List<UserOrderItem> userOrderItem=this.convertCartToOrderItem(user_id,carts);
		
		//step4����������
			//�����ܼ�
		BigDecimal payment=new BigDecimal("0");
		for(UserOrderItem uoi:userOrderItem) {
			payment=payment.add(uoi.getTotal_price());
		}	
			//Ϊ������ֵ���������ݿ�
		UserOrder order=createOrder(user_id, shipping_id, payment);
		
			//Ϊ������ϸ����붩����Ų��������ݿ�
		if(order!=null) {//�����������ݿ�ɹ�
			for(UserOrderItem uoi:userOrderItem) {
				uoi.setOrder_no(order.getOrder_no());
			}
			UserOrderItemDao.addOrderItem(userOrderItem);
		}
		//step5����չ��ﳵ
		Integer product_id=null;
		for(UserOrderItem uoi:userOrderItem) {
			product_id=uoi.getProduct_id();
			CartDao.deletUserCartByUseridAndProduct_id(user_id, product_id);
		}
		
		
		return null;
	}
	
	/*** ���ﳵ����Ʒ���붩����ϸ��* */
	private List<UserOrderItem> 	convertCartToOrderItem(Integer user_id,List<Cart> carts){
		List<UserOrderItem> list=new ArrayList<UserOrderItem>();
		
		for(Cart c:carts) {
			UserOrderItem userOrderItem=new UserOrderItem();
			
			Product p=product.findProductById(c.getProduct_id());
			if(p==null) {
				throw new orderException("��Ʒ��Ϣ����");
			}
			Integer num=p.getStock()-c.getQuantity();
			if(num>0) {
				userOrderItem.setUser_id(user_id);				//�û�id
				userOrderItem.setProduct_id(c.getProduct_id());	//��ƷID
				userOrderItem.setProduct_name(p.getName());	//��Ʒ����
				userOrderItem.setProduct_image(p.getMain_image());//��ƷͼƬ
				userOrderItem.setCurrent_unit_price(p.getPrice());//��Ʒ����
				userOrderItem.setQuantity(c.getQuantity());//��Ʒ����
				
				BigDecimal quantity=new BigDecimal(c.getQuantity());
				BigDecimal avg=p.getPrice().multiply(quantity);
				
				userOrderItem.setTotal_price(avg);	//��Ʒ�ܼ۸�
				
				list.add(userOrderItem);
				
				p.setStock(num);
				product.updateProduct(p);
			}else {
				
				throw new orderException("�����������");
				
			}

		}
		
		return list;
	}
	/**���ɶ������*/
	private long MakeOrder_No() {
		long order_no=0;
		long random=(long) (Math.random()*101);
		order_no=System.currentTimeMillis()+random;
		return order_no;
	}
	
	/*** ��������ϸ��Ϣ���붩������* */
	private UserOrder createOrder(Integer user_id,Integer shipping_id,BigDecimal payment) {
		UserOrder userOrder=new UserOrder();
		//�������
		userOrder.setOrder_no(MakeOrder_No());//�������
		userOrder.setUser_id(user_id);				//�û�id
		userOrder.setShipping_id(shipping_id);//��ַid
		userOrder.setPayment(payment);			//������
		userOrder.setPayment_type(1);				//���ʽ
		userOrder.setPostage(0);						//�ʷ�
		userOrder.setStatus(OrderStatusEnum.UNPAY.getStatus());
		
		//�������ݿ�
		int num=UserOrderDao.addOrder(userOrder);
		if(num>0) {
			return userOrder;
		}else {
			throw new orderException("��������ʧ��");
		}
	}
	
	/**
	 * ��ҳ�鿴����
	 * */
	public PageModel<OrderVO> findUserOrder(HttpServletRequest request, Integer user_id) throws orderException{
		String _pageNo=request.getParameter("pageNo");
		String _pageSize=request.getParameter("pageSize");
		if(_pageNo==null||_pageNo.equals("")||_pageSize==null||_pageSize.equals("")) {
			throw new orderException("ҳ����Ϣ����");
		}
		Integer pageNo=null;
		Integer pageSize=null;
		try {
			pageNo=Integer.parseInt(_pageNo);
			pageSize=Integer.parseInt(_pageSize);
		}catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new orderException("ҳ����Ϣ��д����");
		}
		//ҳ��ʵ��PageModel<OrderVO>
		PageModel<OrderVO> userOrderVO=new PageModel<OrderVO>();
		
		List<OrderVO> list=new ArrayList<>();
		//���dao��ʵ��PageModel<UserOrder>
		PageModel<UserOrder> userOrderDO=UserOrderDao.findUserOrder(pageNo, pageSize, user_id);
	
		//�ж�userOrderDO�Ƿ�Ϊ��
		if(userOrderDO!=null) {
			
			//��dao��ʵ����ת��Ϊҳ��ʵ����
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
			throw new orderException("ת������");
		}
	}
	/**
	 * ���ݶ�����Ų�ѯ����(ʹ��ģ����ѯ)
	 * */
	@Override
	public PageModel<OrderVO> findUserOrderDetailByOrderNo(HttpServletRequest request,Integer user_id) throws orderException {
		// TODO Auto-generated method stub
		String _pageNo=request.getParameter("pageNo");
		String _pageSize=request.getParameter("pageSize");
		String _order_no=request.getParameter("order_no");
		
		if(_pageNo==null||_pageNo.equals("")||_pageSize==null||_pageSize.equals("")) {
			throw new orderException("ҳ����Ϣ����");
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
			throw new orderException("ҳ����Ϣ��д����");
		}
		
		//ҳ��ʵ��PageModel<OrderVO>
		PageModel<OrderVO> userOrderVO=new PageModel<OrderVO>();
				
		List<OrderVO> list=new ArrayList<OrderVO>();
		//���dao��ʵ��PageModel<UserOrder>
		PageModel<UserOrder> userOrderDO=UserOrderDao.findUserOrderDetailByOrderNo(pageNo, pageSize, order_no, user_id);
		
		//�ж�userOrderDO�Ƿ�Ϊ��
		if(userOrderDO!=null) {
			
			//��dao��ʵ����ת��Ϊҳ��ʵ����
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
			throw new orderException("ת������");
		}
	}
	/**
	 * ��ѯ������ϸ
	 * */
	@Override
	public OrderVO findUserOrderItemByOrderNo(Integer user_id, HttpServletRequest request) throws orderException {
		// TODO Auto-generated method stub
		String _order_no=request.getParameter("order_no");
		
		if(_order_no==null||_order_no.equals("")) {
			throw new orderException("ҳ����Ϣ����");
		}
		Long order_no=null;
		try {
				order_no=Long.parseLong(_order_no);
			
		}catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new orderException("ҳ����Ϣ��д����");
		}
		
		//ҳ��ʵ��OrderVO
		OrderVO userOrderVO=new OrderVO();

		//���dao��ʵ��UserOrder
		UserOrder userOrderDO=UserOrderItemDao.findUserOrderItemByOrderNo(user_id, order_no);
				
		//�ж�userOrderDO�Ƿ�Ϊ��
		if(userOrderDO!=null) {
			//��dao��ʵ����ת��Ϊҳ��ʵ����
			userOrderVO.UserOrderIntoOrderVO(userOrderDO);
			return userOrderVO;
		}else {
			throw new orderException("ת������");
		}

	}

	@Override
	public int updateOrderByOrderNo(HttpServletRequest request) throws orderException {
		// TODO Auto-generated method stub
		String _order_no=request.getParameter("order_no");
		String _status=request.getParameter("status");
		if(_order_no==null||_order_no.equals("")) {
			throw new orderException("ҳ����Ϣ����");
		}
		Long order_no=null;
		Integer status=null;
		try {
				order_no=Long.parseLong(_order_no);
				status=Integer.parseInt(_status);
		}catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new orderException("ҳ����Ϣ��д����");
		}
		
		int num=UserOrderDao.updateOrderByOrderNo(order_no, status);

		return num;
	
		
	}

}
	
	
	

