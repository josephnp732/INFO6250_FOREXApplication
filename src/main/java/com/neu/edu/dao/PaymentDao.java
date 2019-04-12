package com.neu.edu.dao;

import static com.neu.edu.dao.DAO.getSession;
import org.hibernate.HibernateException;

import com.neu.edu.exception.PaymentException;
import com.neu.edu.exception.UserException;
import com.neu.edu.pojo.Payment;
import com.neu.edu.pojo.Recipient;
import com.neu.edu.pojo.User;
import java.util.List;
import org.hibernate.Query;

public class PaymentDao extends DAO {

    public PaymentDao() {

    }

    public Payment create(Payment p) throws PaymentException {
        try {
            begin();
            getSession().save(p);
            commit();
            return p;
        } catch (HibernateException e) {
            rollback();
            throw new PaymentException("Exception while creating payment: " + e.getMessage());
        }
    }

    public List<Payment> get(int userId) throws UserException {
        try {
            begin();
            Query q = getSession().createQuery("from Payment where user_id = :userId");
            q.setInteger("userId", userId);
            List<Payment> paymentList = (List<Payment>) q.list();
            commit();
            return paymentList;
        } catch (HibernateException e) {
            rollback();
            throw new UserException("Could not get user " + userId, e);
        }
    }

    public void delete(int cardId) throws PaymentException {
        try {
        	 begin();
             Query q = getSession().createQuery("from Payment where cardId= :cardId");
             q.setInteger("cardId", cardId);
             Payment p = (Payment) q.uniqueResult();
             getSession().delete(p);
             commit();
        } catch (HibernateException e) {
            rollback();
            throw new PaymentException("Could not delete user " + e);
        }
    }
}
