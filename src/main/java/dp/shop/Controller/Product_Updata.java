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

/**
 * Servlet implementation class Product_Updata
 */
@WebServlet("/mng/Product_Updata")
public class Product_Updata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product_Updata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//获取商品编号
		String id=request.getParameter("id");
		List<Category> category=null;
		Shop_Service_Interface productByid=Shop_Service_Imp.getShopService();
		try {
			Product product=productByid.findProductById(Integer.parseInt(id));
			category=productByid.findAllCategory();
			
			if(product!=null) {
				request.setAttribute("product",product);
				request.setAttribute("category",category);
				request.getRequestDispatcher("Product/shop_product_updata.jsp").forward(request, response);
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
		String category_id=request.getParameter("category_id");
		String name=request.getParameter("name");
		String subtitle=request.getParameter("subtitle");
		String main_image=request.getParameter("main_image");
		String sub_images=request.getParameter("sub_images");
		String detail=request.getParameter("detail");
		String price=request.getParameter("price");
		String stock=request.getParameter("stock");
		String status=request.getParameter("status");
		BigDecimal x=new BigDecimal(price);
		System.out.println(x);
		Product product =null;
		Shop_Service_Interface shops_product=null;

		try {
			product=new Product(Integer.parseInt(id),Integer.parseInt(category_id),name, subtitle,main_image,sub_images,detail,x, Integer.parseInt(stock),Integer.parseInt(status),new Date(),new Date());
			shops_product =Shop_Service_Imp.getShopService();
			System.out.println(product);
		}catch(NumberFormatException e) {
			
		}
		System.out.println(product);
		int num=shops_product.updateProduct(product);
		//System.out.println(num);
		if(num>0) {
			request.getRequestDispatcher("Product_Servlet?pageNo=1").forward(request, response);
		}else {
			request.getRequestDispatcher("user/ShiBai.jsp").forward(request, response);
		}
	}
}


