package dp.shop.Contst;
/**
 * ����״̬ö������
 * */
public enum OrderStatusEnum {
	
	CANCEL(10,"��ȡ��"),
	UNPAY(20,"δ����"),
	PAY(30,"�Ѹ���"),
	SEND(40,"�ѷ���"),
	SUCCCESS(50,"���׳ɹ�"),
	CLOSE(60,"���׹ر�");
	
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
