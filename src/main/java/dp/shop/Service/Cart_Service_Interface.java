package dp.shop.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dp.shop.Entity.Cart;
import dp.shop.Entity.PageModel;
import dp.shop.Entity.VO.CartVO;

public interface Cart_Service_Interface {
	/**
	 *1. ��ѯ���ﳵ
	 * ��ҳ��ѯ
	 * @param pageNo ҳ��
	 * @param pageSize һҳ������
	 * @param userid �û�id
	 * @return PageModel
	 * */
	PageModel<CartVO> findUserCart(HttpServletRequest request,Integer userid);
	
	
	/**
	 * 
	 *2.���ﳵ�����Ʒ
	 * @param userid �û�id
	 * @param cart ���ﳵ
	 * @return int
	 * */
	int addUserCart(Integer userid,HttpServletRequest request);
	
	
	/**
	 * 
	 * 3.�û��޸Ĺ��ﳵ�е���Ʒ����
	 * @param userid �û�id
	 * @param product_id ��Ҫ�޸ĵ���Ʒid
	 * @return int
	 * * */
	int updataUserCartByUseridAndProduct_id(Integer userid,HttpServletRequest request);
	int pd(Integer userid,Integer product_id);
	
	
	/**
	 * 4.�Ƴ����ﳵĳ����Ʒ
	 * @param userid �û�ID
	 * @param product_id ��Ҫ�Ƴ���Ʒid
	 * @return int
	 * * */
	int deletUserCartByUseridAndProduct_id(Integer userid,Integer product_id);
	
	
	/**
	 * 
	 * 5��6.���ﳵѡ��ĳ����Ʒ/ ���ﳵȡ��ѡ��ĳ����Ʒ
	 *  8��9.���ﳵȫѡ/ ���ﳵȡ��ȫѡ
	 * @param userid �û�ID
	 * @param product_id ��Ҫѡ��/ȡ��ѡ�е���Ʒid
	 * @param checked �Ƿ�ѡ�У�1Ϊѡ�У�0Ϊδѡ��
	 * @return int
	 * */
	int updataUserCartCheckedByUseridAndProduct_id(Integer userid,HttpServletRequest request);

	/**
	 * 7.��ѯ���ﳵ��Ĳ�Ʒ����
	 * @param userid �û�ID
	 * 
	 * */
	
	List<Cart> findAllUserCart(Integer userid);
	
	/**
	 * ��ѯ���ﳵ�б���ѡ��Ʒ������
	 * */
	int findUserCartdequantity(Integer userid);
	
	/**
	 *
	 * 
	 * */
	
	int updataAllUserCartCheckedByUserid(Integer userid,Integer checked);
	
	
	/**
	 * 
	 * ������
	 * */
	
	String SumPaument(Integer userid);

}
