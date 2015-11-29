package by.java.training.chp.dataacess.model;

import java.util.Date;

public class Payment {
	private Integer paymentId;
	private Integer bookingId;
	private Integer amountOfPayment;
	private Date dateOfPayment;
	
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public Integer getAmountOfPayment() {
		return amountOfPayment;
	}
	public void setAmountOfPayment(Integer amountOfPayment) {
		this.amountOfPayment = amountOfPayment;
	}
	public Date getDateOfPayment() {
		return dateOfPayment;
	}
	public void setDateOfPayment(Date dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

}
