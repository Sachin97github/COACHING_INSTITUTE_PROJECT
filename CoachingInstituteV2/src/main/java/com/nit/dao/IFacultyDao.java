package com.nit.dao;

import java.util.List;

import com.nit.enums.STATE;
import com.nit.model.Faculty;

public interface IFacultyDao {
	
	public void addFaculty(Faculty faculty);
	public Faculty getFaculty(Integer id);
    public void softDeleteFaculty(Integer id);
    public void hardDeleteFaculty(Integer id);
    public void updateFaculty(Faculty faculty);
    public void editState(Integer id, STATE state);
    public List<Faculty> allFaculty();
    public List<Faculty> getActiveFaculties();
    
}
