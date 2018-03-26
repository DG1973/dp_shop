package dp.shop.Dao;
import dp.shop.Entity.PageModel;
import dp.shop.Entity.User;

public interface Userlogin_Dao_Interface {
	/**
	 * У���û���
	 * */
	int  checkUserName(String username);
	/**
	 * �˶��û� 
	 * */
	User findUserByUsernameAndPassword(String username,String password);
	/**
	 * 
	 * �����û���token
	 * */
	int updateTokenByUserId(Integer userid,String token);
	/**
	 * ����token��ѯ�û�
	 * */
	User findUserByToken(String token);
	/**
	 * ����û�
	 * */
	int addUser(User user);
	/**
	 * 
	 * */
	PageModel<User> findAllUser(Integer pageNo, Integer pageSize);
	int findAllUserCount();
	
}
