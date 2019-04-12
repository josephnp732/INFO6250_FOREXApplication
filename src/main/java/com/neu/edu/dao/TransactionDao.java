package com.neu.edu.dao;

import com.neu.edu.exception.TransactionException;
import com.neu.edu.pojo.Transaction;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

public class TransactionDao extends DAO {

    public TransactionDao() {

    }

    public Transaction create(Transaction r) throws TransactionException {
        try {
            begin();
            getSession().save(r);
            commit();
            return r;
        } catch (HibernateException e) {
            rollback();
            throw new TransactionException("Exception while creating transaction: " + e.getMessage());
        }
    }

    public List<Transaction> get(int userId) throws TransactionException {
        try {
            begin();
            Query q = getSession().createQuery("from Transaction where user_id = :userId");
            q.setInteger("userId", userId);
            List<Transaction> recipients = (List<Transaction>) q.list();
            commit();
            return recipients;
        } catch (HibernateException e) {
            rollback();
            throw new TransactionException("Could not get the transactions " + e);
        }
    }
}
