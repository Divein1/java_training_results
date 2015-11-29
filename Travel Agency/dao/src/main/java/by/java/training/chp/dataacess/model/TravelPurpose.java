package by.java.training.chp.dataacess.model;

public class TravelPurpose {
	private Integer purposeId;
	private String formOfTourism;
	
	public Integer getPurposeId() {
		return purposeId;
	}
	public void setPurposeId(Integer purposeId) {
		this.purposeId = purposeId;
	}
	public String getFormOfTourism() {
		return formOfTourism;
	}
	public void setFormOfTourism(String formOfTourism) {
		this.formOfTourism = formOfTourism;
	}
	@Override
	public String toString() {
		return "TravelPurpose [purposeId=" + purposeId + ", formOfTourism=" + formOfTourism + "]";
	}
	
	

}
