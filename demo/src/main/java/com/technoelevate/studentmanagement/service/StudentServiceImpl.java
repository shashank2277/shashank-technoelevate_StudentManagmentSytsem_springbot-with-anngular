package com.technoelevate.studentmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technoelevate.studentmanagement.bean.StudentBean;
import com.technoelevate.studentmanagement.dao.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao dao;
	@Override
	public boolean insertStudent(StudentBean bean) {
		// TODO Auto-generated method stub
		return dao.insertStudent(bean) ;
	}

	@Override
	public boolean delete(int Userid) {
		// TODO Auto-generated method stub
		return dao.delete(Userid);
	}

	@Override
	public boolean updateStudent(StudentBean bean) {
		// TODO Auto-generated method stub
		return dao.updateStudent(bean);
	}

	@Override
	public boolean aggregateMarks(double marks) {
		// TODO Auto-generated method stub
		return dao.aggregateMarks(marks);
	}

	@Override
	public String grade(StudentBean bean) {
		// TODO Auto-generated method stub
		return dao.grade(bean);
	}

	@Override
	public StudentBean searchStudent(int id) {
		// TODO Auto-generated method stub
		return dao.searchStudent(id);
	}
	

}
