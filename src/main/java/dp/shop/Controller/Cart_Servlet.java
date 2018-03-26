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
import dp.shop.Entity.VO.CartVO;
import dp.shop.Service.Cart_Service_Interface;
import dp.shop.Service.Imp.Cart_Servic_Impl;

/**
 * Servlet implementation class Cart_Servlet
 */
@WebServlet("/Cart_Servlet")
public class Cart_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart_Servlet() {
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
		Cart_Service_Interface cart=new Cart_Servic_Impl();
		//CartMyBatis_Dao_Interface cartdao=new CartMyBatis_Dao_impl();
		String operation=request.getParameter("operation");
		HttpSession session=request.getSession();
		Object object=session.getAttribute("user");
		if(object!=null && object instanceof User) {
			user=(User)object;
		}

		if(user==null) {	//2.不存在，需要登陆
	
			/*PrintWriter pw=response.getWriter();
			//管道中调用HTML中的方法  anxia  用字符串连接表示
			String url="{\"url\":\"http://127.0.0.1:8020/business/liebiao.html\"}";
			pw.write("login("+url+")");*/
			
			response.sendRedirect("http://localhost:8080/dp_shop/login.jsp");
		}else {	//3.存在用户，说明已经登录
			if(operation.equals("1")) {//1.分页查看
				/*//测试是否链接
				System.out.println("==========连接成功========");
				//调用Service层方法
				Cart_Service_Interface Cart_Service=new Cart_Servic_Impl();
				//获取PageModel<Cart>的值
				PageModel<CartVO>  pageModel=Cart_Service.findUserCart(request, user.getId());
				//创建一个Gson
				Gson gson=new Gson();
				//调用Gson的方法toJson将获得的pageModel的值转换成为Json类型的
				String str=gson.toJson(pageModel);
				//建立管道
				PrintWriter pw=response.getWriter();
				//管道中调用HTML中的方法  anxia  用字符串连接表示
				pw.write("anxia("+str+")");*/
				
				
				
				
			PageModel<CartVO> pageModel=cart.findUserCart(request, user.getId());
				Integer sum=cart.findUserCartdequantity(user.getId());
				request.setAttribute("pageModel", pageModel);
				request.setAttribute("sum", sum);
				request.getRequestDispatcher("view/admin/Cart_find.jsp").forward(request, response);
			}else if(operation.equals("2")) {//2.添加和修改
				
				String _product_id=request.getParameter("product_id");
				Integer product_id=0;
				try {
					product_id= Integer.parseInt(_product_id);
					}catch (NumberFormatException e) {
						e.printStackTrace();
					}
				int pd=cart.pd(user.getId(), product_id);
				if(pd==0) {
					cart.addUserCart(user.getId(), request);
				}else {
					cart.updataUserCartByUseridAndProduct_id(user.getId(), request);
				}
				response.sendRedirect("http://localhost:8080/dp_shop/Cart_Servlet?operation=1&pageNo=1&pageSize=2");

			}else if(operation.equals("3")) {//修改

				cart.updataUserCartCheckedByUseridAndProduct_id(user.getId(), request);
				response.sendRedirect("http://localhost:8080/dp_shop/Cart_Servlet?operation=1&pageNo=1&pageSize=2");
				
			}else if(operation.equals("4")) {	//删除
				String _product_id=request.getParameter("product_id");
				Integer product_id=0;
				try {
					product_id= Integer.parseInt(_product_id);
					}catch (NumberFormatException e) {
						e.printStackTrace();
					}
				cart.deletUserCartByUseridAndProduct_id(user.getId(), product_id);
				response.sendRedirect("http://localhost:8080/dp_shop/Cart_Servlet?operation=1&pageNo=1&pageSize=2");

			}else if(operation.equals("5")) {//提交购物车
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
