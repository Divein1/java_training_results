package by.java.training.chp.dataacess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.truemesh.squiggle.SelectQuery;
import com.truemesh.squiggle.Table;
import com.truemesh.squiggle.criteria.MatchCriteria;

import by.java.training.chp.dataacess.dao.ToursFilterDao;
import by.java.training.chp.dataacess.model.ToursFilter;

@Repository
public class ToursFilterDaoImpl implements ToursFilterDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private Table tours = new Table("tours");
	private Table hotel = new Table("hotel");
	private Table transports = new Table("transports");
	private Table travelPurpose = new Table("travel_purpose");
	private Table boardBasis = new Table("board_basis");
	private Table city = new Table("city");

	@Override
	public List<ToursFilter> get(ToursFilter toursFilter) {
		/*
		 * SQL Query Builder
		 * Rating -  higher than set
		 * Price -  lower than set
		 * Hotel properties processed as chars due to original database limitation
		 */
		SelectQuery select = new SelectQuery();
		select.addColumn(tours, "price");
		select.addColumn(tours, "date_of_arrival");
		select.addColumn(tours, "date_of_departure");
		select.addColumn(hotel, "hotel_name");
		select.addColumn(transports, "vehicle_type");
		select.addColumn(travelPurpose, "form_of_tourism");
		select.addColumn(boardBasis, "meal_type");
		select.addColumn(city, "city_name");
		select.addColumn(hotel, "rating");
		select.addColumn(hotel, "property_type");
		select.addColumn(tours, "tour_id");

		select.addJoin(tours, "travel_purpose_id", travelPurpose, "purpose_id");
		select.addJoin(tours, "destination_id", city, "city_id");
		select.addJoin(tours, "transport_id", transports, "transport_id");
		select.addJoin(tours, "hotel_id", hotel, "hotel_id");

		if (toursFilter.getVehicle_type() != null) {
			select.addCriteria(new MatchCriteria(tours, "transport_id", MatchCriteria.EQUALS, toursFilter.getVehicle_type()));
		}
		if (toursFilter.getCityName() != null) {
			select.addCriteria(new MatchCriteria(tours, "destination_id", MatchCriteria.EQUALS, toursFilter.getCityName()));
		}
		if (toursFilter.getFormOfTourism() != null) {
			select.addCriteria(new MatchCriteria(tours, "travel_purpose_id", MatchCriteria.EQUALS, toursFilter.getFormOfTourism()));
		}
		if (toursFilter.getMealType() != null) {
			select.addCriteria(new MatchCriteria(tours, "board_basis_id", MatchCriteria.EQUALS, toursFilter.getMealType()));
		}
		if (toursFilter.getPropertyType() != null) {
			select.addCriteria(new MatchCriteria(hotel, "property_type", MatchCriteria.EQUALS, toursFilter.getPropertyType()));
		}
		if (toursFilter.getPrice() != null) {
			select.addCriteria(new MatchCriteria(tours, "price", MatchCriteria.LESS, toursFilter.getPrice()));
		}
		if (toursFilter.getRating() != null) {
			select.addCriteria(new MatchCriteria(hotel, "rating", MatchCriteria.GREATER, toursFilter.getRating()));
		}
		if (toursFilter.getHasAirConditioning() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_air_conditioning", MatchCriteria.EQUALS, "Y"));
		}
		if (toursFilter.getHasSauna() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_sauna", MatchCriteria.EQUALS, "Y"));
		}
		if (toursFilter.getHasSafe() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_safe", MatchCriteria.EQUALS, "Y"));
		}
		if (toursFilter.getHasFitnessFacility() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_fitness_facility", MatchCriteria.EQUALS, "Y"));
		}
		if (toursFilter.getHasGameRoom() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_game_room", MatchCriteria.EQUALS, "Y"));
		}
		if (toursFilter.getHasHouseBar() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_house_bar", MatchCriteria.EQUALS, "Y"));
		}
		if (toursFilter.getHasChildrenAllowed() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_children_allowed", MatchCriteria.EQUALS, "Y"));
		}
		if (toursFilter.getHasTvInRoom() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_tv_in_room", MatchCriteria.EQUALS, "Y"));
		}
		if (toursFilter.getHasMeetingRoom() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_meeting_room", MatchCriteria.EQUALS, "Y"));
		}
		if (toursFilter.getHasBusinessCenter() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_business_center", MatchCriteria.EQUALS, "Y"));
		}
		if (toursFilter.getHasOutdoorPool() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_outdoor_pool", MatchCriteria.EQUALS, "Y"));
		}
		if (toursFilter.getHasNonSmokingRooms() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_non_smoking_rooms", MatchCriteria.EQUALS, "Y"));
		}
		if (toursFilter.getHasMiniBar() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_mini_bar", MatchCriteria.EQUALS, "Y"));
		}
		if (toursFilter.getHasRoomService() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_room_service", MatchCriteria.EQUALS, "Y"));
		}
		if (toursFilter.getHasFamilyRooms() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_family_rooms", MatchCriteria.EQUALS, "Y"));
		}
		if (toursFilter.getHasCarRentDesk() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_car_rent_desk", MatchCriteria.EQUALS, "Y"));
		}
		if (toursFilter.getHasHairDryer() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_hair_dryer", MatchCriteria.EQUALS, "Y"));
		}
		if (toursFilter.getDateOfDeparture() != null) {
			select.addCriteria(new MatchCriteria(tours, "date_of_departure", MatchCriteria.EQUALS, toursFilter.getDateOfDeparture()));
		}
		
		List<ToursFilter> toursFetched = new ArrayList<>();
		toursFetched = jdbcTemplate.query(select.toString(), new BeanPropertyRowMapper<ToursFilter>(ToursFilter.class));
		return toursFetched;
	}

}
