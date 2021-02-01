package com.nit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nit.enums.STATE;
import com.nit.model.Faculty;

@Repository
public class FacultyDaoImpl implements IFacultyDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Faculty getFaculty(Integer id) {
		return ht.get(Faculty.class,id);
	}

	@Override
	public void addFaculty(Faculty faculty) {
		 ht.save(faculty);
	}
	
	@Override
	public void softDeleteFaculty(Integer id) {
		 ht.execute(session -> {
			 System.out.println("INSIDE EXECUTE ");
		      Query query = session.createQuery("UPDATE Faculty set state = :state_type where id = :id");
		      query.setParameter("state_type",STATE.NOTACTIVE);
		      query.setParameter("id", id);
		      return query.executeUpdate();
		    });
		 System.out.println("DELETED");
	}
	@Override
	public void hardDeleteFaculty(Integer id) {
	        ht.delete(ht.get(Faculty.class, id));
	}	
	@Override
	public void updateFaculty(Faculty faculty) {
	       ht.update(faculty);
	}
	
	
	@Override
	public void editState(Integer id, STATE state) {
		 ht.execute(session->{
			 Query query=session.createQuery("update Faculty set state=:state where id=:id");
			 query.setParameter("state", state);
			 query.setParameter("id", id);
			 return query.executeUpdate();
		 });		
	}

	@Override
	public List<Faculty> allFaculty() {
		return	 ht.loadAll(Faculty.class);
	}
	
	@Override
	public List<Faculty> getActiveFaculties() {
		return ht.execute(session->{
			Criteria criteria=session.createCriteria(Faculty.class);
			criteria.add(Restrictions.in("state", STATE.ACTIVE));
			return criteria.list();
		});
	}

	
}
