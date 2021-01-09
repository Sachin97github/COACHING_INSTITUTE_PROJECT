package com.nit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nit.model.Course;

@Repository
public class CourseDaoImpl implements ICourseDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public void addCourse(Course course) {
         ht.save(course);
	}

	@Override
	public Course getCourse(Integer id) {
      return    ht.load(Course.class,id);
	}

	@Override
	public void deleteCourse(Integer id) {
		  ht.delete(ht.load(Course.class,id));
	}
	@Override
	public void updateCourse(Course course) {
		 ht.update(course);	    
	}
	@Override
	public List<Course> allCourse() {
		return ht.loadAll(Course.class);
	}

}
