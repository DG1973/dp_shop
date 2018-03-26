package dp.shop.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
/**
 * 订单
 */
public class UserOrder implements Serializable {


	private static final long serialVersionUID = -848642042150325445L;

	
	private Integer id  ;					// '订单id',
	private Long order_no;				//'唯一约束 订单号',
	private List<UserOrderItem>  userOrderItems;		//订单明细
	private Integer user_id;				// '用户id',
	private User	user;						//用户
	private Integer shipping_id;		//'地址id',
	private Address address;			//地址
	private BigDecimal payment ;	//'实际付款金额,单位元,保留两位小数',
	private Integer  payment_type;	// '支付类型 1-在线支付 2-货到付款',
	private Integer  postage;			// '运费,单位元',
	private Integer  status;				//'订单状态  0-已取消 10-未付款 20-已付款 40-已发货 50-交易成功 60-交易关闭',
	private Date  payment_time;		//'支付时间',
	private Date  send_time;			// '发货时间',
	private Date  end_time;				//'交易完成时间',
	private Date  close_time;			//'交易关闭时间',
	private Date  create_time;			//'创建时间',
	private Date update_time;		//'更新时间',
	public UserOrder() {
		super();
	}
	public UserOrder(Integer id, Long order_no, List<dp.shop.Entity.UserOrderItem> userOrderItems, Integer user_id,
			User user, Integer shipping_id, Address address, BigDecimal payment, Integer payment_type, Integer postage,
			Integer status, Date payment_time, Date send_time, Date end_time, Date close_time, Date create_time,
			Date update_time) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.userOrderItems = userOrderItems;
		this.user_id = user_id;
		this.user = user;
		this.shipping_id = shipping_id;
		this.address = address;
		this.payment = payment;
		this.payment_type = payment_type;
		this.postage = postage;
		this.status = status;
		this.payment_time = payment_time;
		this.send_time = send_time;
		this.end_time = end_time;
		this.close_time = close_time;
		this.create_time = create_time;
		this.update_time = update_time;
	}
	
	@Override
	public String toString() {
		return "UserOrder [id=" + id + ", order_no=" + order_no + ", userOrderItems=" + userOrderItems + ", user_id="
				+ user_id + ", user=" + user + ", shipping_id=" + shipping_id + ", address=" + address + ", payment="
				+ payment + ", payment_type=" + payment_type + ", postage=" + postage + ", status=" + status
				+ ", payment_time=" + payment_time + ", send_time=" + send_time + ", end_time=" + end_time
				+ ", close_time=" + close_time + ", create_time=" + create_time + ", update_time=" + update_time	+"]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Long order_no) {
		this.order_no = order_no;
	}
	public List<UserOrderItem> getUserOrderItems() {
		return userOrderItems;
	}
	public void setUserOrderItems(List<UserOrderItem> userOrderItems) {
		this.userOrderItems = userOrderItems;
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
	public Integer getShipping_id() {
		return shipping_id;
	}
	public void setShipping_id(Integer shipping_id) {
		this.shipping_id = shipping_id;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public BigDecimal getPayment() {
		return payment;
	}
	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}
	public Integer getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(Integer payment_type) {
		this.payment_type = payment_type;
	}
	public Integer getPostage() {
		return postage;
	}
	public void setPostage(Integer postage) {
		this.postage = postage;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getPayment_time() {
		return payment_time;
	}
	public void setPayment_time(Date payment_time) {
		this.payment_time = payment_time;
	}
	public Date getSend_time() {
		return send_time;
	}
	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public Date getClose_time() {
		return close_time;
	}
	public void setClose_time(Date close_time) {
		this.close_time = close_time;
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

}
