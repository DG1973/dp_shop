package dp.shop.Dao.Imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import dp.shop.Common.MybatisUtils;
import dp.shop.Dao.UserOrderItemMyBatis_Dao_Interface;
import dp.shop.Entity.UserOrder;
import dp.shop.Entity.UserOrderItem;
import dp.shop.Exception.orderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserOrderItemMyBatis_Dao_Impl implements UserOrderItemMyBatis_Dao_Interface {

	@Autowired
	SqlSessionFactory  factory;

	public void setFactory(SqlSessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public int addOrderItem(List<UserOrderItem> userOrderItem) throws orderException {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(false);
		
		int num= session.insert("dp.shop.UserOrderItem.addOrderItem", userOrderItem);
					
		session.commit();
		session.close();
		return num;

	}

	@Override
	public UserOrder findUserOrderItemByOrderNo(Integer user_id,Long order_no) throws orderException {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(false);
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("user_id", user_id);
		map.put("order_no", order_no);
		//System.out.println("========");
		UserOrder userOrder=session.selectOne("dp.shop.UserOrderItem.findUserOrderItem", map);

		session.close();
		
		return userOrder;
	}



}
