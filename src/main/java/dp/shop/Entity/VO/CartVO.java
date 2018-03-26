package dp.shop.Entity.VO;

import java.text.SimpleDateFormat;
import java.util.Date;
import dp.shop.Entity.Cart;
import dp.shop.Entity.Category;
import dp.shop.Entity.Product;
import dp.shop.Entity.User;

public class CartVO {
	public int getErrno() {
		return errno;
	}
	public void setErrno(int errno) {
		this.errno = errno;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	@Override
	public String toString() {
		return "CartVO [id=" + id + ", user_id=" + user_id + ", user=" + user + ", product_id=" + product_id
				+ ", quantity=" + quantity + ", checked=" + checked + ", product=" + product + ", category=" + category
				+ ", create_time=" + create_time + ", update_time=" + update_time + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	private Integer id;					//����Id
	private Integer user_id;			//�û�id
	private User user;					//�û���Ϣ
	private Integer product_id;	//��Ʒid
	private Integer quantity;		//����
	private String price;				//����
	private String checked;			//int(11) default null  �Ƿ�ѡ�� 1-�ѹ�ѡ 0-δ��ѡ
	private Product product;		//��Ʒ
	private Category category;	//���
	private String payment;	//С��
	private String create_time;	//����ʱ��	
	private String update_time;	//����ʱ��
	
	private  int errno; 
	private String message;
	
	public static final int CART_SUCC=1;
	public static final int CART_FAIL=0;

	public  CartVO CartIntoCartVO(Cart cart ) {
		CartVO cartVo =new  CartVO();
		this.id = cart.getId();
		this.user_id = cart.getUser_id();
		this.user = cart.getUser();
		this.product_id = cart.getProduct_id();
		this.quantity = cart.getQuantity();
		
		this.payment = cart.getPayment().toString();
		Integer _checked= cart.getChecked();
		if(_checked==1) {
			this.checked ="�ѹ�ѡ";
		}else if(_checked==0) {
			this.checked ="δ��ѡ";
		}
		
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.product = cart.getProduct();
		this.category = cart.getCategory();
		this.price =cart.getProduct().getPrice().toString();
		
		//����ʱ��
		Date _create_time=cart.getCreate_time();
		//System.out.println(_create_time);
		if(_create_time!=null) {	
			this.create_time = format.format(_create_time.getTime());
		}else {
			this.create_time =null;
		}
		//����ʱ��
		Date _update_time=cart.getUpdate_time();
		if(_update_time!=null) {	
			this.update_time = format.format(_update_time.getTime());
		}else {
			this.update_time =null;
		}

		return cartVo;
	}
	public CartVO(Integer id, Integer user_id, User user, Integer product_id, Integer quantity, String checked,
			Product product, Category category, String payment, String create_time, String update_time) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.user = user;
		this.product_id = product_id;
		this.quantity = quantity;
		this.checked = checked;
		this.product = product;
		this.category = category;
		this.payment = payment;
		this.create_time = create_time;
		this.update_time = update_time;
	}
	public CartVO() {
		super();
	}

	
	
	
}
