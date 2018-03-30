package dp.shop.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dp.shop.Entity.Address;
import dp.shop.Entity.User;
import dp.shop.Service.Address_Service_Interface;
import dp.shop.Service.Imp.Address_Service_Imp;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class Categoty_Updata
 */
@WebServlet("/Address_Updata")
public class Address_Updata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Address_Updata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session= request.getSession();
		Object o=session.getAttribute("user");
		User user=null;
		Address address =null;
		String id=request.getParameter("id");
		//Address_Service_Interface addressByIdAndUser_id=Address_Service_Imp.getAddressService();
		//从spring框架中获取实例
		WebApplicationContext webApplicationContext= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		Address_Service_Interface addressByIdAndUser_id=webApplicationContext.getBean(Address_Service_Imp.class);
		if(o!=null&&o instanceof User) {
			user=(User) o;
		}
		if(user!=null) {
			try {
				address=addressByIdAndUser_id.findAddressByIdAndUser_id(Integer.parseInt(id), user.getId());
				if(address!=null) {
					request.setAttribute("address",address);
					request.getRequestDispatcher("view/admin/Address_updata.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("mng/ShiBai.jsp").forward(request, response);
				}
				
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}
		}else {
			
			response.sendRedirect("http://localhost:8080/dp_shop/login.jsp");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session= request.getSession();
		Object o=session.getAttribute("user");
		User user=null;
		Address address =null;
		Address_Service_Interface shops_address=null;
		if(o!=null&&o instanceof User) {
			user=(User) o;
		}
		if(user!=null) {
			String id=request.getParameter("id");
			String receiver_name=request.getParameter("receiver_name");
			String receiver_phone=request.getParameter("receiver_phone");
			String receiver_mobile=request.getParameter("receiver_mobile");
			String receiver_province=request.getParameter("receiver_province");
			String receiver_city=request.getParameter("receiver_city");
			String receiver_district=request.getParameter("receiver_district");
			String receiver_address=request.getParameter("receiver_address");
			String receiver_zip=request.getParameter("receiver_zip");
			try {
				address=new Address(Integer.parseInt(id), user.getId(), receiver_name, receiver_phone, receiver_mobile, receiver_province, receiver_city, receiver_district, receiver_address, receiver_zip, null, null);
				//shops_address =Address_Service_Imp.getAddressService();
				//从spring框架中获取实例
				WebApplicationContext webApplicationContext= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
				shops_address=webApplicationContext.getBean(Address_Service_Imp.class);


			}catch(NumberFormatException e) {
				doGet(request, response);
			}
			int num=shops_address.updataUserAddressByUserid(Integer.parseInt(id),user.getId() , address);
			if(num>0) {
				request.getRequestDispatcher("Address_Servlet?pageNo=1&userid="+user.getId()).forward(request, response);
			}else {
				request.getRequestDispatcher("mng/ShiBai.jsp").forward(request, response);
			}
		}else {
			
			response.sendRedirect("http://localhost:8080/dp_shop/login.jsp");
			
		}
	}

}
