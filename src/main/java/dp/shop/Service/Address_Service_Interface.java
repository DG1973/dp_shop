package dp.shop.Service;

import dp.shop.Entity.Address;
import dp.shop.Entity.PageModel;

public interface Address_Service_Interface {

	/**
	 * 添加用户收货地址
	 * @param userid 用户id
	 * @param address 地址对象
	 * @return int
	 * */
	int addAddress(Integer userid,Address address);
	
	/**
	 * 删除用户地址
	 * @param userid 用户ID
	 * @param id 地址id
	 * @return int
	 * * */
	int deletAddressByUserid(Integer userid,Integer id);
	
	/**
	 * 用户修改收货地址
	 * @param userid 用户id
	 * @param address 需要修改的address
	 * @return int
	 * * */
	int updataUserAddressByUserid(Integer id,Integer userid,Address address);
	
	/**
	 * 根据userid 查询 用户收货地址 分页查询
	 * 
	 * @param pageNo 页数
	 * @param Pageno 总页数
	 * @param userid 用户id
	 * 
	 * @return PageModel<Address>
	 * */
	
	PageModel<Address> findUserAddress(Integer pageNo,Integer pageSize,Integer userid);
	
	
	/**
	 * 根据id和userid 查询 用户收货地址 
	 * 	@param id 
	 * @param userid 用户id
	 * 
	 * @return Address
	 * */
	Address findAddressByIdAndUser_id(Integer id,Integer user_id);
}
