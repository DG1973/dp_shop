package dp.shop.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dp.shop.Entity.Category;
import dp.shop.Entity.PageModel;
import dp.shop.Service.Shop_Service_Interface;
import dp.shop.Service.Imp.Shop_Service_Imp;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class Categoty_Servlet
 */
@WebServlet("/mng/Categoty_Servlet")
public class Categoty_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Categoty_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageNo=request.getParameter("pageNo");
		//Shop_Service_Interface shop=Shop_Service_Imp.getShopService();
		WebApplicationContext webApplicationContext= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		Shop_Service_Interface shop=webApplicationContext.getBean(Shop_Service_Imp.class);
	    try {
	    	 PageModel<Category>  pageModel=shop.findCategoryByPage(Integer.parseInt(pageNo),5);
	         request.setAttribute("pageModel", pageModel);
	    	 request.getRequestDispatcher("Category/shop_category.jsp").forward(request, response);
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
