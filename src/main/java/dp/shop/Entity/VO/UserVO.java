package dp.shop.Entity.VO;

import java.io.Serializable;

import dp.shop.Entity.User;

public class UserVO implements Serializable {
	
	public int getErrno() {
		return errno;
	}
	public void setErrno(int errno) {
		this.errno = errno;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 8967503257818660249L;
	
	private int errno;
	private String message;
	private User user;
	/**
	 * 0：成功
	 * 1：密码错误
	 * 2：账户不存在
	 * */
	public static final int LOGIN_SUCC=0;
	public static final int LOGIN_FAIL=1;
	public static final int LOGIN_NON=2;



	
	
	

}
