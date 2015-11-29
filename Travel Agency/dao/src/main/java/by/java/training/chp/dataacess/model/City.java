package by.java.training.chp.dataacess.model;

public class City {
	private Integer cityId;
	private String cityName;
	private String countrycode;
	private String district;
	
	
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCountryCode() {
		return countrycode;
	}
	public void setCountryCode(String countryCode) {
		this.countrycode = countryCode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}

}
