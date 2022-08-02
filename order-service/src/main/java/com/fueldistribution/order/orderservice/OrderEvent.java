package com.fueldistribution.order.orderservice;


public class OrderEvent {
	
	private String Message;
	private String orderReferenceNumber;
	private String status;
	private Order order;
	
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getOrderReferenceNumber() {
		return orderReferenceNumber;
	}
	public void setOrderReferenceNumber(String orderReferenceNumber) {
		this.orderReferenceNumber = orderReferenceNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setOrder(Order order) {
		this.order = order;
		
	}
	public Order getOrder() {
		return order;
	}
	
	

}
