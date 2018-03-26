package dp.shop.Service;

import dp.shop.Entity.Address;
import dp.shop.Entity.PageModel;

public interface Address_Service_Interface {

	/**
	 * �����û��ջ���ַ
	 * @param userid �û�id
	 * @param address ��ַ����
	 * @return int
	 * */
	int addAddress(Integer userid,Address address);
	
	/**
	 * ɾ���û���ַ
	 * @param userid �û�ID
	 * @param id ��ַid
	 * @return int
	 * * */
	int deletAddressByUserid(Integer userid,Integer id);
	
	/**
	 * �û��޸��ջ���ַ
	 * @param userid �û�id
	 * @param address ��Ҫ�޸ĵ�address
	 * @return int
	 * * */
	int updataUserAddressByUserid(Integer id,Integer userid,Address address);
	
	/**
	 * ����userid ��ѯ �û��ջ���ַ ��ҳ��ѯ
	 * 
	 * @param pageNo ҳ��
	 * @param Pageno ��ҳ��
	 * @param userid �û�id
	 * 
	 * @return PageModel<Address>
	 * */
	
	PageModel<Address> findUserAddress(Integer pageNo,Integer pageSize,Integer userid);
	
	
	/**
	 * ����id��userid ��ѯ �û��ջ���ַ 
	 * 	@param id 
	 * @param userid �û�id
	 * 
	 * @return Address
	 * */
	Address findAddressByIdAndUser_id(Integer id,Integer user_id);
}