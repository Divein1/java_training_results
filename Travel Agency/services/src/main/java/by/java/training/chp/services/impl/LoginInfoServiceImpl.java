package by.java.training.chp.services.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.java.training.chp.dataacess.dao.LoginInfoDao;
import by.java.training.chp.dataacess.model.LoginInfo;
import by.java.training.chp.services.LoginInfoService;

@Service
public class LoginInfoServiceImpl implements LoginInfoService {
	@Autowired
	private LoginInfoDao loginInfoDao;

	@Override
	public void updateLogInfo(LoginInfo info) throws IOException {
		loginInfoDao.update(info);
	}

	@Override
	public LoginInfo createLogInfo(String username, String passworld) throws IOException {
		LoginInfo loginInfo = new LoginInfo();
		if (!loginInfoDao.checkExistance(username)) {
			loginInfo.setuLogin(username);
			loginInfo.setuPassworld(passworld);
		} else {
			throw new IOException(username + "Duplicate login field exception");
		}

		return loginInfo;
	}

	@Override
	public Integer insertAndGetKey(LoginInfo logInf) {
		Integer id = loginInfoDao.insert(logInf);
		return id;
	}

	@Override
	public LoginInfo getById(Integer id) {
		return loginInfoDao.getById(id);
	}

	@Override
	public void delete(LoginInfo info) {
		loginInfoDao.delete(info);
	}

}
