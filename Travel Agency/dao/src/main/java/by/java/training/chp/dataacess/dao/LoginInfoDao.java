package by.java.training.chp.dataacess.dao;

import by.java.training.chp.dataacess.model.LoginInfo;

public interface LoginInfoDao {
LoginInfo getById(Integer id);

Integer insert(LoginInfo loginInfo);
void update(LoginInfo loginInfo);
Boolean checkExistance(String login);
Boolean checkExistance(String login, Integer id);
void delete(LoginInfo loginInfo);
}
