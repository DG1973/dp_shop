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
		//һ�������Ự
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
		
		//��������cookie����
		Cookie[] cookie=request.getCookies();
	
		//�����ж�����cookie�Ƿ���ֵ
		if(cookie!=null) {
			//��������cookie
			for(Cookie c:cookie) {
				if(c.getName().equals("token")) {
					token=c.getValue();
				}
			}
		}
		
		//�ġ�����˺�������ȷ��¼�ɹ�
		if(token!=null) {
			username=request.getParameter("zhanghao");
			password=request.getParameter("password");
			user=loginPD.login(username, password);
			response.sendRedirect("mng/index.jsp");
			return;
		}
		
		//�塢��ȡ����������˺�����
		if(user!=null) {//��½�ɹ�
			//����
			token=MD5Utils.GetMD5Code(username+password);
			//ΪCookie��ֵ
			Cookie token_cookie=new Cookie("token",token);
			//����Cookie��ʱʱ��
			token_cookie.setMaxAge(7*24*3600);		
			//����Cookie��Ӧ��·��
			token_cookie.setPath(request.getContextPath());
			//��Cookie��ӵ���Ӧͷ
			response.addCookie(token_cookie);
			loginPD.updateTokenByUserId(user.getId(),token);
			//�ض���
			session.setAttribute("user", user);
			response.sendRedirect("mng/index.jsp");
			//��������
			//request.getRequestDispatcher("ChengGong.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("mng/ShiBai.jsp").forward(request, response);
		}
	}
	
}


