package dp.shop.Entity;

import java.math.BigDecimal;
import java.util.Date;

public class Cart {
	
	@Override
	public String toString() {
		return "Cart [id=" + id + ", user_id=" + user_id + ", user=" + user + ", product_id=" + product_id
				+ ", quantity=" + quantity + ", checked=" + checked + ", payment=" + payment + ", create_time="
				+ create_time + ", update_time=" + update_time + ", product=" + product + ", category=" + category
				+ "]";
	}
	public BigDecimal getPayment() {
		return payment;
	}
	public void setPayment(BigDecimal payment) {
		this.payment = payment;
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
	public Integer getChecked() {
		return checked;
	}
	public void setChecked(Integer checked) {
		this.checked = checked;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
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
	private Integer id;					//主键Id
	private Integer user_id;			//用户id
	private User user;					//用户信息
	private Integer product_id;	//商品id
	private Integer quantity;		//数量
	private Integer checked;		//int(11) default null  是否选择 1-已勾选 0-未勾选
	private BigDecimal payment;	//小计
	private Date create_time;	//创建时间	
	private Date update_time;//更新时间
	private Product product;//商品
	private Category category;//类别
	public Cart(Integer id, Integer user_id, User user, Integer product_id, Integer quantity, Integer checked,
			BigDecimal payment, Date create_time, Date update_time, Product product, Category category) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.user = user;
		this.product_id = product_id;
		this.quantity = quantity;
		this.checked = checked;
		this.payment = payment;
		this.create_time = create_time;
		this.update_time = update_time;
		this.product = product;
		this.category = category;
	}
	public Cart() {
		super();
	}


	

	
	
	
}
