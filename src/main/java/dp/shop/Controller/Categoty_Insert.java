package dp.shop.Controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dp.shop.Entity.Category;
import dp.shop.Service.Shop_Service_Interface;
import dp.shop.Service.Imp.Shop_Service_Imp;

/**
 * Servlet implementation class Categoty_Insert
 */
@WebServlet("/mng/Categoty_Insert")
public class Categoty_Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Categoty_Insert() {
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
		Shop_Service_Interface shop= Shop_Service_Imp.getShopService();
		List<Category> category=shop.findAllCategory();
		//获取Category的list集合
		request.setAttribute("category_parent_id", category);
		//跳转页面
		request.getRequestDispatcher("Category/shop_category_add.jsp").forward(request, response);
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
		/*
		//时间转化
		String hiredate=request.getParameter("hiredate");
		SimpleDateFormat time=new SimpleDateFormat("yyyy-mm-dd");
		Date sj = null;
		try {
			sj=time.parse(hiredate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Category categoty =null;
		Shop_Service_Interface shops_product=null;

		try {
			categoty=new Category(1,Integer.parseInt(parent_id),name,Integer.parseInt(status),Integer.parseInt(sort_order),new Date(),new Date());
			shops_product =Shop_Service_Imp.getShopService();
			
		}catch(NumberFormatException e) {
			doGet(request, response);
		}
		//System.out.println(categoty);
		int num=shops_product.addCategory(categoty);
		//System.out.println(num);
		if(num>0) {
			request.getRequestDispatcher("Categoty_Servlet?pageNo=1").forward(request, response);
		}else {
			request.getRequestDispatcher("user/ShiBai.jsp").forward(request, response);
		}
	}

}
