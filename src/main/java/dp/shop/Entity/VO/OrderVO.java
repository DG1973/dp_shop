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
	private List<UserOrderItem>  userOrderItems;		//������ϸ
	private Integer user_id;				//�û�id
	private Integer shipping_id;		//��ַid
	private String username;			//�û��˺�
	private Long order_no;				//�������
	private String receiver_name;	//�ջ�������
	private String receiver_phone;	//�ջ��˹̶��绰
	private String receiver_mobile;//�ջ����ֻ�
	private String receiver_province;//ʡ��
	private String receiver_city;		//���ڳ���
	private String receiver_district;	//��/��
	private String receiver_address;//��ϸ��ַ
	private String receiver_zip;		//�ʱ�
	private String payment;				//ʵ�ʸ�����
	private String payment_type;	//֧��״̬
	private String postage;				//�˷�
	private String status;					//����״̬
	private String payment_time;	//֧��ʱ��
	private String send_time;			//����ʱ��
	private String end_time;			//�������ʱ��
	private String close_time;			//���׹ر�ʱ��
	private String create_time;		//����ʱ��
	private String update_time;		//����ʱ��
	
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
			this.payment_type = "����֧��";
		}else if(patmenttype==OrderPaymentTypeEnum.OFFLINE.getPaymentType()){
			this.payment_type = "��������";
		}
		
		
		this.postage = userOrderDO.getPostage().toString();
		
		/*CANCEL(0,"��ȡ��"),
		UNPAY(10,"δ����"),
		PAY(20,"�Ѹ���"),
		SEND(40,"�ѷ���"),
		SUCCCESS(50,"���׳ɹ�"),
		CLOSE(60,"���׹ر�");*/
		Integer status=userOrderDO.getStatus();
		if(status==OrderStatusEnum.CANCEL.getStatus()){
			this.status = "��ȡ��";
		}else if(status==OrderStatusEnum.UNPAY.getStatus()) {
			this.status = "δ����";
		}else if(status==OrderStatusEnum.PAY.getStatus()) {
			this.status = "�Ѹ���";
		}else if(status==OrderStatusEnum.SEND.getStatus()) {
			this.status = "�ѷ���";
		}else if(status==OrderStatusEnum.SUCCCESS.getStatus()) {
			this.status = "���׳ɹ�";
		}else if(status==OrderStatusEnum.CLOSE.getStatus()) {
			this.status = "���׹ر�";
		}

		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//֧��ʱ��
		Date _payment_time=userOrderDO.getPayment_time();
		if(_payment_time!=null) {	
			this.payment_time = format.format(_payment_time.getTime());
		}else {
			this.payment_time =null;
		}
		
		//����ʱ��
		Date _send_time=userOrderDO.getSend_time();
		if(_send_time!=null) {	
			this.send_time = format.format(_send_time.getTime());
		}else {
			this.send_time =null;
		}

		//�������ʱ��
		Date _end_time=userOrderDO.getEnd_time();
		if(_end_time!=null) {	
			this.end_time = format.format(_end_time.getTime());
		}else {
			this.end_time =null;
		}
		//���׹ر�ʱ��
		Date _close_time=userOrderDO.getClose_time();
		if(_close_time!=null) {	
			this.close_time = format.format(_close_time.getTime());
		}else {
			this.close_time =null;
		}
		//����ʱ��
		Date _create_time=userOrderDO.getCreate_time();
		//System.out.println(_create_time);
		if(_create_time!=null) {	
			this.create_time = format.format(_create_time.getTime());
		}else {
			this.create_time =null;
		}
		//����ʱ��
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
