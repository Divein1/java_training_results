package by.java.training.chp.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.java.training.chp.dataacess.dao.BoardBasisDao;
import by.java.training.chp.dataacess.model.BoardBasis;
import by.java.training.chp.services.BoardBasisService;

@Service
public class BoardBasisServiceImpl implements BoardBasisService {


	@Autowired
	private BoardBasisDao boardBasisDao;

	@Override
	public BoardBasis getById(Integer id) {
			return boardBasisDao.getById(id);
	}

}
