package dp.shop.Dao;

import dp.shop.Entity.PageModel;
import dp.shop.Entity.UserOrder;
import dp.shop.Exception.orderException;

public interface UserOrderMyBatis_Dao_Interface {
	
	/**
	 * ��Ӷ���
	 * @param UserOrder
	 * @return int
	 * */
	int addOrder(UserOrder userOrder) throws orderException ;
	
	/**
	 * ��ҳ��ѯ����
	 * @param pageNo ҳ��
	 * @param pageSize ��������
	 * @param user_id �û�id
	 * @return PageModel
	 * */
	
	PageModel<UserOrder> findUserOrder(Integer pageNo,Integer pageSize,Integer user_id) throws orderException;
	
	/**
	 * 
	 * ���ݶ�����Ų�ѯ����(ʹ��ģ����ѯ)
	 * @param order_no �������
	 * @return ����
	 * 
	 * **/
	PageModel<UserOrder> findUserOrderDetailByOrderNo(Integer pageNo,Integer pageSize,Long order_no,Integer user_id) throws orderException;
	
	
	/**
	 * ���¶���״̬
	 * @param order_no �������
	 * 
	 * **/
	
	int updateOrderByOrderNo(Long order_no,Integer status) throws orderException;
	
	
	
}
