package com.nit.dao;

import java.util.List;

import com.nit.enums.STATE;
import com.nit.model.Course;
public interface ICourseDao {
	public void addCourse(Course course);
	public Course getCourse(Integer id);
    public void deleteCourse(Integer id);
    public void updateCourse(Course course);
    public List<Course> allCourse();
    public void editState(Integer id,STATE state);
    public List<Course>  getActiveCourse();
}
