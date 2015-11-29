package by.java.training.chp.dataacess.model;

public class LoginInfo {
	private Integer infoId;
	private String uLogin;
	private String uPassworld;
	
	public Integer getInfoId() {
		return infoId;
	}
	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}
	public String getuLogin() {
		return uLogin;
	}
	public void setuLogin(String uLogin) {
		this.uLogin = uLogin;
	}
	public String getuPassworld() {
		return uPassworld;
	}
	public void setuPassworld(String uPassworld) {
		this.uPassworld = uPassworld;
	}
	@Override
	public String toString() {
		return "LoginInfo [infoId=" + infoId + ", uLogin=" + uLogin + ", uPassworld=" + uPassworld + "]";
	}

}
