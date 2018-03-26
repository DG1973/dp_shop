package dp.shop.Service;

import javax.servlet.http.HttpServletRequest;

import dp.shop.Entity.PageModel;
import dp.shop.Entity.UserOrder;
import dp.shop.Entity.VO.OrderVO;
import dp.shop.Exception.orderException;

public interface Order_Service_Interface {
	/**
	 * 用户下单
	 * @param user_id 用户id
	 * @param shipping_id 地址id
	 * 
	 * 
	 * */
	
	UserOrder createOrder(Integer user_id,HttpServletRequest request) throws orderException;
	
	/**
	 * 分页查询
	 * @param pageNo 页数
	 * @param pageSize 数据条数
	 * @param user_id 用户id
	 * @return PageModel
	 * */
	public PageModel<OrderVO> findUserOrder(HttpServletRequest request, Integer user_id) throws orderException;
	
	/**
	 * 
	 * 根据订单编号查询订单(使用模糊查询)
	 * @param order_no 订单编号
	 * @return 订单
	 * 
	 * **/
	PageModel<OrderVO> findUserOrderDetailByOrderNo(HttpServletRequest request,Integer user_id) throws orderException;
	
	/**
	 * 查询订单明细
	 * @param Long order_no 订单编号
	 * @return List<UserOrderItem> 订单明细
	 * */
	OrderVO findUserOrderItemByOrderNo(Integer user_id,HttpServletRequest request) throws orderException;
	
	
	/**
	 * 更新订单状态
	 * @param Long order_no 订单编号
	 * @param Integer status
	 * **/
	
	int updateOrderByOrderNo(HttpServletRequest request) throws orderException;

}
