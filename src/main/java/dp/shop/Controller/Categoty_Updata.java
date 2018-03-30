package dp.shop.Controller;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dp.shop.Entity.Category;
import dp.shop.Service.Shop_Service_Interface;
import dp.shop.Service.Imp.Shop_Service_Imp;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class Categoty_Updata
 */
@WebServlet("/mng/Categoty_Updata")
public class Categoty_Updata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Categoty_Updata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//获取商品类别编号
		String id=request.getParameter("id");
		//Shop_Service_Interface categoryByid=Shop_Service_Imp.getShopService();
		WebApplicationContext webApplicationContext= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		Shop_Service_Interface categoryByid=webApplicationContext.getBean(Shop_Service_Imp.class);
		try {
			Category category=categoryByid.findCategoryById(Integer.parseInt(id));
			if(category!=null) {
				request.setAttribute("category",category);
				request.getRequestDispatcher("Category/shop_category_updata.jsp").forward(request, response);
			}
			
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//获取表单值
		String id=request.getParameter("id");
		
		String parent_id=request.getParameter("parent_id");
		String name=request.getParameter("name");
		String status=request.getParameter("status");
		String sort_order=request.getParameter("sort_order");

		Category category =null;
		Shop_Service_Interface shops_product=null;

		try {
			category=new Category(Integer.parseInt(id),Integer.parseInt(parent_id),name,Integer.parseInt(status),Integer.parseInt(sort_order),new Date(),new Date());


			WebApplicationContext webApplicationContext= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
			shops_product=webApplicationContext.getBean(Shop_Service_Imp.class);
		}catch(NumberFormatException e) {
			doGet(request, response);
		}
		//System.out.println(categoty);
		int num=shops_product.updateCategory(category);
		//System.out.println(num);
		if(num>0) {
			request.getRequestDispatcher("Categoty_Servlet?pageNo=1").forward(request, response);
		}else {
			request.getRequestDispatcher("user/ShiBai.jsp").forward(request, response);
		}
	}

}
