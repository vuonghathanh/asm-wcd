package com.demo.dao;

import com.demo.entity.Product;
import com.demo.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public List<User> findUser(String username) {
        Transaction transaction = null;
        List userList = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("from User u where u.username = (:username)");
            query.setParameter("username", username);
            userList = query.getResultList();
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
        System.out.println(userList);
        return userList;
    }

}
