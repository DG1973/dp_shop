package dp.shop.Contst;

public enum OrderPaymentTypeEnum {
	/**
	 *付款方式枚举类型
	 * */
		
		ONLINE(1,"在线支付"),
		OFFLINE(2,"货到付款");

		
		private int paymentType;
		private String message;
		
		
		public int getPaymentType() {
			return paymentType;
		}
		public void setPaymentType(int paymentType) {
			this.paymentType = paymentType;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
		private OrderPaymentTypeEnum(int paymentType, String message) {
			this.paymentType = paymentType;
			this.message = message;
		}
}
