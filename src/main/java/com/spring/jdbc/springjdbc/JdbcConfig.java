package com.spring.jdbc.springjdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.springjdbc.dao.StudentDao;
import com.spring.jdbc.springjdbc.dao.StudentDaoImpl; 
@Configuration
public class JdbcConfig {
	
	@Bean("ds")
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.cj.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("1234");
		return ds;
		
	
	}
	 @Bean("jdbcTemplate")
	 public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
		
	}
	 
	 @Bean("jdbcTemplate")
	 public StudentDao getStudentDao() {
	
		 StudentDaoImpl studentDao = new StudentDaoImpl();
		 studentDao.setJdbcTemplate(getTemplate());;
		 return studentDao;
	 }
}
