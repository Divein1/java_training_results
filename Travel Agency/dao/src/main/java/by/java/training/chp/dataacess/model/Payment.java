package by.java.training.chp.dataacess.model;

import java.util.Date;

public class Payment {
	private Integer paymentId;
	private Integer bookingId;
	private Integer amoutOfPayment;
	private Date dateOfPayment;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paymentId == null) ? 0 : paymentId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (amoutOfPayment == null) {
			if (other.amoutOfPayment != null)
				return false;
		} else if (!amoutOfPayment.equals(other.amoutOfPayment))
			return false;
		if (bookingId == null) {
			if (other.bookingId != null)
				return false;
		} else if (!bookingId.equals(other.bookingId))
			return false;
		if (dateOfPayment == null) {
			if (other.dateOfPayment != null)
				return false;
		} else if (!dateOfPayment.equals(other.dateOfPayment))
			return false;
		if (paymentId == null) {
			if (other.paymentId != null)
				return false;
		} else if (!paymentId.equals(other.paymentId))
			return false;
		return true;
	}
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
	public Integer getAmoutOfPayment() {
		return amoutOfPayment;
	}
	public void setAmoutOfPayment(Integer amoutOfPayment) {
		this.amoutOfPayment = amoutOfPayment;
	}
	public Date getDateOfPayment() {
		return dateOfPayment;
	}
	public void setDateOfPayment(Date dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

}
