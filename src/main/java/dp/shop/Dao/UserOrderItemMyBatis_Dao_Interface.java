package dp.shop.Dao;

import java.util.List;

import dp.shop.Entity.UserOrder;
import dp.shop.Entity.UserOrderItem;
import dp.shop.Exception.orderException;

public interface UserOrderItemMyBatis_Dao_Interface {
	/**
	 * 添加订单明细
	 * @param UserOrderItem
	 * @return int
	 * */
	int addOrderItem(List<UserOrderItem> userOrderItem) throws orderException ;
	
	
	/**
	 * 查询订单明细
	 * @param order_no 订单编号
	 * @return List<UserOrderItem> 订单明细
	 * */
	UserOrder findUserOrderItemByOrderNo(Integer user_id,Long order_no) throws orderException;
	
	
	
	
}
