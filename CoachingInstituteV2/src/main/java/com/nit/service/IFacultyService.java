package com.nit.service;

import java.util.List;

import com.nit.dto.FacultyDTO;
import com.nit.model.Faculty;

public interface IFacultyService {

	public void registerFaculty(FacultyDTO faculty);
	public FacultyDTO showFaculty(Integer id);
    public void removeFaculty(Integer id);
    public void editFaculty(FacultyDTO faculty);
    public List<FacultyDTO> allFaculty();
    public List<FacultyDTO> showActiveFaculty();
    
}
