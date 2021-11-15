package com.demo.dao;

import com.demo.entity.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    @SuppressWarnings("unchecked")
    public List<Product> getAllProduct() {
        Transaction transaction = null;
        List<Product> products = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            products = session.createQuery("from Product").getResultList();
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
        return products;
    }
}
