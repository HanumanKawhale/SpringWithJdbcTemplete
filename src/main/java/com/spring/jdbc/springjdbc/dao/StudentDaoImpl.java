package com.spring.jdbc.springjdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.springjdbc.entities.Student;

public  class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	public int insert(Student student) {
		String query = "insert into student(id,name,city)values(?,?,?)";
		int n = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return n;
	}
	
	public int change(Student student) {
		//updating data
		String query = "update student set name=?,city=? where id=?";
		int n =  this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return n;
	}
	
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int delete(int studentId) {
		//delete 
		String query = "delete from student where id=?";
		int n = this.jdbcTemplate.update(query,studentId);
		return n;
	}

	public Student getStudent(int studentId) {
		//select single data
		String query = "select *from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl(); 
		Student student =  this.jdbcTemplate.queryForObject(query,rowMapper,studentId);
		return student;
	}

	public List<Student> getAllStudent() {

    //selecting multple
		String query = "select * from student";
		List<Student> students = this.jdbcTemplate.query(query,new RowMapperImpl());
		return students;
	}
	
	
	

	
	

}
