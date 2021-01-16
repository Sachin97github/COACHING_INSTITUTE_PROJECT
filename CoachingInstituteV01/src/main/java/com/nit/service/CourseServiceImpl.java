package com.nit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nit.dao.ICourseDao;
import com.nit.dao.IFacultyDao;
import com.nit.dto.CourseDTO;
import com.nit.dto.FacultyDTO;
import com.nit.model.Course;
import com.nit.model.Faculty;
@Service
public class CourseServiceImpl implements ICourseService {

	@Autowired
	private ICourseDao dao;
	
	@Autowired
	private IFacultyDao facultyDao;

	@Override
	@Transactional(readOnly=false)
	public void registerCourse(CourseDTO dto) {
		Course course=new Course();
		BeanUtils.copyProperties(dto, course);
		Faculty faculty=facultyDao.getFaculty(1);
		course.setFaculty(faculty);
		System.out.println(course);
		System.out.println(faculty);
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
		List<Course> list=dao.allCourse();
		list.forEach(course->{
			CourseDTO dto=new CourseDTO();
			BeanUtils.copyProperties(course, dto);
			// add Faculty to Faculty DTO
			 Faculty faculty=course.getFaculty();
			 FacultyDTO facultyDTO=new FacultyDTO();
			 BeanUtils.copyProperties(faculty, facultyDTO);
            dto.setFacultyDTO(facultyDTO);
            System.out.println(dto);
			listDto.add(dto);	
		});
		return listDto;
	}
	
}
