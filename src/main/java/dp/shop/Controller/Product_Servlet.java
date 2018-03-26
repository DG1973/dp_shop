package dp.shop.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dp.shop.Entity.PageModel;
import dp.shop.Entity.Product;
import dp.shop.Service.Shop_Service_Interface;
import dp.shop.Service.Imp.Shop_Service_Imp;
/**
 * Servlet implementation class Product_Servlet
 */
@WebServlet("/mng/Product_Servlet")
public class Product_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		/*
		//实例化控制层	
		Shop_Service_Imp shop=Shop_Service_Imp.getShopService();
		//将查出的数据放入list集合中
		List<Product> list=shop.findAllProduct(); 
		//值写成 键-值对（"shop", list）
		request.setAttribute("shop", list);
		//响应
		request.getRequestDispatcher("shop_product.jsp").forward(request, response);
		*/
		String pageNo=request.getParameter("pageNo");
		Shop_Service_Interface shop=Shop_Service_Imp.getShopService();
	    try {
	    	 PageModel<Product>  pageModel=shop.findProductByPage((Integer.parseInt(pageNo)),6);
	         request.setAttribute("pageModel", pageModel);
	    	 request.getRequestDispatcher("Product/shop_product.jsp").forward(request, response);
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
