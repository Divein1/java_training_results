package by.java.training.chp.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.java.training.chp.dataacess.dao.DiscountsDao;
import by.java.training.chp.dataacess.model.Discounts;
import by.java.training.chp.services.DiscountsService;

@Service
public class DiscountsServiceImpl implements DiscountsService {
	@Autowired
	private DiscountsDao discountsDao;

	@Override
	public Discounts getById(Integer id) {
		return discountsDao.getById(id);
	}

	@Override
	public List<Discounts> findAll() {
		return discountsDao.findAll();
	}

	@Override
	public Integer insert(Discounts discount) {
		return  discountsDao.insert(discount);
	}

	@Override
	public void update(Discounts discount) {
		discountsDao.update(discount);
	}

	@Override
	public void delete(Discounts discount) {
		discountsDao.delete(discount);
	}

}
