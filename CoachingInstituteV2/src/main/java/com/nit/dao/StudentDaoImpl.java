package com.nit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nit.model.Student;

@Repository
public class StudentDaoImpl implements IStudentDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Student addStudent(Student student) {
	   ht.save(student);
	   return student;
	}

	@Override
	public Student getStudent(Integer id) {
		return  ht.get(Student.class, id);
	}
	@Override
	public void deleteStudent(Integer id) {
	 
		  ht.delete(ht.get(Student.class, id));
	}

	@Override
	public void updateStudent(Student student) {
	    ht.update(student);	  
	}
	@Override
	public List<Student> allStudent() {
		List<Student> list= ht.execute(session->{
		Criteria ct=session.createCriteria(Student.class);
		 return ct.list();
		});
		System.out.println("dAO");
		list.forEach(student->{
			    for(Integer num : student.getCourseids())
			    {
			    	System.out.println(num);
			    }
		});
		
		return list;
	}
	

}
