package dp.shop.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dp.shop.Entity.User;
import dp.shop.Service.Userlogin_Service_Inteface;
import dp.shop.Service.Imp.Login_Serviec_Imp;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet Filter implementation class loginfilter
 */
@WebFilter("/mng/*")
public class loginfilter implements Filter {

    /**
     * Default constructor. 
     */
    public loginfilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest _request, ServletResponse _response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest request=(HttpServletRequest) _request;
		HttpServletResponse response=(HttpServletResponse) _response;

		//一、创建会话
		HttpSession session= request.getSession();
				
		String token_cookie=null;
		//String token=null;
		User user=null;
		//二、创建cookie数组
		Cookie[] cookie=request.getCookies();
		//Userlogin_Service_Inteface loginPD =new Login_Serviec_Imp();

		WebApplicationContext webApplicationContext= WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		Userlogin_Service_Inteface loginPD =webApplicationContext.getBean(Login_Serviec_Imp.class);
		//三、判断数组cookie是否有值
		if(cookie!=null) {
			//遍历数组cookie
			for(Cookie c:cookie) {
				if(c.getName().equals("token")) {
					token_cookie=c.getValue();
				}
			}
		}
		//四、如果账号密码正确登录成功
		if(token_cookie!=null) {
			user=loginPD.findUserByToken(token_cookie); 
			if(user!=null) {
				session.setAttribute("user", user);
				chain.doFilter(request, response);
			}else {
				response.sendRedirect("http://localhost:8080/dp_shop/login.jsp");
			}
		}else {
			response.sendRedirect("http://localhost:8080/dp_shop/login.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
