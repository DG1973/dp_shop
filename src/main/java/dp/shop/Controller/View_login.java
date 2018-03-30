package dp.shop.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dp.shop.Dao.Userlogin_Dao_Interface;
import dp.shop.Dao.Imp.Login_Dao_Imp;
import dp.shop.Entity.User;
import dp.shop.Entity.VO.UserVO;
import dp.shop.MD5Utils.MD5Utils;
import dp.shop.Service.Userlogin_Service_Inteface;
import dp.shop.Service.Imp.Login_Serviec_Imp;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


/**
 * Servlet implementation class stLogin
 */
@WebServlet("/view/login.do")
public class View_login extends HttpServlet {
	
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 6817431542858738739L;


	/**
     * @see HttpServlet#HttpServlet()
     */
    public View_login() {
        super();

    }

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//一、创建会话
		HttpSession session= request.getSession();
		session.setMaxInactiveInterval(7*24*3600);
		
		String token=null;
		User user=null;
		UserVO vo=new UserVO();
		String username=null;
		String password=null;
		String callback=request.getParameter("callback");
		//Userlogin_Dao_Interface logindao=new Login_Dao_Imp();
		//Userlogin_Service_Inteface loginPD =new Login_Serviec_Imp();
		WebApplicationContext webApplicationContext=WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		Userlogin_Dao_Interface logindao=webApplicationContext.getBean(Login_Dao_Imp.class);
		Userlogin_Service_Inteface loginPD =webApplicationContext.getBean(Login_Serviec_Imp.class);
		
		username=request.getParameter("username");
		password=request.getParameter("password");

		int  num =logindao.checkUserName(username);
		
		//检测用户名是否存在 
		if(num>0) {
			//匹配账号密码
			user= logindao.findUserByUsernameAndPassword(username, password);
			//System.out.println(username+password);
			//System.out.println(user);
		}else {
			vo.setErrno(UserVO.LOGIN_NON);
			vo.setMessage("账户不存在");		
			Gson gson=new Gson();
			String str=gson.toJson(vo);
			response.getWriter().write(callback+"("+str+")");
			return;
		}
		
		//二、创建cookie数组
		Cookie[] cookie=request.getCookies();
	
		//三、判断数组cookie是否有值
		if(cookie!=null) {
			//遍历数组cookie
			for(Cookie c:cookie) {
				if(c.getName().equals("token")) {
					token=c.getValue();
				}
			}
		}
		
		//四、如果账号密码正确登录成功
		/*if(token!=null) {
			username=request.getParameter("zhanghao");
			password=request.getParameter("password");
			user=loginPD.login(username, password);
			vo.setUser(user);
			vo.setErrno(UserVO.LOGIN_SUCC);
			vo.setMessage("登录成功");
			
			Gson gson=new Gson();
			String str=gson.toJson(vo);
			System.out.println(vo.getUser());
			response.getWriter().write(callback+"("+str+")");
			return;
		}*/
		
		//五、获取表单中输入的账号密码
		if(user!=null) {//登陆成功
			//令牌
			token=MD5Utils.GetMD5Code(username+password);
			//为Cookie赋值
			Cookie token_cookie=new Cookie("token",token);
			//设置Cookie超时时间
			token_cookie.setMaxAge(7*24*3600);		
			//设置Cookie的应用路径
			token_cookie.setPath(request.getContextPath());
			//将Cookie添加到响应头
			response.addCookie(token_cookie);
			//将token添加到数据库
			loginPD.updateTokenByUserId(user.getId(),token);
			//将user加入会话中
			
			session.setAttribute("user", user);
			System.out.println(session.getAttribute("user"));
			System.out.println(session.getId());
			
			
			vo.setUser(user);
			vo.setErrno(UserVO.LOGIN_SUCC);
			vo.setMessage("登录成功");
			
			Gson gson=new Gson();
			String str=gson.toJson(vo);
			
			response.getWriter().write(callback+"("+str+")");
			//请求派送
			//request.getRequestDispatcher("ChengGong.jsp").forward(request, response);
		}else {
			
			vo=new UserVO();
			vo.setErrno(UserVO.LOGIN_FAIL);
			vo.setMessage("登录失败,密码错误");
			
			Gson gson=new Gson();
			String str=gson.toJson(vo);
			
			response.getWriter().write(callback+"("+str+")");
			
		}
	}
	
}


