package dp.shop.Dao;

import dp.shop.Entity.PageModel;
import dp.shop.Entity.UserOrder;
import dp.shop.Exception.orderException;

public interface UserOrderMyBatis_Dao_Interface {
	
	/**
	 * 添加订单
	 * @param UserOrder
	 * @return int
	 * */
	int addOrder(UserOrder userOrder) throws orderException ;
	
	/**
	 * 分页查询订单
	 * @param pageNo 页数
	 * @param pageSize 数据条数
	 * @param user_id 用户id
	 * @return PageModel
	 * */
	
	PageModel<UserOrder> findUserOrder(Integer pageNo,Integer pageSize,Integer user_id) throws orderException;
	
	/**
	 * 
	 * 根据订单编号查询订单(使用模糊查询)
	 * @param order_no 订单编号
	 * @return 订单
	 * 
	 * **/
	PageModel<UserOrder> findUserOrderDetailByOrderNo(Integer pageNo,Integer pageSize,Long order_no,Integer user_id) throws orderException;
	
	
	/**
	 * 更新订单状态
	 * @param order_no 订单编号
	 * 
	 * **/
	
	int updateOrderByOrderNo(Long order_no,Integer status) throws orderException;
	
	
	
}
