package by.java.training.chp.dataacess.model;

import java.util.Date;

public class Customers {

	private Integer customerId;
	private String customerName;
	private String gender;
	private Date birthday;
	private String phoneNumber;
	private String eMail;
	private Integer departureAddress;
	private String additionalNotes;
	private Integer loginInfo;
	private Integer toursBooked;
	
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getDepartureAddress() {
		return departureAddress;
	}
	public void setDepartureAddress(Integer departureAddress) {
		this.departureAddress = departureAddress;
	}
	public String getAdditionalNotes() {
		return additionalNotes;
	}
	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getLoginInfo() {
		return loginInfo;
	}
	public void setLoginInfo(Integer loginInfo) {
		this.loginInfo = loginInfo;
	}
	public Integer getToursBooked() {
		return toursBooked;
	}
	public void setToursBooked(Integer toursBooked) {
		this.toursBooked = toursBooked;
	}
	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", customerName=" + customerName + ", gender=" + gender
				+ ", birthday=" + birthday + ", phoneNumber=" + phoneNumber + ", eMail=" + eMail + ", departureAddress="
				+ departureAddress + ", additionalNotes=" + additionalNotes + ", loginInfo=" + loginInfo
				+ ", toursBooked=" + toursBooked + "]";
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	

}
