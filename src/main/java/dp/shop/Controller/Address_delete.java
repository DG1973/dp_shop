package dp.shop.Controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dp.shop.Service.Address_Service_Interface;
import dp.shop.Service.Imp.Address_Service_Imp;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class Address_delete
 */
@WebServlet("/Address_delete")
public class Address_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Address_delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//获取页面数据
		String id =request.getParameter("id");
		String userid=request.getParameter("userid");
		//System.out.println(empnodel);
		//实例化 Emp_Service
		//Address_Service_Interface shop=Address_Service_Imp.getAddressService();

		//从spring框架中获取实例
		WebApplicationContext webApplicationContext=WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		Address_Service_Interface shop=webApplicationContext.getBean(Address_Service_Imp.class);

		//执行删除方法
		shop.deletAddressByUserid(Integer.parseInt(userid), Integer.parseInt(id));
		/*删除之后再次查询数据表		
		List<Emp> list= emp.findAllEmp();
		
		request.setAttribute("emps", list);*/
		request.getRequestDispatcher("Address_Servlet?pageNo=1").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
