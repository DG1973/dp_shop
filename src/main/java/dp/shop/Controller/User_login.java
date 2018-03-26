package dp.shop.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dp.shop.Entity.User;
import dp.shop.MD5Utils.MD5Utils;
import dp.shop.Service.Userlogin_Service_Inteface;
import dp.shop.Service.Imp.Login_Serviec_Imp;


/**
 * Servlet implementation class stLogin
 */
@WebServlet("/login.do")
public class User_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_login() {
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
		String username=null;
		String password=null;
		
		Userlogin_Service_Inteface loginPD =new Login_Serviec_Imp();
		username=request.getParameter("zhanghao");
		password=request.getParameter("password");

		user=loginPD.login(username, password);
		
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
		if(token!=null) {
			username=request.getParameter("zhanghao");
			password=request.getParameter("password");
			user=loginPD.login(username, password);
			response.sendRedirect("mng/index.jsp");
			return;
		}
		
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
			loginPD.updateTokenByUserId(user.getId(),token);
			//重定向
			session.setAttribute("user", user);
			response.sendRedirect("mng/index.jsp");
			//请求派送
			//request.getRequestDispatcher("ChengGong.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("mng/ShiBai.jsp").forward(request, response);
		}
	}
	
}


