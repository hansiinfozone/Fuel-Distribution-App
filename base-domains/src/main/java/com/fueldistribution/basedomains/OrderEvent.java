package com.fueldistribution.basedomains;

public class OrderEvent {

	private String orderReferenceNumber;
	private String status;
	private String Message;
	private Order order;

	public OrderEvent() {
	}

	public OrderEvent(String status, String message, Order order) {
		super();
		this.status = status;
		Message = message;
		this.order = order;
	}

	public OrderEvent(String orderReferenceNumber, String status, String message, Order order) {
		this.orderReferenceNumber = orderReferenceNumber;
		this.status = status;
		Message = message;
		this.order = order;
	}

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
