package dp.shop.Service.Imp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import dp.shop.Dao.CartMyBatis_Dao_Interface;
import dp.shop.Dao.Imp.CartMyBatis_Dao_impl;
import dp.shop.Entity.Cart;
import dp.shop.Entity.PageModel;
import dp.shop.Entity.VO.CartVO;
import dp.shop.Service.Cart_Service_Interface_HTML;

public class Cart_Servic_Impl_HTML implements Cart_Service_Interface_HTML{
	CartMyBatis_Dao_Interface Cart_Dao=new CartMyBatis_Dao_impl();
	@Override
	
	public String findUserCart(HttpServletRequest request,Integer userid) {
		// TODO Auto-generated method stub
		//PageModel<CartVO>
		String pageNo =request.getParameter("pageNo");
		String pageSize=request.getParameter("pageSize");
		Integer _pageNo=0;
		Integer _pageSize=0;
		
		try {
		_pageNo= Integer.parseInt(pageNo);
		_pageSize=Integer.parseInt(pageSize);
		}catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		PageModel<CartVO> cartVO=new PageModel<CartVO>();
		List<CartVO> list=new ArrayList<CartVO>();
		PageModel<Cart> cart=Cart_Dao.findUserCart(_pageNo, _pageSize, userid);
		if(cart!=null) {
			cartVO.setTotalPage(cart.getTotalPage());
			List<Cart> carts=cart.getData();
			for(Cart c:carts) {
				CartVO cartVo=new CartVO();
				cartVo.CartIntoCartVO(c);	
				list.add(cartVo);	
			}
			cartVO.setData(list);
		}
		//创建一个Gson
		Gson gson=new Gson();
		//调用Gson的方法toJson将获得的pageModel的值转换成为Json类型的
		String str=gson.toJson(cartVO);
		return str;
	}

	@Override
	public int addUserCart(Integer userid, HttpServletRequest request) {
		String _product_id=request.getParameter("product_id");
		String _quantity=request.getParameter("quantity");
		String _checked=request.getParameter("checked");
		
		Integer product_id=0;
		Integer quantity=0;
		Integer checked=0;
		try {
			product_id= Integer.parseInt(_product_id);
			quantity=Integer.parseInt(_quantity);
			checked=Integer.parseInt(_checked);
		}catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Cart cart=new Cart();
		cart.setUser_id(userid);
		cart.setProduct_id(product_id);
		cart.setQuantity(quantity);
		cart.setChecked(checked);

		return Cart_Dao.addUserCart(userid, cart);
		
	}
	
	@Override
	public int pd(Integer userid, Integer product_id) {
		// TODO Auto-generated method stub
		return Cart_Dao.pd(userid, product_id);
	}
	@Override
	public int updataUserCartByUseridAndProduct_id(Integer userid,HttpServletRequest request ) {
		// TODO Auto-generated method stub
		String _product_id=request.getParameter("product_id");
		String _quantity=request.getParameter("quantity");
		
		Integer product_id=0;
		Integer quantity=0;

		try {
			product_id= Integer.parseInt(_product_id);
			quantity=Integer.parseInt(_quantity);
		}catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Cart_Dao.updataUserCartByUseridAndProduct_id(userid, product_id, quantity);
	}

	@Override
	public int deletUserCartByUseridAndProduct_id(Integer userid, Integer product_id) {
		// TODO Auto-generated method stub
		return Cart_Dao.deletUserCartByUseridAndProduct_id(userid, product_id);
	}

	@Override
	public int updataUserCartCheckedByUseridAndProduct_id(Integer userid,HttpServletRequest request) {
		// TODO Auto-generated method stub
		String _product_id=request.getParameter("product_id");
		String _checked=request.getParameter("checked");
		
		Integer product_id=0;
		Integer checked=0;

		try {
			product_id= Integer.parseInt(_product_id);
			checked=Integer.parseInt(_checked);
		}catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Cart_Dao.updataUserCartCheckedByUseridAndProduct_id(userid, product_id, checked);
	}

	@Override
	public List<Cart> findAllUserCart(Integer userid) {
		// TODO Auto-generated method stub
		return Cart_Dao.findAllUserCart(userid);
	}

	@Override
	public int updataAllUserCartCheckedByUserid(Integer userid, Integer checked) {
		// TODO Auto-generated method stub
		return Cart_Dao.updataAllUserCartCheckedByUserid(userid, checked);
	}

	@Override
	public int findUserCartdequantity(Integer userid) {
		// TODO Auto-generated method stub
		return Cart_Dao.findUserCartdequantity(userid);
	}

	@Override
	public String SumPaument(Integer userid) {
		// TODO Auto-generated method stub
		
		PageModel<CartVO> cartVO=new PageModel<CartVO>();
		List<CartVO> list=new ArrayList<CartVO>();
		PageModel<Cart> cart=Cart_Dao.findUserCart(1, 1000000, userid);
		if(cart!=null) {
			cartVO.setTotalPage(cart.getTotalPage());
			List<Cart> carts=cart.getData();
			for(Cart c:carts) {
				CartVO cartVo=new CartVO();
				cartVo.CartIntoCartVO(c);	
				list.add(cartVo);	
			}
			cartVO.setData(list);
		}

		//计算金额
		List<CartVO> cartvo=cartVO.getData();
		BigDecimal num=new BigDecimal(0);
		for(CartVO vo:cartvo) {
			if(vo.getChecked()=="已勾选") {
				BigDecimal big=new BigDecimal(vo.getPayment());
				num=num.add(big);
			}
		}
		String _Payment=num.toString();
		String payment= "{\"Paument\":"+_Payment+"}";
		
		return payment;
	}


	
	
	
}
