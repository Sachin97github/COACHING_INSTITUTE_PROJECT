package com.nit.dao;

import java.util.List;

import com.nit.model.Course;
public interface ICourseDao {
	public void addCourse(Course course);
	public Course getCourse(Integer id);
    public void deleteCourse(Integer id);
    public void updateCourse(Course course);
    public List<Course> allCourse();
}
