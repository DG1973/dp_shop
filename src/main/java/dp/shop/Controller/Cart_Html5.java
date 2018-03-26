package dp.shop.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dp.shop.Entity.User;
import dp.shop.Service.Cart_Service_Interface_HTML;
import dp.shop.Service.Imp.Cart_Servic_Impl_HTML;

/**
 * Servlet implementation class Cart_Html5
 */
@WebServlet("/view/Cart_Html5")
public class Cart_Html5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart_Html5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.setHeader("Access-Control-Allow-Origin", "*");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		User user=null;
		
		HttpSession session=request.getSession();
		System.out.println(session.getId());
		Object object=session.getAttribute("user");
		System.out.println(object);
		
		//获取指令
		String operation=request.getParameter("operation");
		//调用Service层方法
		
		Cart_Service_Interface_HTML Cart_Service=new Cart_Servic_Impl_HTML();

		if(object!=null && object instanceof User) {
			user=(User)object;
		}
		if(user==null) {	//2.不存在，需要登陆
	
			PrintWriter pw=response.getWriter();
			//管道中调用HTML中的方法  anxia  用字符串连接表示
			String url="{\"url\":\"http://127.0.0.1:8020/business/Login.html\"}";
			pw.write("login("+url+")");
			return; 
		}

		if(operation.equals("1")) {
			//测试是否链接
			System.out.println("==========连接成功========执行查看功能=========");
			//获取PageModel<Cart>的值
			String str=Cart_Service.findUserCart(request, user.getId());
			//计算金额
			String payment=Cart_Service.SumPaument(user.getId());
			//建立管道
			PrintWriter pw=response.getWriter();
			//管道中调用HTML中的方法  anxia  用字符串连接表示
			pw.write("cart("+str+"),anxia("+str+"),payment("+payment+")");	
		}else if(operation.equals("2")){
			System.out.println(request.getParameter("checked"));
			Cart_Service.updataUserCartCheckedByUseridAndProduct_id(user.getId(), request);
			String str=Cart_Service.findUserCart(request,user.getId());
			String payment=Cart_Service.SumPaument(user.getId());

			response.getWriter().write("anxia("+str+"),payment("+payment+")");	

			
		}else if(operation.equals("3")){//删除购物车中的商品
			String _product_id=request.getParameter("product_id");
			Integer product_id=0;
			try {
				product_id= Integer.parseInt(_product_id);
				}catch (NumberFormatException e) {
					e.printStackTrace();
				}
			Cart_Service.deletUserCartByUseridAndProduct_id(user.getId(), product_id);
			//获取PageModel<Cart>的值(json格式)
			String str=Cart_Service.findUserCart(request, user.getId());
			//获取总价
			String payment=Cart_Service.SumPaument(user.getId());
			//建立管道
			PrintWriter pw=response.getWriter();
			//管道中调用HTML中的方法  anxia  用字符串连接表示
			pw.write("anxia("+str+"),payment("+payment+")");	
			
		}else if(operation.equals("4")){
		
			Cart_Service.updataUserCartByUseridAndProduct_id(user.getId(), request);
			//获取PageModel<Cart>的值(json格式)
			String str=Cart_Service.findUserCart(request, user.getId());
			//获取总价
			String payment=Cart_Service.SumPaument(user.getId());
			//建立管道
			PrintWriter pw=response.getWriter();
			//管道中调用HTML中的方法  anxia  用字符串连接表示
			pw.write("anxia("+str+"),payment("+payment+")");	

			
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
