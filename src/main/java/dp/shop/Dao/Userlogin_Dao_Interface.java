package dp.shop.Dao;
import dp.shop.Entity.PageModel;
import dp.shop.Entity.User;

public interface Userlogin_Dao_Interface {
	/**
	 * 校验用户名
	 * */
	int  checkUserName(String username);
	/**
	 * 核对用户 
	 * */
	User findUserByUsernameAndPassword(String username,String password);
	/**
	 * 
	 * 更新用户的token
	 * */
	int updateTokenByUserId(Integer userid,String token);
	/**
	 * 根据token查询用户
	 * */
	User findUserByToken(String token);
	/**
	 * 添加用户
	 * */
	int addUser(User user);
	/**
	 * 
	 * */
	PageModel<User> findAllUser(Integer pageNo, Integer pageSize);
	int findAllUserCount();
	
}
