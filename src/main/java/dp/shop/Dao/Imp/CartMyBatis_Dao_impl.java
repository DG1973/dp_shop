package dp.shop.Dao.Imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import dp.shop.Common.MybatisUtils;
import dp.shop.Dao.CartMyBatis_Dao_Interface;
import dp.shop.Entity.Cart;
import dp.shop.Entity.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("CartMyBatisDao")
public class CartMyBatis_Dao_impl implements CartMyBatis_Dao_Interface {
	@Autowired
	SqlSessionFactory  factory;

	public void setFactory(SqlSessionFactory factory) {
		this.factory = factory;
	}

	@Override
	/*1. 查询购物车 分页查询*/
	public PageModel<Cart> findUserCart(Integer pageNo, Integer pageSize, Integer userid) {
		// TODO Auto-generated method stub
		PageModel<Cart> pageModel=new PageModel<Cart>();
		SqlSession session=factory.openSession(false);
		List<Cart> l=session.selectList("dp.shop.Cart.findAllUserCart", userid);
		int num=0;
		for(Cart c:l) {
			num=num+1;
			c.getId();//为了消除黄色箭头
		}
		if(num!=0) {
			int totalCount=num;
			//计算多少页
			int totalpage=totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize+1);
			pageModel.setTotalPage(totalpage);
		}
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("user_id", userid);
		map.put("pageNo", ((pageNo-1)*pageSize));
		map.put("pageSize", pageSize);
		
		List<Cart> list=session.selectList("dp.shop.Cart.findUserCart", map);
		
		pageModel.setData(list);
		
		session.commit();
		MybatisUtils.close(session);

		return pageModel;
	}

	@Override
	public int addUserCart(Integer userid, Cart cart) {
		// TODO Auto-generated method stub

		SqlSession session=factory.openSession(false);

		int num=session.insert("dp.shop.Cart.addUserCart", cart);
		
		//6，返回结果
		session.commit();
		//7，关闭SqlSession
		session.close();

		return num;
	}
	
	@Override
	public int pd(Integer userid, Integer product_id) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(false);
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("user_id", userid);
		map.put("product_id", product_id);
		int num=session.selectOne("dp.shop.Cart.PanDuan", map);
		MybatisUtils.close(session);
		return num;
	}
	@Override
	public int updataUserCartByUseridAndProduct_id(Integer userid, Integer product_id, Integer quantity) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(false);
		
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("user_id", userid);
		map.put("product_id", product_id);
		map.put("quantity", quantity);
		int num =session.update("dp.shop.Cart.updataUserCartByUseridAndProduct_id", map);
		
		session.commit();
		MybatisUtils.close(session);
		return num;
	}

	@Override
	public int deletUserCartByUseridAndProduct_id(Integer userid, Integer product_id) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(false);
		
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("user_id",userid);
		map.put("product_id", product_id);
		int num= session.delete("dp.shop.Cart.deletUserCartByUseridAndProduct_id", map);
		
		session.commit();
		MybatisUtils.close(session);
		
		return num;
	}

	@Override
	public int updataUserCartCheckedByUseridAndProduct_id(Integer userid, Integer product_id, Integer checked) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(false);
		
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("user_id", userid);
		map.put("product_id", product_id);
		map.put("checked", checked);
		int num =session.update("dp.shop.Cart.updataUserCartCheckedByUseridAndProduct_id", map);
		
		session.commit();
		MybatisUtils.close(session);
		return num;
	}

	@Override
	public List<Cart> findAllUserCart(Integer userid) {
		SqlSession session=factory.openSession(false);
		List<Cart> list=session.selectList("dp.shop.Cart.findAllUserCart", userid);
		return list;
		
	}

	@Override
	/**
	 * 已弃用
	 * */
	public int updataAllUserCartCheckedByUserid(Integer userid, Integer checked) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(false);
		
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("user_id", userid);
		map.put("checked", checked);
		int num =session.update("dp.shop.Cart.updataAllUserCartCheckedByUserid", map);
		session.commit();
		MybatisUtils.close(session);
		return num;
	}

	@Override
	public List<Cart> findCartListByUserid(Integer user_id) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession();
		
		List<Cart> list=session.selectList("dp.shop.Cart.findCartListByUserid", user_id);
		session.close();
		
		return list;
	}

	@Override
	public int findUserCartdequantity(Integer userid) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession();
		int sum=0;
		String num=session.selectOne("dp.shop.Cart.findUserCartdequantity", userid);
		session.close();
		if(num==null) {
			return sum;
		}else {
			sum=Integer.parseInt(num);
			return sum;
		}

	}




}
