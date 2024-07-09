package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Student student) {

		String query = "insert into Student(id,name,address) values(?,?,?);";
		int result = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getAddress());
		return result;
	}

	@Override
	public int update(Student student) {
		String query = "update student set name=?,address=? where id=?";
		int r = this.jdbcTemplate.update(query,student.getName(),student.getAddress(),student.getId());
		return r;
	}

	@Override
	public int delete(int studId) {
		String query = "delete from student where id = ?";
		int r = this.jdbcTemplate.update(query,studId);
		return r;
	}

	@Override
	public Student selectOne(int studId) {
		String query = "select * from student where id = ?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student std = this.jdbcTemplate.queryForObject(query, rowMapper,studId);
		return std;
	}

	@Override
	public List<Student> selectAll() {
		String query = "select * from student";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		List<Student> studList = this.jdbcTemplate.query(query, rowMapper);
		return studList;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
