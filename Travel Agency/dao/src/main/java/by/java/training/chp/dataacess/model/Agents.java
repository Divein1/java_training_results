package by.java.training.chp.dataacess.model;

public class Agents {

	private Integer agentId;
	private String agentName;
	private Integer aLoginInfo;
	private String agentStatus;
	private String skype;
	
	public Integer getAgentId() {
		return agentId;
	}
	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public Integer getaLoginInfo() {
		return aLoginInfo;
	}
	public void setaLoginInfo(Integer aLoginInfo) {
		this.aLoginInfo = aLoginInfo;
	}
	public String getAgentStatus() {
		return agentStatus;
	}
	public void setAgentStatus(String agentStatus) {
		this.agentStatus = agentStatus;
	}
	public String getSkype() {
		return skype;
	}
	public void setSkype(String skype) {
		this.skype = skype;
	}
	@Override
	public String toString() {
		return "Agents [agentId=" + agentId + ", agentName=" + agentName + ", aLoginInfo=" + aLoginInfo
				+ ", agentStatus=" + agentStatus + ", skype=" + skype + "]";
	}
}
