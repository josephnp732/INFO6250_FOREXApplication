package com.neu.edu.dao;

import static com.neu.edu.dao.DAO.getSession;
import com.neu.edu.exception.PaymentException;
import com.neu.edu.exception.RecipientException;
import com.neu.edu.exception.UserException;
import com.neu.edu.pojo.Payment;
import com.neu.edu.pojo.Recipient;
import com.neu.edu.pojo.User;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

public class RecipientDao extends DAO {
    
    public RecipientDao() {
        
    }

    public Recipient create(Recipient r) throws RecipientException {
        try {
            begin();
            getSession().save(r);
            commit();
            return r;
        } catch (HibernateException e) {
            rollback();
            throw new RecipientException("Exception while creating recipient: " + e.getMessage());
        }
    }

    public List<Recipient> get(int userId) throws RecipientException {
        try {
            begin();
            Query q = getSession().createQuery("from Recipient where user_id= :userId");
            q.setInteger("userId", userId);
            List<Recipient> recipients = (List<Recipient>) q.list();
            commit();
            return recipients;
        } catch (HibernateException e) {
            rollback();
            throw new RecipientException("Could not get recipient " + e);
        }
    }

    public void delete(int recipientId) throws PaymentException {
        try {
            begin();
            Query q = getSession().createQuery("from Recipient where recipientId= :recipientId");
            q.setInteger("recipientId", recipientId);
            Recipient r = (Recipient) q.uniqueResult();
            getSession().delete(r);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new PaymentException("Could not delete recipient " + e);
        }
    }
}
