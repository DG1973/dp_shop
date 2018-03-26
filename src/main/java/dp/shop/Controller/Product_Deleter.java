package dp.shop.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dp.shop.Service.Shop_Service_Interface;
import dp.shop.Service.Imp.Shop_Service_Imp;


/**
 * Servlet implementation class Product_Del
 */
@WebServlet("/mng/Product_Del")
public class Product_Deleter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product_Deleter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//��ȡҳ������
		String id =request.getParameter("id");
		//System.out.println(empnodel);
		//ʵ���� Emp_Service
		Shop_Service_Interface shop=Shop_Service_Imp.getShopService();
		//ִ��ɾ������
		shop.deleteProductById(Integer.parseInt(id));
		/*ɾ��֮���ٴβ�ѯ���ݱ�		
		List<Emp> list= emp.findAllEmp();
		
		request.setAttribute("emps", list);*/
		request.getRequestDispatcher("Product_Servlet?pageNo=1").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
