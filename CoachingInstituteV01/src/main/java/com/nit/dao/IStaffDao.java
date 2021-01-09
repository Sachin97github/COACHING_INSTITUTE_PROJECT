package com.nit.dao;

import java.util.List;

import com.nit.model.Course;
import com.nit.model.Staff;
public interface IStaffDao {
	public void addStaff(Staff staff);
	public Staff getStaff(Integer id);
    public void deleteStaff(Integer id);
    public void updateStaff(Staff staff);
    public List<Staff> allStaff();
}
