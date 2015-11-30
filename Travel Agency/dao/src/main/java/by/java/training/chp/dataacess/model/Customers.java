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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
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
		Customers other = (Customers) obj;
		if (additionalNotes == null) {
			if (other.additionalNotes != null)
				return false;
		} else if (!additionalNotes.equals(other.additionalNotes))
			return false;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (departureAddress == null) {
			if (other.departureAddress != null)
				return false;
		} else if (!departureAddress.equals(other.departureAddress))
			return false;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (loginInfo == null) {
			if (other.loginInfo != null)
				return false;
		} else if (!loginInfo.equals(other.loginInfo))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (toursBooked == null) {
			if (other.toursBooked != null)
				return false;
		} else if (!toursBooked.equals(other.toursBooked))
			return false;
		return true;
	}
	
	

}
