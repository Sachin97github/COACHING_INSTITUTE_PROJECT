package com.nit.dao;

import java.util.List;

import com.nit.model.Faculty;
import com.nit.model.Student;

public interface IStudentDao {
	public void addStudent(Student student);
	public Student getStudent(Integer id);
    public void deleteStudent(Integer id);
    public void updateStudent(Student student);
    public List<Student> allStudent();
}
