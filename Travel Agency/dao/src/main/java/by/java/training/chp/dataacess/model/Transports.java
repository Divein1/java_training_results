package by.java.training.chp.dataacess.model;

public class Transports {
	private Integer transportId;
	private String vehicleType;

	public Integer getTransportId() {
		return transportId;
	}

	public void setTransportId(Integer transportId) {
		this.transportId = transportId;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	@Override
	public String toString() {
		return "Transports [transportId=" + transportId + ", vehicleType=" + vehicleType + "]";
	}

}
