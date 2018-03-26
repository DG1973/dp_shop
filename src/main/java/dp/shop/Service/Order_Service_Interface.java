package dp.shop.Service;

import javax.servlet.http.HttpServletRequest;

import dp.shop.Entity.PageModel;
import dp.shop.Entity.UserOrder;
import dp.shop.Entity.VO.OrderVO;
import dp.shop.Exception.orderException;

public interface Order_Service_Interface {
	/**
	 * �û��µ�
	 * @param user_id �û�id
	 * @param shipping_id ��ַid
	 * 
	 * 
	 * */
	
	UserOrder createOrder(Integer user_id,HttpServletRequest request) throws orderException;
	
	/**
	 * ��ҳ��ѯ
	 * @param pageNo ҳ��
	 * @param pageSize ��������
	 * @param user_id �û�id
	 * @return PageModel
	 * */
	public PageModel<OrderVO> findUserOrder(HttpServletRequest request, Integer user_id) throws orderException;
	
	/**
	 * 
	 * ���ݶ�����Ų�ѯ����(ʹ��ģ����ѯ)
	 * @param order_no �������
	 * @return ����
	 * 
	 * **/
	PageModel<OrderVO> findUserOrderDetailByOrderNo(HttpServletRequest request,Integer user_id) throws orderException;
	
	/**
	 * ��ѯ������ϸ
	 * @param Long order_no �������
	 * @return List<UserOrderItem> ������ϸ
	 * */
	OrderVO findUserOrderItemByOrderNo(Integer user_id,HttpServletRequest request) throws orderException;
	
	
	/**
	 * ���¶���״̬
	 * @param Long order_no �������
	 * @param Integer status
	 * **/
	
	int updateOrderByOrderNo(HttpServletRequest request) throws orderException;

}
