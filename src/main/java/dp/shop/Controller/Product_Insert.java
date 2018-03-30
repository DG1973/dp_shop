package dp.shop.Controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dp.shop.Entity.Category;
import dp.shop.Entity.Product;
import dp.shop.Service.Shop_Service_Interface;
import dp.shop.Service.Imp.Shop_Service_Imp;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class Product_Add
 */
@WebServlet("/mng/Product_Add")
public class Product_Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product_Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//实例化
		//Shop_Service_Interface shop= Shop_Service_Imp.getShopService();
		WebApplicationContext webApplicationContext= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		Shop_Service_Interface shop=webApplicationContext.getBean(Shop_Service_Imp.class);
		List<Category> category=shop.findAllCategory();
		//获取Category的list集合
		request.setAttribute("category", category);
		//跳转页面
		request.getRequestDispatcher("Product/shop_product_add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//获取表单值
		String id=request.getParameter("id");
		String category_id=request.getParameter("category_id");
		String name=request.getParameter("name");
		String subtitle=request.getParameter("subtitle");
		String main_image=request.getParameter("main_image");
		String sub_images=request.getParameter("sub_images");
		String detail=request.getParameter("detail");
		String price=request.getParameter("price");
		String stock=request.getParameter("stock");
		String status=request.getParameter("status");

		Product product =null;
		Shop_Service_Interface shops_product=null;

		try {
			product=new Product(1,Integer.parseInt(category_id),name, subtitle,main_image,sub_images,detail,new BigDecimal(price), Integer.parseInt(stock),Integer.parseInt(status),new Date(),new Date());
			//shops_product =Shop_Service_Imp.getShopService();
			WebApplicationContext webApplicationContext= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
			shops_product=webApplicationContext.getBean(Shop_Service_Imp.class);
			
		}catch(NumberFormatException e) {
			doGet(request, response);
		}
		int num=shops_product.addProduct(product);
		if(num>0) {
			request.getRequestDispatcher("Product_Servlet?pageNo=1").forward(request, response);
		}else {
			request.getRequestDispatcher("mng/ShiBai.jsp").forward(request, response);
		}
	}
}

