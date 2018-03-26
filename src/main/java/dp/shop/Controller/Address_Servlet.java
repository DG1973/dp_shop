package dp.shop.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dp.shop.Entity.Address;
import dp.shop.Entity.PageModel;
import dp.shop.Service.Address_Service_Interface;
import dp.shop.Service.Imp.Address_Service_Imp;

/**
 * Servlet implementation class Address_Servlet
 */
@WebServlet("/Address_Servlet")
public class Address_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Address_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String pageNo=request.getParameter("pageNo");
		String userid=request.getParameter("userid");
		
		Address_Service_Interface shop=Address_Service_Imp.getAddressService();
	    try {
	    	 PageModel<Address>  pageModel=shop.findUserAddress((Integer.parseInt(pageNo)), 2, Integer.parseInt(userid));
	    	 //System.out.println(pageModel.getData());
	         request.setAttribute("pageModel", pageModel);
	         request.setAttribute("userid", userid);
	    	 request.getRequestDispatcher("view/admin/Address_find.jsp").forward(request, response);
	    }catch(NumberFormatException e) {
	    	e.printStackTrace();
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
