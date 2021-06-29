package com.technoelevate.studentmanagement.service;

import com.technoelevate.studentmanagement.bean.StudentBean;

public interface StudentService {

	public boolean insertStudent(StudentBean bean);

	public StudentBean searchStudent(int id);

	public boolean delete(int Userid);

	public boolean updateStudent(StudentBean bean);

	public boolean aggregateMarks(double marks);

	public String grade(StudentBean bean);
}
