package dp.shop.Service.Imp;

import dp.shop.Dao.Userlogin_Dao_Interface;
import dp.shop.Dao.Imp.Login_Dao_Imp;
import dp.shop.Dao.Imp.UserLoginMyBatis_Dao_Impl;
import dp.shop.Entity.User;
import dp.shop.Service.Userlogin_Service_Inteface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Login_Serviec_Imp implements Userlogin_Service_Inteface {
	@Autowired
	Userlogin_Dao_Interface logindao;

	public void setLogindao(Userlogin_Dao_Interface logindao) {
		this.logindao = logindao;
	}
	@Override
	public User login(String username, String password) {
		int  num =logindao.checkUserName(username);
		//����û����Ƿ����
		if(num>0) {
			//ƥ���˺�����
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
