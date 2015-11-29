package by.java.training.chp.dataacess.dao.impl;

import org.springframework.stereotype.Repository;

import by.java.training.chp.dataacess.dao.BoardBasisDao;
import by.java.training.chp.dataacess.model.BoardBasis;

@Repository
public class BoardBasisDaoImpl extends GenericDaoImpl<BoardBasis>implements BoardBasisDao {

	@Override
	public BoardBasis getById(Integer id) {
		return getById(id, "board_basis", "board_basis_id");
	}

}
