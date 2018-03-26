package dp.shop.Entity.VO;

import java.text.SimpleDateFormat;
import java.util.Date;

import dp.shop.Entity.User;

public class UserManageVO {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	private int id ;	 //用户id
	private String username;	//用户名
	private String password;	//用户密码					
	private String email;		//邮箱									
	private String phone;//手机号
	private String question;//找回密码问题
	private String answer;//找回密码答案
	private String role;//角色 0-管理员，1-普通用户
	private String create_time;//创建时间
	private String update_time;//最后一次更新时间
	public UserManageVO(int id, String username, String password, String email, String phone, String question,
			String answer, String role, String create_time, String update_time) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.question = question;
		this.answer = answer;
		this.role = role;
		this.create_time = create_time;
		this.update_time = update_time;
	}
	public UserManageVO() {
		super();
	}
	
	public UserManageVO UserIntoUserManageVO(User user) {
		
		UserManageVO userManageVO=new UserManageVO();
		this.id = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.email = user.getEmail();
		this.phone = user.getPhone();
		this.question =user.getQuestion();
		this.answer =user.getAnswer();
		
		if(user.getRole()==0) {
			this.role = "管理员";
		}else if(user.getRole()==1) {
			this.role = "普通用户";
		}else {
			this.role = "有误";
		}
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		//创建时间
				Date _create_time=user.getCreate_time();
				//System.out.println(_create_time);
				if(_create_time!=null) {	
					this.create_time = format.format(_create_time.getTime());
				}else {
					this.create_time =null;
				}
				//更新时间
				Date _update_time=user.getUpdate_time();
				if(_update_time!=null) {	
					this.update_time = format.format(_update_time.getTime());
				}else {
					this.update_time =null;
				}
		return userManageVO;
		
	}
		
	
}
