package dp.shop.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dp.shop.Entity.PageModel;
import dp.shop.Entity.User;
import dp.shop.Entity.VO.OrderVO;
import dp.shop.Service.Order_Service_Interface;
import dp.shop.Service.Imp.Order_Service_Impl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class Order_Servlet
 */
@WebServlet("/view/Order_Servlet")
public class Order_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order_Servlet() {
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
		
		/**userOrder为订单表* */
		//UserOrderMyBatis_Dao_Interface userOrder=new UserOrderMyBatis_Dao_Impl();
		/**userOrderItem为订单明细表* */
		// UserOrderItemMyBatis_Dao_Interface userOrderItem=new UserOrderItemMyBatis_Dao_Impl();
		
		String operation=request.getParameter("operation");
		HttpSession session=request.getSession();
		Object object=session.getAttribute("user");
		
		if(object!=null && object instanceof User) {
			user=(User)object;
		}
		if(user==null) {	//2.不存在，需要登陆
			response.sendRedirect("http://localhost:8080/dp_shop/login.jsp");
		}else {	//3.存在用户，说明已经登录
			if(operation.equals("1")) {//1.查看订单明细
				OrderVO orderVO=order.findUserOrderItemByOrderNo(user.getId(),request);
				request.setAttribute("orderVO", orderVO);
				request.getRequestDispatcher("admin/Order_findOrderItem.jsp").forward(request, response);
				
				
				/*PageModel<OrderVO> pageModel=order.findUserOrder(request, user.getId());			
				request.setAttribute("pageModel", pageModel);
				request.getRequestDispatcher("view/admin/Order_find.jsp").forward(request, response);*/
				
				
			}else if(operation.equals("2")) {//2.分页查看订单and根据id查询
				PageModel<OrderVO> pageModel=order.findUserOrderDetailByOrderNo(request, user.getId());			
				String order_no=request.getParameter("order_no");
				request.setAttribute("pageModel", pageModel);
				request.setAttribute("order_no", order_no);
				request.getRequestDispatcher("admin/Order_find.jsp").forward(request, response);
			}else if(operation.equals("3")) {//3.提交订单
				order.createOrder(user.getId(), request);
			}else if(operation.equals("4")) {//4.修改	
				order.updateOrderByOrderNo(request);
				response.sendRedirect("http://localhost:8080/dp_shop/view/Order_Servlet?operation=2&pageNo=1&pageSize=2&order_no=");
			}else if(operation.equals("5")) {//5.删除
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
