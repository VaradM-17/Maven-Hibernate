package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.User;

public class Dao {
	public void insert_Data(User u) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(User.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction t = ss.beginTransaction();

		ss.persist(u);
		System.out.println("Data Inserted");

		t.commit();
		ss.close();
	}

	public void update_Data(User u) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(User.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction t = ss.beginTransaction();

		String hqlQuery = "update User set name=:name where id=:id";
		Query<User> query = ss.createQuery(hqlQuery);
		query.setParameter("id", u.getId());
		query.setParameter("name", u.getName());
		query.executeUpdate();

		System.out.println("Data Updated");

		t.commit();
		ss.close();
	}

	public void delete_Data(User u) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(User.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction t = ss.beginTransaction();

		String hqlQuery = "delete from User where id =: myid";
		Query<User> query = ss.createQuery(hqlQuery);
		query.setParameter("myid", u.getId());
		query.executeUpdate();

		System.out.println("Record Deleted");

		t.commit();
		ss.close();
	}

	public void displayAll_Data() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(User.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction t = ss.beginTransaction();

		String hqlQuery = "from User";
		Query<User> query = ss.createQuery(hqlQuery, User.class);
		List<User> list = query.getResultList();

		System.out.println("User Details:");

		for (User user : list) {
			System.out.println(user);
		}
		t.commit();
		ss.close();
	}

	public User displaySingle_Data(int myid) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(User.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction t = ss.beginTransaction();

		String hqlQuery = "from User where id=:myid";
		Query<User> query = ss.createQuery(hqlQuery, User.class);
		query.setParameter("myid", myid);

		User u = query.getSingleResult();

		t.commit();
		ss.close();
		return u;
	}
}
