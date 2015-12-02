package by.java.training.chp.dataacess.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import by.java.training.chp.dataacess.dao.DiscountsDao;
import by.java.training.chp.dataacess.model.Discounts;

@Repository
public class DiscountsDaoImpl extends GenericDaoImpl<Discounts>implements DiscountsDao {


	@Override
	public Discounts getById(Integer id) {
		return getById(id, "discounts", "discount_id");
	}

	@Override
	public Integer insert(Discounts discount) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("discount_reason", discount.getDiscountReason());
		parameters.put("discount_amount", discount.getDiscountAmount());
		return insert("discounts", "discount_id", parameters);
	}

	@Override
	public void update(Discounts discount) {
		Map<String, Object> addParameters = new HashMap<String, Object>();
		addParameters.put("discount_reason", discount.getDiscountReason());
		addParameters.put("discount_amount", discount.getDiscountAmount());
		Map<String, Object> restrictParameters = new HashMap<String, Object>();
		restrictParameters.put("discount_id", discount.getDiscountId());
		update("discounts", "discount_id", addParameters, restrictParameters);
	}

	@Override
	public void delete(Discounts discount) {
		delete(discount.getDiscountId(), "discounts", "discount_id");
	}

	@Override
	public List<Discounts> findAll() {
		return super.findAll("discounts");
	}

}
