package by.java.training.chp.dataacess.dao;

import by.java.training.chp.dataacess.model.Payment;

public interface PaymentDao {
Payment getById(Integer id);
void delete(Payment payment);
Integer insert(Payment payment);
void update(Payment payment);

}
