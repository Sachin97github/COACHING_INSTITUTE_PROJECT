package com.nit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nit.model.Course;
import com.nit.model.Faculty;
import com.nit.model.Staff;

@Repository
public class StaffDaoImpl implements IStaffDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public void addStaff(Staff staff) {
		 ht.save(staff);
	}

	@Override
	public Staff getStaff(Integer id) {
		return ht.get(Staff.class, id);
	}

	@Override
	public void deleteStaff(Integer id) {
		ht.delete(ht.load(Staff.class,id));
	}

	@Override
	public void updateStaff(Staff staff) {
	         ht.update(staff);
	}

	@Override
	public List<Staff> allStaff() {
		return ht.loadAll(Staff.class);
	}
	
	
}

