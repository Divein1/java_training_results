package by.java.training.chp.dataacess.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import by.java.training.chp.dataacess.dao.CustomersDao;
import by.java.training.chp.dataacess.model.Customers;
import paillard.florent.springframework.simplejdbcupdate.SimpleJdbcUpdate;

@Repository
public class CustomersDaoImpl extends GenericDaoImpl<Customers>implements CustomersDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Customers getById(Integer id) {
		return getById(id, "customers", "customer_id");

	}

	@Override
	public Integer insert(Customers customer) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("customer_name", customer.getCustomerName());
		parameters.put("gender", customer.getGender());
		parameters.put("birthday", customer.getBirthday());
		parameters.put("phone_number", customer.getPhoneNumber());
		parameters.put("e_mail", customer.geteMail());
		parameters.put("departure_address", customer.getDepartureAddress());
		parameters.put("additional_notes", customer.getAdditionalNotes());
		parameters.put("login_info", customer.getLoginInfo());
		parameters.put("tours_booked", customer.getToursBooked());
		return insert("customers", "customer_id", parameters);
	}

	@Override
	public void delete(Customers customer) {
		delete(customer.getCustomerId(), "customers", "customer_id");
	}

	@Override
	public void update(Customers customer) {
		Map<String, Object> addParameters = new HashMap<String, Object>();
		addParameters.put("customer_name", customer.getCustomerName());
		addParameters.put("gender", customer.getGender());
		addParameters.put("birthday", customer.getBirthday());
		addParameters.put("phone_number", customer.getPhoneNumber());
		addParameters.put("e_mail", customer.geteMail());
		addParameters.put("departure_address", customer.getDepartureAddress());
		addParameters.put("additional_notes", customer.getAdditionalNotes());
		addParameters.put("login_info", customer.getLoginInfo());
		addParameters.put("tours_booked", customer.getToursBooked());
		Map<String, Object> restrictParameters = new HashMap<String, Object>();
		restrictParameters.put("customer_id", customer.getCustomerId());
		update("customers", "customer_id", addParameters, restrictParameters);
	}

	@Override
	public Customers getByLogin(String str) {
		return (Customers) jdbcTemplate.queryForObject(
				"SELECT  public.customers.gender,  public.customers.birthday, public.customers.phone_number, "
						+ "public.customers.e_mail,  public.customers.departure_address, public.customers.additional_notes, "
						+ "  public.customers.tours_booked,  public.customers.login_info,  public.customers.customer_id,  public.customers.customer_name FROM  public.customers "
						+ " INNER JOIN public.login_info ON (public.customers.login_info = public.login_info.info_id) WHERE public.login_info.u_login =  ?",
				new Object[] { str }, new BeanPropertyRowMapper<Customers>(Customers.class));
	}

	public List<Customers> findAll() {
		return super.findAll("customers");
	}

}
