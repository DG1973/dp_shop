package dp.shop.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class User_quit
 */
@WebServlet("/User_quit")
public class User_quit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_quit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//setp1:需要将登陆信息user从会话中移除
		HttpSession session=request.getSession();
		session.removeAttribute("user");
		
		//step2：把nuername和password的cookie移除
		Cookie[] cookies =request.getCookies();
		for(Cookie c:cookies) {
			if(c.getName().equals("token")) {
				Cookie c1=new Cookie(c.getName(),c.getValue());
				c1.setMaxAge(0);
				c1.setPath(request.getContextPath());
				response.addCookie(c1);
			}
		}
		//step3：页面跳转到登录界面
		//response.sendRedirect("http://localhost:8080/dp_shop/login.jsp");
		response.getWriter().print("<script>top.location.href=\"http://localhost:8080/dp_shop/login.jsp\"</script>");
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
