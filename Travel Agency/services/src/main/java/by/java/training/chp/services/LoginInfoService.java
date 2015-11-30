package by.java.training.chp.services;

import java.io.IOException;

import by.java.training.chp.dataacess.model.LoginInfo;

public interface LoginInfoService {
	LoginInfo createLogInfo(String username, String passworld) throws IOException;
	Integer insertAndGetKey(LoginInfo logInf);
	LoginInfo getById(Integer id);
	void updateLogInfo(LoginInfo info)throws IOException;
	void delete(LoginInfo info);
}
