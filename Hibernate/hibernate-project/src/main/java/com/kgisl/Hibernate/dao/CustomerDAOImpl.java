package com.kgisl.Hibernate.dao;

import java.util.List;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kgisl.Hibernate.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> root = cq.from(Customer.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Customer book = session.byId(Customer.class).load(id);
        session.remove(book);
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.merge(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Customer theCustomer = currentSession.get(Customer.class, theId);
        return theCustomer;
    }

    @Override
    public void updateCustomer(Customer theCustomer) {
        Session currentSession = sessionFactory.getCurrentSession();
        int id = theCustomer.getId();
        Customer detachedCustomer = currentSession.get(Customer.class, id);
        detachedCustomer.setFirstName(theCustomer.getFirstName());
        detachedCustomer.setLastName(theCustomer.getLastName());
        detachedCustomer.setEmail(theCustomer.getEmail());
        currentSession.merge(detachedCustomer);
    }

}
