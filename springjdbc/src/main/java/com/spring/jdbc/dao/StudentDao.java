package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entities.Student;

public interface StudentDao {

	public int insert(Student student);
	public int update(Student student);
	public int delete(int studId);
	public Student selectOne (int studId);
	public List<Student> selectAll ();
}
