package com.nit.dao;

import java.util.List;

import com.nit.model.Faculty;

public interface IFacultyDao {
	public void addFaculty(Faculty faculty);
	public Faculty getFaculty(Integer id);
    public void deleteFaculty(Integer id);
    public void updateFaculty(Faculty faculty);
    public List<Faculty> allFaculty();
    
}
