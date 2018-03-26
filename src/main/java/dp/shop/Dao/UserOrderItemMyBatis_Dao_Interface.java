package dp.shop.Dao;

import java.util.List;

import dp.shop.Entity.UserOrder;
import dp.shop.Entity.UserOrderItem;
import dp.shop.Exception.orderException;

public interface UserOrderItemMyBatis_Dao_Interface {
	/**
	 * ��Ӷ�����ϸ
	 * @param UserOrderItem
	 * @return int
	 * */
	int addOrderItem(List<UserOrderItem> userOrderItem) throws orderException ;
	
	
	/**
	 * ��ѯ������ϸ
	 * @param order_no �������
	 * @return List<UserOrderItem> ������ϸ
	 * */
	UserOrder findUserOrderItemByOrderNo(Integer user_id,Long order_no) throws orderException;
	
	
	
	
}
