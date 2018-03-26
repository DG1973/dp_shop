package dp.shop.Contst;
/**
 * 订单状态枚举类型
 * */
public enum OrderStatusEnum {
	
	CANCEL(10,"已取消"),
	UNPAY(20,"未付款"),
	PAY(30,"已付款"),
	SEND(40,"已发货"),
	SUCCCESS(50,"交易成功"),
	CLOSE(60,"交易关闭");
	
	private int status;
	private String message;
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	private OrderStatusEnum(int status, String message) {
		this.status = status;
		this.message = message;
	}
	
	
	
}
