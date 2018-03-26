package dp.shop.Service.Imp;

import dp.shop.Dao.Userlogin_Dao_Interface;
import dp.shop.Dao.Imp.Login_Dao_Imp;
import dp.shop.Dao.Imp.UserLoginMyBatis_Dao_Impl;
import dp.shop.Entity.User;
import dp.shop.Service.Userlogin_Service_Inteface;

public class Login_Serviec_Imp implements Userlogin_Service_Inteface {
	
	Userlogin_Dao_Interface logindao=new UserLoginMyBatis_Dao_Impl();
	
	public User login(String username, String password) {
		int  num =logindao.checkUserName(username);
		//ºÏ≤‚”√ªß√˚ «∑Ò¥Ê‘⁄ 
		if(num>0) {
			//∆•≈‰’À∫≈√‹¬Î
			return logindao.findUserByUsernameAndPassword(username, password);
		}else {
			
			return null;
		}
	}

	@Override
	public int updateTokenByUserId(Integer userid, String token) {
		return logindao.updateTokenByUserId(userid, token);
	}

	@Override
	public User findUserByToken(String token) {
		return logindao.findUserByToken(token);
	}
	

}
