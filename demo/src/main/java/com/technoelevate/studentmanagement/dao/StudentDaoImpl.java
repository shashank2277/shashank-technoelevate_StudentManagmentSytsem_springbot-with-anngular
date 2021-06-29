package com.technoelevate.studentmanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.technoelevate.studentmanagement.bean.StudentBean;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Override
	public boolean insertStudent(StudentBean bean) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student_db");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();

		try {

			transaction.begin();

			manager.persist(bean);

			boolean isadded = false;

			if (bean != null) {
				isadded = true;
				transaction.commit();
				return isadded;
			} else {
				isadded = false;
				return isadded;
			}
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public StudentBean searchStudent(int userid) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student_db");
		EntityManager manager = factory.createEntityManager();
		StudentBean bean = manager.find(StudentBean.class, userid);

		return bean;

	}

	@Override
	public boolean delete(int userid) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student_db");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		StudentBean bean = manager.find(StudentBean.class, userid);
		if (bean != null) {
			manager.remove(bean);
			transaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public boolean updateStudent(StudentBean bean) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student_db");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();

			StudentBean data = manager.find(StudentBean.class, bean.getUserid());
			if (bean.getName() != null && bean.getName() != "") {
				data.setName(bean.getName());
			}
			if (bean.getEmail() != null) {
				data.setEmail(bean.getEmail());
			}

			transaction.commit();
			return true;

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean aggregateMarks(double marks) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String grade(StudentBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

}
