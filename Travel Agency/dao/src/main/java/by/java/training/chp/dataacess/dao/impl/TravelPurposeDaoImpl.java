package by.java.training.chp.dataacess.dao.impl;

import org.springframework.stereotype.Repository;

import by.java.training.chp.dataacess.dao.TravelPurposeDao;
import by.java.training.chp.dataacess.model.TravelPurpose;

@Repository
public class TravelPurposeDaoImpl extends GenericDaoImpl<TravelPurpose> implements TravelPurposeDao{
	
	@Override
	public TravelPurpose getById(Integer id) {
		return getById(id, "travel_purpose", "purpose_id");
	}

}
