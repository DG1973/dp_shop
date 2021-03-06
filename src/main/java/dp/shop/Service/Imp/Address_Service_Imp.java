package dp.shop.Service.Imp;

import dp.shop.Dao.AddressMyBatis_Dao_Interface;
import dp.shop.Dao.Imp.AddressMybatis_Dao;
import dp.shop.Entity.Address;
import dp.shop.Entity.PageModel;
import dp.shop.Service.Address_Service_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Address_Service_Imp implements Address_Service_Interface {

	@Autowired
	AddressMyBatis_Dao_Interface address_dao_imp;
	
	@Override
	public int addAddress(Integer userid, Address address) {
		// TODO Auto-generated method stub

		return address_dao_imp.addAddress(userid, address);
	}

	@Override
	public int deletAddressByUserid(Integer userid, Integer id) {
		// TODO Auto-generated method stub

		return address_dao_imp.deletAddressByUserid(userid, id);
	}

	@Override
	public int updataUserAddressByUserid(Integer id, Integer userid, Address address) {
		// TODO Auto-generated method stub

		return address_dao_imp.updataUserAddressByUserid(id, userid, address);
	}

	@Override
	public PageModel<Address> findUserAddress(Integer pageNo, Integer pageSize, Integer userid) {
		// TODO Auto-generated method stub

		return address_dao_imp.findUserAddress(pageNo, pageSize, userid);
	}
	@Override
	public Address findAddressByIdAndUser_id(Integer id, Integer user_id) {
		// TODO Auto-generated method stub

		return address_dao_imp.findAddressByIdAndUser_id(id, user_id);
	}

}
