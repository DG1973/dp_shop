package dp.shop.Dao;

import java.util.List;
import dp.shop.Entity.Cart;
import dp.shop.Entity.PageModel;

public interface CartMyBatis_Dao_Interface {
	
	/**
	 *1. ��ѯ���ﳵ
	 * ��ҳ��ѯ
	 * @param pageNo ҳ��
	 * @param pageSize һҳ������
	 * @param userid �û�id
	 * @return PageModel
	 * */
	PageModel<Cart> findUserCart(Integer pageNo,Integer pageSize,Integer userid);
	
	
	/**
	 * 
	 *2.���ﳵ�����Ʒ
	 * @param userid �û�id
	 * @param cart ���ﳵ
	 * @return int
	 * */
	int addUserCart(Integer userid,Cart cart);
	
	
	/**
	 * 
	 * 3.�û��޸Ĺ��ﳵ�е���Ʒ����
	 * @param userid �û�id
	 * @param product_id ��Ҫ�޸ĵ���Ʒid
	 * @return int
	 * * */
	int updataUserCartByUseridAndProduct_id(Integer userid,Integer product_id,Integer quantity);
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
	 * @param userid �û�ID
	 * @param product_id ��Ҫѡ��/ȡ��ѡ�е���Ʒid
	 * @param checked �Ƿ�ѡ�У�1Ϊѡ�У�0Ϊδѡ��
	 * @return int
	 * */
	int updataUserCartCheckedByUseridAndProduct_id(Integer userid,Integer product_id,Integer checked);

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
	 * 8��9.���ﳵȫѡ/ ���ﳵȡ��ȫѡ
	 * 
	 * */
	
	int updataAllUserCartCheckedByUserid(Integer userid,Integer checked);
	
	/**
	 * ��ѯ�û����ﳵ����ѡ�����Ʒ
	 * 
	 * 
	 * */
	
	List<Cart> findCartListByUserid(Integer userid);
	
}
