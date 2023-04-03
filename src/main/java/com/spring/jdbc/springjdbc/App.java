package com.spring.jdbc.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jdbc.springjdbc.dao.StudentDao;
import com.spring.jdbc.springjdbc.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        
        StudentDao studentDao =  context.getBean("studentDao",StudentDao.class);
           
        //insert
//        Student student = new Student();
//        student.setId(333);
//        student.setCity("banglore");
//        student.setName("Mahesh");
//        int result =   studentDao.insert(student); 
//        System.out.println("your insert" +result);
          
        //update
//          Student student=new Student();
//          student.setCity("london");
//          student.setName("tushar");
//          student.setId(333);
//          int result= StudentDao.change(student);
//         
            //delete
//            int result = studentDao.delete(234);
//            System.out.println("delete row" + result);
//  
   
    //      
             Student student = studentDao.getStudent(222);
             System.out.println(student);
             //selecting multiple
             List<Student> students = studentDao.getAllStudent();
             
             for(Student s :students) {
            	 System.out.println(s);
             }
            		 
    
    }
}
