package com.nit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nit.dao.IStudentDao;
import com.nit.dto.StudentDTO;
import com.nit.model.Student;

@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	private IStudentDao dao;

	@Override
	@Transactional(readOnly=false)
	public StudentDTO registerStudent(StudentDTO stdDTO) {
		Student student=new Student();
		BeanUtils.copyProperties(stdDTO, student);
		System.out.println("DTO "+stdDTO);
		System.out.println("STD "+student);
		student=dao.addStudent(student);
		BeanUtils.copyProperties(student, stdDTO);
		return stdDTO;
	}
	@Override
	@Transactional(readOnly=true)
	public StudentDTO showStudent(Integer id) {
		StudentDTO dto=new StudentDTO();
		Student student=dao.getStudent(id);
		BeanUtils.copyProperties(student, dto);
	   return  dto;
	}
	@Override
	@Transactional(readOnly=false)
	public void removeStudent(Integer id) {
		 dao.deleteStudent(id);
	}

	@Override
	@Transactional(readOnly=false)
	public void editStudent(StudentDTO stdDTO) {
		 Student std=new Student();
		 BeanUtils.copyProperties(stdDTO, std);
	     dao.updateStudent(std);	  
	}
	@Override
	@Transactional(readOnly=false)
	public List<StudentDTO> showAllStudent() {
		List<StudentDTO> list=new ArrayList();
		    dao.allStudent().forEach(student->{
		    	StudentDTO dto=new StudentDTO();
		    	BeanUtils.copyProperties(student, dto);
		    	dto.setCourseids(student.getCourseids());
		    	list.add(dto);		    	
		    });
		return list;
	}
	public Student copy(StudentDTO dto)
	{
		Student student=new Student();
		BeanUtils.copyProperties(dto, student);
		return student;
	}
	
}
