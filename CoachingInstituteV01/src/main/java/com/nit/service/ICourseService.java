package com.nit.service;

import java.util.List;

import com.nit.dto.CourseDTO;
import com.nit.dto.FacultyDTO;

public interface ICourseService {
	public void registerCourse(CourseDTO dto);
	public CourseDTO showCourse(Integer id);
    public void removeCourse(Integer id);
    public void editCourse(CourseDTO dto);
    public List<CourseDTO> allCourse();    
}
