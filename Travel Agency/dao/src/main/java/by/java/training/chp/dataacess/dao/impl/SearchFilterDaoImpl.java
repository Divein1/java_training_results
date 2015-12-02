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

import by.java.training.chp.dataacess.dao.SearchFilterDao;
import by.java.training.chp.dataacess.model.SearchFilter;

@Repository
public class SearchFilterDaoImpl implements SearchFilterDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private Table tours = new Table("tours");
	private Table hotel = new Table("hotel");
	private Table transports = new Table("transports");
	private Table travelPurpose = new Table("travel_purpose");
	private Table boardBasis = new Table("board_basis");
	private Table city = new Table("city");

	@Override
	public List<SearchFilter> get(SearchFilter searchFilter) {
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

		if (searchFilter.getVehicle_type() != null) {
			select.addCriteria(new MatchCriteria(tours, "transport_id", MatchCriteria.EQUALS, searchFilter.getVehicle_type()));
		}
		if (searchFilter.getCityName() != null) {
			select.addCriteria(new MatchCriteria(tours, "destination_id", MatchCriteria.EQUALS, searchFilter.getCityName()));
		}
		if (searchFilter.getFormOfTourism() != null) {
			select.addCriteria(new MatchCriteria(tours, "travel_purpose_id", MatchCriteria.EQUALS, searchFilter.getFormOfTourism()));
		}
		if (searchFilter.getMealType() != null) {
			select.addCriteria(new MatchCriteria(tours, "board_basis_id", MatchCriteria.EQUALS, searchFilter.getMealType()));
		}
		if (searchFilter.getPropertyType() != null) {
			select.addCriteria(new MatchCriteria(hotel, "property_type", MatchCriteria.EQUALS, searchFilter.getPropertyType()));
		}
		if (searchFilter.getPrice() != null) {
			select.addCriteria(new MatchCriteria(tours, "price", MatchCriteria.LESS, searchFilter.getPrice()));
		}
		if (searchFilter.getRating() != null) {
			select.addCriteria(new MatchCriteria(hotel, "rating", MatchCriteria.GREATER, searchFilter.getRating()));
		}
		if (searchFilter.getHasAirConditioning() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_air_conditioning", MatchCriteria.EQUALS, "Y"));
		}
		if (searchFilter.getHasSauna() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_sauna", MatchCriteria.EQUALS, "Y"));
		}
		if (searchFilter.getHasSafe() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_safe", MatchCriteria.EQUALS, "Y"));
		}
		if (searchFilter.getHasFitnessFacility() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_fitness_facility", MatchCriteria.EQUALS, "Y"));
		}
		if (searchFilter.getHasGameRoom() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_game_room", MatchCriteria.EQUALS, "Y"));
		}
		if (searchFilter.getHasHouseBar() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_house_bar", MatchCriteria.EQUALS, "Y"));
		}
		if (searchFilter.getHasChildrenAllowed() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_children_allowed", MatchCriteria.EQUALS, "Y"));
		}
		if (searchFilter.getHasTvInRoom() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_tv_in_room", MatchCriteria.EQUALS, "Y"));
		}
		if (searchFilter.getHasMeetingRoom() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_meeting_room", MatchCriteria.EQUALS, "Y"));
		}
		if (searchFilter.getHasBusinessCenter() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_business_center", MatchCriteria.EQUALS, "Y"));
		}
		if (searchFilter.getHasOutdoorPool() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_outdoor_pool", MatchCriteria.EQUALS, "Y"));
		}
		if (searchFilter.getHasNonSmokingRooms() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_non_smoking_rooms", MatchCriteria.EQUALS, "Y"));
		}
		if (searchFilter.getHasMiniBar() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_mini_bar", MatchCriteria.EQUALS, "Y"));
		}
		if (searchFilter.getHasRoomService() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_room_service", MatchCriteria.EQUALS, "Y"));
		}
		if (searchFilter.getHasFamilyRooms() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_family_rooms", MatchCriteria.EQUALS, "Y"));
		}
		if (searchFilter.getHasCarRentDesk() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_car_rent_desk", MatchCriteria.EQUALS, "Y"));
		}
		if (searchFilter.getHasHairDryer() != null) {
			select.addCriteria(new MatchCriteria(hotel, "has_hair_dryer", MatchCriteria.EQUALS, "Y"));
		}
		if (searchFilter.getDateOfDeparture() != null) {
			select.addCriteria(new MatchCriteria(tours, "date_of_departure", MatchCriteria.EQUALS, searchFilter.getDateOfDeparture()));
		}
		
		List<SearchFilter> toursFetched = new ArrayList<>();
		toursFetched = jdbcTemplate.query(select.toString(), new BeanPropertyRowMapper<SearchFilter>(SearchFilter.class));
		return toursFetched;
	}

}
