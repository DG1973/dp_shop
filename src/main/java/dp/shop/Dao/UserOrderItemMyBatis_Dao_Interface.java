package dp.shop.Dao;

import java.util.List;

import dp.shop.Entity.UserOrder;
import dp.shop.Entity.UserOrderItem;
import dp.shop.Exception.orderException;

public interface UserOrderItemMyBatis_Dao_Interface {
	/**
	 * Ìí¼Ó¶©µ¥Ã÷Ï¸
	 * @param UserOrderItem
	 * @return int
	 * */
	int addOrderItem(List<UserOrderItem> userOrderItem) throws orderException ;
	
	
	/**
	 * ²éÑ¯¶©µ¥Ã÷Ï¸
	 * @param order_no ¶©µ¥±àºÅ
	 * @return List<UserOrderItem> ¶©µ¥Ã÷Ï¸
	 * */
	UserOrder findUserOrderItemByOrderNo(Integer user_id,Long order_no) throws orderException;
	
	
	
	
}
