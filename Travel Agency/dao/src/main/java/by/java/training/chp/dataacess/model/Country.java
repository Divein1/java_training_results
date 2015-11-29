package by.java.training.chp.dataacess.model;


public class Country {
	private String code;
	private String countryName;
	private String region;
	private String localName;
	private String govermentForm;
	private String code2;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getLocalName() {
		return localName;
	}
	public void setLocalName(String localName) {
		this.localName = localName;
	}
	public String getGovermentForm() {
		return govermentForm;
	}
	public void setGovermentForm(String govermentForm) {
		this.govermentForm = govermentForm;
	}
	public String getCode2() {
		return code2;
	}
	public void setCode2(String code2) {
		this.code2 = code2;
	}
	@Override
	public String toString() {
		return "Country [code=" + code + ", countryName=" + countryName + ", region=" + region + ", localName="
				+ localName + ", code2=" + code2 + "]";
	}
	
	

}
