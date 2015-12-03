package by.java.training.chp.dataacess.model;

import java.util.Date;

public class Tours {
	private Integer tourId;
	private Integer travelPurposeId;
	private Integer transportId;
	private Integer hotelId;
	private Integer boardBasisId;
	private Integer destination; 
	private Date dateOfDeparture;
	private Date dateOfArrival;
	private Integer price;
	
	public Integer getTourId() {
		return tourId;
	}
	public void setTourId(Integer tourId) {
		this.tourId = tourId;
	}
	public Integer getTravelPurposeId() {
		return travelPurposeId;
	}
	public void setTravelPurposeId(Integer travelPurposeId) {
		this.travelPurposeId = travelPurposeId;
	}
	public Integer getTransportId() {
		return transportId;
	}
	public void setTransportId(Integer transportId) {
		this.transportId = transportId;
	}
	public Integer getHotelId() {
		return hotelId;
	}
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
	public Integer getBoardBasisId() {
		return boardBasisId;
	}
	public void setBoardBasisId(Integer boardBasisId) {
		this.boardBasisId = boardBasisId;
	}
	public Integer getDestinationId() {
		return destination;
	}
	public void setDestination(Integer destination) {
		this.destination = destination;
	}
	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}
	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}
	public Date getDateOfArrival() {
		return dateOfArrival;
	}
	public void setDateOfArrival(Date dateOfArrival) {
		this.dateOfArrival = dateOfArrival;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Tours [tourId=" + tourId + ", travelPurposeId=" + travelPurposeId + ", transportId=" + transportId
				+ ", hotelId=" + hotelId + ", boardBasisId=" + boardBasisId + ", destination=" + destination
				+ ", dateOfDeparture=" + dateOfDeparture + ", dateOfArrival=" + dateOfArrival + ", price=" + price
				+ "]";
	}
	

}
