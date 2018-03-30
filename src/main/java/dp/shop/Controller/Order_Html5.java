package dp.shop.Controller;

import com.google.gson.Gson;
import dp.shop.Entity.PageModel;
import dp.shop.Entity.User;
import dp.shop.Entity.VO.OrderVO;
import dp.shop.Service.Imp.Order_Service_Impl;
import dp.shop.Service.Order_Service_Interface;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Order_Servlet
 */
@WebServlet("/view/Order_Html5")
public class Order_Html5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order_Html5() {
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
		User user=null;


		//Order_Service_Interface order=new Order_Service_Impl();
		WebApplicationContext webApplicationContext= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		Order_Service_Interface order=webApplicationContext.getBean(Order_Service_Impl.class);
		/**userOrderΪ������* */
		//UserOrderMyBatis_Dao_Interface userOrder=new UserOrderMyBatis_Dao_Impl();
		/**userOrderItemΪ������ϸ��* */
		// UserOrderItemMyBatis_Dao_Interface userOrderItem=new UserOrderItemMyBatis_Dao_Impl();

		String operation=request.getParameter("operation");
		HttpSession session=request.getSession();
		Object object=session.getAttribute("user");

		if(object!=null && object instanceof User) {
			user=(User)object;
		}
		if(user==null) {//2.�����ڣ���Ҫ��½
			PrintWriter pw=response.getWriter();
			//�ܵ��е���HTML�еķ���  anxia  ���ַ������ӱ�ʾ
			String data="{\"url\":\"http://127.0.0.1:8020/business/Login.html\"}";
			pw.write("login("+data+")");
			return;
		}else {	//3.�����û���˵���Ѿ���¼
			if(operation.equals("1")) {//1.�鿴������ϸ
				OrderVO orderVO=order.findUserOrderItemByOrderNo(user.getId(),request);
				request.setAttribute("orderVO", orderVO);
				request.getRequestDispatcher("admin/Order_findOrderItem.jsp").forward(request, response);


				/*PageModel<OrderVO> pageModel=order.findUserOrder(request, user.getId());
				request.setAttribute("pageModel", pageModel);
				request.getRequestDispatcher("view/admin/Order_find.jsp").forward(request, response);*/


			}else if(operation.equals("2")) {//2.��ҳ�鿴����and����id��ѯ
				PageModel<OrderVO> pageModel=order.findUserOrderDetailByOrderNo(request, user.getId());
				String order_no=request.getParameter("order_no");
				request.setAttribute("pageModel", pageModel);
				request.setAttribute("order_no", order_no);
				String callback=request.getParameter("callback");
				System.out.println(callback);
				Gson gso=new Gson();
				String str=gso.toJson(pageModel);
                //response.getWriter().write(str);
				response.getWriter().write(callback+"("+str+");");
				//request.getRequestDispatcher("admin/Order_find.jsp").forward(request, response);
			}else if(operation.equals("3")) {//3.�ύ����
				order.createOrder(user.getId(), request);
			}else if(operation.equals("4")) {//4.�޸�
				order.updateOrderByOrderNo(request);
				response.sendRedirect("http://localhost:8080/dp_shop/view/Order_Html5?operation=2&pageNo=1&pageSize=2&order_no=");
			}else if(operation.equals("5")) {//5.ɾ��
				response.sendRedirect("http://localhost:8080/dp_shop/Order_Servlet");
			}else {
				response.sendRedirect("http://localhost:8080/dp_shop/Order_Servlet");
			}
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
