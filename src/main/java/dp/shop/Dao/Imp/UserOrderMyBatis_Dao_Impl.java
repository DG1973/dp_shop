package dp.shop.Dao.Imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import dp.shop.Common.MybatisUtils;
import dp.shop.Dao.UserOrderMyBatis_Dao_Interface;
import dp.shop.Entity.Cart;
import dp.shop.Entity.PageModel;
import dp.shop.Entity.UserOrder;
import dp.shop.Exception.orderException;

public class UserOrderMyBatis_Dao_Impl implements UserOrderMyBatis_Dao_Interface {

	@Override
	public int addOrder(UserOrder userOrder) throws orderException {
		// TODO Auto-generated method stub
		SqlSessionFactory  factory=MybatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		
		int num= session.insert("dp.shop.UserOrder.addOrder", userOrder);
				
		session.commit();
		MybatisUtils.close(session);
		return num;
	}

	@Override
	public PageModel<UserOrder> findUserOrder(Integer pageNo, Integer pageSize, Integer user_id) throws orderException {
		// TODO Auto-generated method stub
		PageModel<UserOrder> pageModel=new PageModel<UserOrder>();
		SqlSessionFactory  factory=MybatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(false);
		Integer num=session.selectOne("dp.shop.UserOrder.findAllUserOrder", user_id);
		int totalCount;
		if(num==null) {
			totalCount=0;
			return null;
		}else {
			totalCount=num;
		}
		int totalpage=totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize+1);
		pageModel.setTotalPage(totalpage);
		
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("user_id", user_id);
		map.put("offset", ((pageNo-1)*pageSize));
		map.put("pageSize", pageSize);
		
		List<UserOrder> list=session.selectList("dp.shop.UserOrder.findUserOrder", map);
		
		pageModel.setData(list);
		
		session.commit();
		MybatisUtils.close(session);

		return pageModel;
	}

	@Override
	public PageModel<UserOrder> findUserOrderDetailByOrderNo(Integer pageNo,Integer pageSize,Long order_no,Integer user_id) throws orderException {
		// TODO Auto-generated method stub
		PageModel<UserOrder> pageModel=new PageModel<UserOrder>();
		SqlSessionFactory  factory=MybatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(false);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("user_id", user_id);
		if(order_no==null) {
			map.put("order_no",null);
		}else {
			String _order_no="%"+order_no+"%";
			map.put("order_no",_order_no);
		}
		map.put("offset", ((pageNo-1)*pageSize));
		map.put("pageSize", pageSize);
		//System.out.println(map.get("order_no"));
		//System.out.println(map.get("user_id"));
		Integer num=session.selectOne("dp.shop.UserOrder.findAllUserOrderByOrderNo", map);
		int totalCount;
		if(num==null) {
			totalCount=0;
			return null;
		}else {
			totalCount=num;
		}
		int totalpage=totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize+1);
		pageModel.setTotalPage(totalpage);

		List<UserOrder> list=session.selectList("dp.shop.UserOrder.findUserOrderDetailByOrderNo", map);
		
		pageModel.setData(list);
		
		session.commit();
		MybatisUtils.close(session);

		return pageModel;
	}

	@Override
	public int updateOrderByOrderNo(Long order_no,Integer status) throws orderException {
		// TODO Auto-generated method stub
		SqlSessionFactory  factory=MybatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(false);
		Map<String,Object> map=new HashMap<String,Object>();
		
		map.put("order_no", order_no);
		map.put("status", status);
		
		int num=session.update("dp.shop.UserOrder.updateOrderByOrderNo", map);
		
		session.commit();
		MybatisUtils.close(session);
		return num;
	}
	
	

}
