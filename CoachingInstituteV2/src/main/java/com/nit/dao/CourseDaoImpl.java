package com.nit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nit.enums.STATE;
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
      return    ht.get(Course.class,id);
	}

	@Override
	public void deleteCourse(Integer id) {
		  ht.delete(ht.get(Course.class,id));
	}
	@Override
	public void updateCourse(Course course) {
		 ht.update(course);	    
	}

	@Override
	public void editState(Integer id, STATE state) {
		 ht.execute(session->{
			 Query query=session.createQuery("update Course set state=:state where id=:id");
			 query.setParameter("state", state);
			 query.setParameter("id", id);
			 return query.executeUpdate();
		 });		
	}
	@Override
    public List<Course>  getActiveCourse()
    {
    	return ht.execute(session->{
    		 Criteria ct=session.createCriteria(Course.class);
    		ct.add(Restrictions.in("state",STATE.ACTIVE,STATE.UPCOMING)); 
    		return ct.list();
    	});
    }
	
	@Override
	public List<Course> allCourse() {
		return ht.loadAll(Course.class);
	}


}
