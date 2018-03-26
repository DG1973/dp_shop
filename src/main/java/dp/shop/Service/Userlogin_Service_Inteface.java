package dp.shop.Service;

import dp.shop.Entity.User;

public interface Userlogin_Service_Inteface {
	
	User login(String username,String password);
	
	int updateTokenByUserId(Integer userid,String token);
	
	User findUserByToken(String token);
}
