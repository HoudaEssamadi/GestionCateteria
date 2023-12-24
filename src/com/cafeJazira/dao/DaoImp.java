package com.cafeJazira.dao;

import java.util.List;

import com.cafeJazira.model.Cafe;
import com.cafeJazira.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DaoImp implements IDao<Cafe> {

	@Override
	public List<Cafe> getAll() {
		Session s = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		List<Cafe> cafe = s.createQuery("from Cafe").getResultList();
		t.commit();
		s.close();
		return cafe;
	}

	 @Override
	    public boolean create(Cafe cafe) {
	        Session session = HibernateUtils.getSessionfactory().getCurrentSession();
	        Transaction transaction = session.beginTransaction();

	        try {
	            session.save(cafe);
	            transaction.commit();
	            return true;
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	            return false;
	        } finally {
	            session.close();
	        }
	    }

	    @Override
	    public boolean update(Cafe cafe) {
	        Session session = HibernateUtils.getSessionfactory().getCurrentSession();
	        Transaction transaction = session.beginTransaction();

	        try {
	            session.update(cafe);
	            transaction.commit();
	            return true;
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	            return false;
	        } finally {
	            session.close();
	        }
	    }

	    @Override
	    public boolean delete(Cafe cafe) {
	        Session session = HibernateUtils.getSessionfactory().getCurrentSession();
	        Transaction transaction = session.beginTransaction();

	        try {
	            session.delete(cafe);
	            transaction.commit();
	            return true;
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	            return false;
	        } finally {
	            session.close();
	        }
	    }
}
