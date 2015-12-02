package by.java.training.chp.dataacess.model;

import java.util.Date;

public class SearchFilter {
	private Integer tourId;
	private String formOfTourism;
	private String vehicle_type;
	private String hotelName;
	private String mealType;
	private String cityName; 
	private Date dateOfDeparture;
	private Date dateOfArrival;
	private Integer price;
	private Double rating;
	private String propertyType;
	
	private Character hasSauna;       
	private Character hasSafe;
	private Character hasFitnessFacility;
	private Character hasGameRoom;
	private Character hasHouseBar;
	private Character hasChildrenAllowed;
	private Character hasTvInRoom;
	private Character hasMeetingRoom;
	private Character hasBusinessCenter;
	private Character hasOutdoorPool;
	private Character hasNonSmokingRooms;
	private Character hasAirConditioning;
	private Character hasMiniBar;
	private Character hasRoomService;
	private Character hasHairDryer;
	private Character hasCarRentDesk;     
	private Character hasFamilyRooms;
	
	public Integer getTourId() {
		return tourId;
	}
	public void setTourId(Integer tourId) {
		this.tourId = tourId;
	}
	public String getFormOfTourism() {
		return formOfTourism;
	}
	public void setFormOfTourism(String formOfTourism) {
		this.formOfTourism = formOfTourism;
	}
	public String getVehicle_type() {
		return vehicle_type;
	}
	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getMealType() {
		return mealType;
	}
	public void setMealType(String mealType) {
		this.mealType = mealType;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
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
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	@Override
	public String toString() {
		return "SearchFilter [formOfTourism=" + formOfTourism + ", vehicle_type=" + vehicle_type + ", hotelName="
				+ hotelName + ", mealType=" + mealType + ", cityName=" + cityName + ", dateOfDeparture="
				+ dateOfDeparture + ", dateOfArrival=" + dateOfArrival + ", price=" + price + ", rating=" + rating
				+ ", propertyType=" + propertyType + "]";
	}
	public Character getHasSauna() {
		return hasSauna;
	}
	public void setHasSauna() {
		this.hasSauna = 'Y';
	}
	public Character getHasSafe() {
		return hasSafe;
	}
	public void setHasSafe() {
		this.hasSafe = 'Y';
	}
	public Character getHasFitnessFacility() {
		return hasFitnessFacility;
	}
	public void setHasFitnessFacility() {
		this.hasFitnessFacility = 'Y';
	}
	public Character getHasGameRoom() {
		return hasGameRoom;
	}
	public void setHasGameRoom() {
		this.hasGameRoom = 'Y';
	}
	public Character getHasHouseBar() {
		return hasHouseBar;
	}
	public void setHasHouseBar() {
		this.hasHouseBar = 'Y';
	}
	public Character getHasChildrenAllowed() {
		return hasChildrenAllowed;
	}
	public void setHasChildrenAllowed() {
		this.hasChildrenAllowed = 'Y';
	}
	public Character getHasTvInRoom() {
		return hasTvInRoom;
	}
	public void setHasTvInRoom() {
		this.hasTvInRoom = 'Y';
	}
	public Character getHasMeetingRoom() {
		return hasMeetingRoom;
	}
	public void setHasMeetingRoom() {
		this.hasMeetingRoom = 'Y';
	}
	public Character getHasBusinessCenter() {
		return hasBusinessCenter;
	}
	public void setHasBusinessCenter() {
		this.hasBusinessCenter = 'Y';
	}
	public Character getHasOutdoorPool() {
		return hasOutdoorPool;
	}
	public void setHasOutdoorPool() {
		this.hasOutdoorPool = 'Y';
	}
	public Character getHasNonSmokingRooms() {
		return hasNonSmokingRooms;
	}
	public void setHasNonSmokingRooms() {
		this.hasNonSmokingRooms = 'Y';
	}
	public Character getHasAirConditioning() {
		return hasAirConditioning;
	}
	public void setHasAirConditioning() {
		this.hasAirConditioning = 'Y';
	}
	public Character getHasMiniBar() {
		return hasMiniBar;
	}
	public void setHasMiniBar() {
		this.hasMiniBar = 'Y';
	}
	public Character getHasRoomService() {
		return hasRoomService;
	}
	public void setHasRoomService() {
		this.hasRoomService = 'Y';
	}
	public Character getHasHairDryer() {
		return hasHairDryer;
	}
	public void setHasHairDryer() {
		this.hasHairDryer = 'Y';
	}
	public Character getHasCarRentDesk() {
		return hasCarRentDesk;
	}
	public void setHasCarRentDesk() {
		this.hasCarRentDesk = 'Y';
	}
	public Character getHasFamilyRooms() {
		return hasFamilyRooms;
	}
	public void setHasFamilyRooms() {
		this.hasFamilyRooms = 'Y';
	}
	
}
