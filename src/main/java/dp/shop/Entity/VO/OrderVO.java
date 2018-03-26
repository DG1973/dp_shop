package dp.shop.Entity.VO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dp.shop.Contst.OrderPaymentTypeEnum;
import dp.shop.Contst.OrderStatusEnum;
import dp.shop.Entity.Address;
import dp.shop.Entity.User;
import dp.shop.Entity.UserOrder;
import dp.shop.Entity.UserOrderItem;

public class OrderVO {
	private List<UserOrderItem>  userOrderItems;		//订单明细
	private Integer user_id;				//用户id
	private Integer shipping_id;		//地址id
	private String username;			//用户账号
	private Long order_no;				//订单编号
	private String receiver_name;	//收货人姓名
	private String receiver_phone;	//收货人固定电话
	private String receiver_mobile;//收货人手机
	private String receiver_province;//省份
	private String receiver_city;		//所在城市
	private String receiver_district;	//区/县
	private String receiver_address;//详细地址
	private String receiver_zip;		//邮编
	private String payment;				//实际付款金额
	private String payment_type;	//支付状态
	private String postage;				//运费
	private String status;					//订单状态
	private String payment_time;	//支付时间
	private String send_time;			//发货时间
	private String end_time;			//交易完成时间
	private String close_time;			//交易关闭时间
	private String create_time;		//创建时间
	private String update_time;		//更新时间
	
	public void UserOrderIntoOrderVO(UserOrder userOrderDO) {
		
		this.userOrderItems=userOrderDO.getUserOrderItems();
		this.user_id = userOrderDO.getUser_id();
		this.shipping_id = userOrderDO.getShipping_id();
		
		User user=userOrderDO.getUser();
		this.username = user.getUsername();
		
		
		this.order_no = userOrderDO.getOrder_no();
		
		Address address=userOrderDO.getAddress();
		this.receiver_name = address.getReceiver_name();
		this.receiver_phone =address.getReceiver_phone();
		this.receiver_mobile = address.getReceiver_mobile();
		this.receiver_province = address.getReceiver_province();
		this.receiver_city = address.getReceiver_city();
		this.receiver_district = address.getReceiver_district();
		this.receiver_address = address.getReceiver_address();
		this.receiver_zip = address.getReceiver_zip();
		
		this.payment = userOrderDO.getPayment().toString();
		
		Integer patmenttype=userOrderDO.getPayment_type();
		if(patmenttype==OrderPaymentTypeEnum.ONLINE.getPaymentType()) {
			this.payment_type = "在线支付";
		}else if(patmenttype==OrderPaymentTypeEnum.OFFLINE.getPaymentType()){
			this.payment_type = "货到付款";
		}
		
		
		this.postage = userOrderDO.getPostage().toString();
		
		/*CANCEL(0,"已取消"),
		UNPAY(10,"未付款"),
		PAY(20,"已付款"),
		SEND(40,"已发货"),
		SUCCCESS(50,"交易成功"),
		CLOSE(60,"交易关闭");*/
		Integer status=userOrderDO.getStatus();
		if(status==OrderStatusEnum.CANCEL.getStatus()){
			this.status = "已取消";
		}else if(status==OrderStatusEnum.UNPAY.getStatus()) {
			this.status = "未付款";
		}else if(status==OrderStatusEnum.PAY.getStatus()) {
			this.status = "已付款";
		}else if(status==OrderStatusEnum.SEND.getStatus()) {
			this.status = "已发货";
		}else if(status==OrderStatusEnum.SUCCCESS.getStatus()) {
			this.status = "交易成功";
		}else if(status==OrderStatusEnum.CLOSE.getStatus()) {
			this.status = "交易关闭";
		}

		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//支付时间
		Date _payment_time=userOrderDO.getPayment_time();
		if(_payment_time!=null) {	
			this.payment_time = format.format(_payment_time.getTime());
		}else {
			this.payment_time =null;
		}
		
		//发货时间
		Date _send_time=userOrderDO.getSend_time();
		if(_send_time!=null) {	
			this.send_time = format.format(_send_time.getTime());
		}else {
			this.send_time =null;
		}

		//交易完成时间
		Date _end_time=userOrderDO.getEnd_time();
		if(_end_time!=null) {	
			this.end_time = format.format(_end_time.getTime());
		}else {
			this.end_time =null;
		}
		//交易关闭时间
		Date _close_time=userOrderDO.getClose_time();
		if(_close_time!=null) {	
			this.close_time = format.format(_close_time.getTime());
		}else {
			this.close_time =null;
		}
		//创建时间
		Date _create_time=userOrderDO.getCreate_time();
		//System.out.println(_create_time);
		if(_create_time!=null) {	
			this.create_time = format.format(_create_time.getTime());
		}else {
			this.create_time =null;
		}
		//更新时间
		Date _update_time=userOrderDO.getUpdate_time();
		if(_update_time!=null) {	
			this.update_time = format.format(_update_time.getTime());
		}else {
			this.update_time =null;
		}

	}

	public OrderVO() {
		super();
	}

	
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getShipping_id() {
		return shipping_id;
	}

	public void setShipping_id(Integer shipping_id) {
		this.shipping_id = shipping_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getOrder_no() {
		return order_no;
	}

	public void setOrder_no(Long order_no) {
		this.order_no = order_no;
	}

	public String getReceiver_name() {
		return receiver_name;
	}

	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}

	public String getReceiver_phone() {
		return receiver_phone;
	}

	public void setReceiver_phone(String receiver_phone) {
		this.receiver_phone = receiver_phone;
	}

	public String getReceiver_mobile() {
		return receiver_mobile;
	}

	public void setReceiver_mobile(String receiver_mobile) {
		this.receiver_mobile = receiver_mobile;
	}

	public String getReceiver_province() {
		return receiver_province;
	}

	public void setReceiver_province(String receiver_province) {
		this.receiver_province = receiver_province;
	}

	public String getReceiver_city() {
		return receiver_city;
	}

	public void setReceiver_city(String receiver_city) {
		this.receiver_city = receiver_city;
	}

	public String getReceiver_district() {
		return receiver_district;
	}

	public void setReceiver_district(String receiver_district) {
		this.receiver_district = receiver_district;
	}

	public String getReceiver_address() {
		return receiver_address;
	}

	public void setReceiver_address(String receiver_address) {
		this.receiver_address = receiver_address;
	}

	public String getReceiver_zip() {
		return receiver_zip;
	}

	public void setReceiver_zip(String receiver_zip) {
		this.receiver_zip = receiver_zip;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public String getPostage() {
		return postage;
	}

	public void setPostage(String postage) {
		this.postage = postage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayment_time() {
		return payment_time;
	}

	public void setPayment_time(String payment_time) {
		this.payment_time = payment_time;
	}

	public String getSend_time() {
		return send_time;
	}

	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getClose_time() {
		return close_time;
	}

	public void setClose_time(String close_time) {
		this.close_time = close_time;
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
	
	public List<UserOrderItem> getUserOrderItems() {
		return userOrderItems;
	}

	public void setUserOrderItems(List<UserOrderItem> userOrderItems) {
		this.userOrderItems = userOrderItems;
	}

	public OrderVO(List<UserOrderItem> userOrderItems, Integer user_id, Integer shipping_id, String username,
			Long order_no, String receiver_name, String receiver_phone, String receiver_mobile,
			String receiver_province, String receiver_city, String receiver_district, String receiver_address,
			String receiver_zip, String payment, String payment_type, String postage, String status,
			String payment_time, String send_time, String end_time, String close_time, String create_time,
			String update_time) {
		super();
		this.userOrderItems = userOrderItems;
		this.user_id = user_id;
		this.shipping_id = shipping_id;
		this.username = username;
		this.order_no = order_no;
		this.receiver_name = receiver_name;
		this.receiver_phone = receiver_phone;
		this.receiver_mobile = receiver_mobile;
		this.receiver_province = receiver_province;
		this.receiver_city = receiver_city;
		this.receiver_district = receiver_district;
		this.receiver_address = receiver_address;
		this.receiver_zip = receiver_zip;
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
	
	
}
