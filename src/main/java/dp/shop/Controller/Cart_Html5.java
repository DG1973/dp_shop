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
		
		//��ȡָ��
		String operation=request.getParameter("operation");
		//����Service�㷽��
		
		Cart_Service_Interface_HTML Cart_Service=new Cart_Servic_Impl_HTML();

		if(object!=null && object instanceof User) {
			user=(User)object;
		}
		if(user==null) {	//2.�����ڣ���Ҫ��½
	
			PrintWriter pw=response.getWriter();
			//�ܵ��е���HTML�еķ���  anxia  ���ַ������ӱ�ʾ
			String url="{\"url\":\"http://127.0.0.1:8020/business/Login.html\"}";
			pw.write("login("+url+")");
			return; 
		}

		if(operation.equals("1")) {
			//�����Ƿ�����
			System.out.println("==========���ӳɹ�========ִ�в鿴����=========");
			//��ȡPageModel<Cart>��ֵ
			String str=Cart_Service.findUserCart(request, user.getId());
			//������
			String payment=Cart_Service.SumPaument(user.getId());
			//�����ܵ�
			PrintWriter pw=response.getWriter();
			//�ܵ��е���HTML�еķ���  anxia  ���ַ������ӱ�ʾ
			pw.write("cart("+str+"),anxia("+str+"),payment("+payment+")");	
		}else if(operation.equals("2")){
			System.out.println(request.getParameter("checked"));
			Cart_Service.updataUserCartCheckedByUseridAndProduct_id(user.getId(), request);
			String str=Cart_Service.findUserCart(request,user.getId());
			String payment=Cart_Service.SumPaument(user.getId());

			response.getWriter().write("anxia("+str+"),payment("+payment+")");	

			
		}else if(operation.equals("3")){//ɾ�����ﳵ�е���Ʒ
			String _product_id=request.getParameter("product_id");
			Integer product_id=0;
			try {
				product_id= Integer.parseInt(_product_id);
				}catch (NumberFormatException e) {
					e.printStackTrace();
				}
			Cart_Service.deletUserCartByUseridAndProduct_id(user.getId(), product_id);
			//��ȡPageModel<Cart>��ֵ(json��ʽ)
			String str=Cart_Service.findUserCart(request, user.getId());
			//��ȡ�ܼ�
			String payment=Cart_Service.SumPaument(user.getId());
			//�����ܵ�
			PrintWriter pw=response.getWriter();
			//�ܵ��е���HTML�еķ���  anxia  ���ַ������ӱ�ʾ
			pw.write("anxia("+str+"),payment("+payment+")");	
			
		}else if(operation.equals("4")){
		
			Cart_Service.updataUserCartByUseridAndProduct_id(user.getId(), request);
			//��ȡPageModel<Cart>��ֵ(json��ʽ)
			String str=Cart_Service.findUserCart(request, user.getId());
			//��ȡ�ܼ�
			String payment=Cart_Service.SumPaument(user.getId());
			//�����ܵ�
			PrintWriter pw=response.getWriter();
			//�ܵ��е���HTML�еķ���  anxia  ���ַ������ӱ�ʾ
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
