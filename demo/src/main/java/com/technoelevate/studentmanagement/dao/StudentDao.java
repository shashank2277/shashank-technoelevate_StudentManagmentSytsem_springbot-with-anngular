package com.technoelevate.studentmanagement.dao;

import com.technoelevate.studentmanagement.bean.StudentBean;

public interface StudentDao {

	public StudentBean searchStudent(int userid);

	public boolean insertStudent(StudentBean bean);

	public boolean delete(int Userid);

	public boolean updateStudent(StudentBean bean);

	public boolean aggregateMarks(double marks);

	public String grade(StudentBean bean);
}
