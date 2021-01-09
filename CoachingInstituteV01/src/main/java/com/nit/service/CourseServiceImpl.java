package com.nit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nit.dao.ICourseDao;
import com.nit.dto.CourseDTO;
import com.nit.model.Course;
@Service
public class CourseServiceImpl implements ICourseService {

	@Autowired
	private ICourseDao dao;

	@Override
	@Transactional(readOnly=false)
	public void registerCourse(CourseDTO dto) {
		Course course=new Course();
		BeanUtils.copyProperties(dto, course);
		 dao.addCourse(course);
	}

	@Override
	@Transactional(readOnly=true)
	public CourseDTO showCourse(Integer id) {
		Course course=dao.getCourse(id);
		CourseDTO dto=new CourseDTO();
		BeanUtils.copyProperties(course,dto);
		return dto;
	}

	@Override
	@Transactional(readOnly=false)
	public void removeCourse(Integer id) {
		dao.getCourse(id);   
	}

	@Override
	@Transactional(readOnly=false)
	public void editCourse(CourseDTO dto) {
		Course course=new Course();
		BeanUtils.copyProperties(dto, course);
		dao.updateCourse(course);		
	}

	@Override
	@Transactional(readOnly=true)
	public List<CourseDTO> allCourse() {
		List<CourseDTO> listDto=new ArrayList();
		List<Course> list=new ArrayList();
		list.forEach(course->{
			CourseDTO dto=new CourseDTO();
			BeanUtils.copyProperties(course, dto);
			listDto.add(dto);	
		});
		return listDto;
	}
	
}
