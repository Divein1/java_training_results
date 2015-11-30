package by.java.training.chp.dataacess.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import by.java.training.chp.dataacess.dao.DiscountsDao;
import by.java.training.chp.dataacess.model.Discounts;
import paillard.florent.springframework.simplejdbcupdate.SimpleJdbcUpdate;

@Repository
public class DiscountsDaoImpl extends GenericDaoImpl<Discounts> implements DiscountsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Discounts getById(Integer id) {
		return getById(id, "discounts", "discount_id");
	}

	@Override
	public Integer insert(Discounts discount) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		jdbcInsert.withTableName("discounts").usingGeneratedKeyColumns("discount_id");
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("discount_reason", discount.getDiscountReason());
		parameters.put("discount_amount", discount.getDiscountAmount());
		Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
		return ((Number) key).intValue();

	}

	@Override
	public void update(Discounts discount) {
		SimpleJdbcUpdate jdbcUpdate = new SimpleJdbcUpdate(jdbcTemplate);
		jdbcUpdate.withTableName("discounts").updatingColumns("discount_reason", "discount_amount")
				.restrictingColumns("discount_id");
		Map<String, Object> addParameters = new HashMap<String, Object>();
		addParameters.put("discount_reason", discount.getDiscountReason());
		addParameters.put("discount_amount", discount.getDiscountAmount());
		Map<String, Object> restrictParameters = new HashMap<String, Object>();
		restrictParameters.put("discount_id", discount.getDiscountId());
		jdbcUpdate.execute(addParameters, restrictParameters);

	}

	@Override
	public void delete(Discounts discount) {
		jdbcTemplate.update("DELETE FROM discounts WHERE discount_id = ?", discount.getDiscountId());

	}
	@Override
	public List<Discounts> findAll() {
		return super.findAll("discounts");
	}

}
