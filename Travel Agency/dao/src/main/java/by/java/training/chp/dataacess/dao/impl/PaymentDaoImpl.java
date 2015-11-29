package by.java.training.chp.dataacess.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import by.java.training.chp.dataacess.dao.PaymentDao;
import by.java.training.chp.dataacess.model.Payment;
import paillard.florent.springframework.simplejdbcupdate.SimpleJdbcUpdate;
@Repository
public class PaymentDaoImpl extends GenericDaoImpl<Payment> implements PaymentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Payment getById(Integer id) {
		return getById(id, "payment", "payment_id");
	}

	@Override
	public void delete(Payment payment) {
		jdbcTemplate.update("DELETE FROM payment WHERE payment_id = ?", payment.getPaymentId());
		
	}

	@Override
	public Integer insert(Payment payment) {
		SimpleJdbcInsert jdbcInsert = new
				SimpleJdbcInsert(jdbcTemplate);
				jdbcInsert.withTableName("payment").usingGeneratedKeyColumns("payment_id");
				              Map<String, Object> parameters = new HashMap<String, Object>();
				              parameters.put("booking_id", payment.getBookingId());
				              parameters.put("amount_of_payment", payment.getAmountOfPayment());
				              parameters.put("date_of_payment", payment.getDateOfPayment());
				              Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
				              return ((Number) key).intValue();
		
	}

	@Override
	public void update(Payment payment) {
		SimpleJdbcUpdate jdbcUpdate = new SimpleJdbcUpdate(jdbcTemplate);
		jdbcUpdate
				.withTableName("payment").updatingColumns("amount_of_payment","date_of_payment")
				.restrictingColumns("customer_id");

		Map<String, Object> addParameters = new HashMap<String, Object>();
		  addParameters.put("amount_of_payment", payment.getAmountOfPayment());
          addParameters.put("date_of_payment", payment.getDateOfPayment());
		Map<String, Object> restrictParameters = new HashMap<String, Object>();
		restrictParameters.put("customer_id", payment.getPaymentId());
		jdbcUpdate.execute(addParameters, restrictParameters);
		
	}
	

}
