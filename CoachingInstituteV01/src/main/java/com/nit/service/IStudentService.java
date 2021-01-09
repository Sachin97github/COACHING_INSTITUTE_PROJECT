package com.nit.service;

import java.util.List;

import com.nit.dto.StudentDTO;
import com.nit.model.Faculty;
import com.nit.model.Student;

public interface IStudentService {

	public void registerStudent(StudentDTO stdDTO);
	public StudentDTO showStudent(Integer id);
    public void removeStudent(Integer id);
    public void editStudent(StudentDTO stdDTO);
    public List<StudentDTO> showAllStudent();
    
}
