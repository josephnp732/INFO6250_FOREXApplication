package com.neu.edu.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.edu.exception.LoginException;
import com.neu.edu.pojo.User;

public class UserLoginDao extends DAO {

    public UserLoginDao() {

    }

    public User create(User user) throws LoginException {
        try {
            begin();
            getSession().save(user);
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new LoginException("Exception while loging in: " + e.getMessage());
        }
    }

    public User get(String userName, String password) throws LoginException {
        try {
            begin();
            Query q = getSession().createQuery("from User where userName= :userName AND password= :password"); 
            q.setString("userName", userName);
            q.setString("password", password);
            User user = (User) q.uniqueResult();
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new LoginException("User Not Found " + userName, e);
        }
    }
    

	public void update(User user) throws LoginException {
		try {
			begin();
			getSession().update(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new LoginException("Could not save the user details", e);
		}
	}
}
