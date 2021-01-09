package com.nit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

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
	public void deleteFaculty(Integer id) {
		Faculty faculty=ht.get(Faculty.class, id);
		ht.delete(faculty);
	}
	
	@Override
	public void updateFaculty(Faculty faculty) {
	       ht.update(faculty);
	}

	@Override
	public List<Faculty> allFaculty() {
		return	 ht.loadAll(Faculty.class);
	}
	
}
