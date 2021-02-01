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
import com.nit.enums.STATE;
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
		Faculty faculty=facultyDao.getFaculty(dto.getFacultyDTO().getId());		
		BeanUtils.copyProperties(dto, course);
		
		course.setFaculty(faculty);
		System.out.println(course);
		
		 dao.addCourse(course);
	}

	@Override
	@Transactional(readOnly=true)
	public CourseDTO showCourse(Integer id) {
		Course course=dao.getCourse(id);
		CourseDTO dto=new CourseDTO();
		BeanUtils.copyProperties(course, dto);
		
		FacultyDTO facultyDto=new FacultyDTO();
		
		BeanUtils.copyProperties(course.getFaculty(),facultyDto);
		dto.setFacultyDTO(facultyDto);		
		return dto;
	}

	@Override
	@Transactional(readOnly=false)
	public void removeCourse(Integer id) {
		dao.deleteCourse(id);
	}

	@Override
	@Transactional(readOnly=false)
	public void editCourse(CourseDTO dto) {
		Course course=new Course();
		BeanUtils.copyProperties(dto, course);
		dao.updateCourse(course);		
	}

	@Override
	@Transactional(readOnly=false)
	public void changeCourseState(Integer id, STATE state) {
	          dao.editState(id, state);
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

	@Override
	@Transactional(readOnly=true)
	public List<CourseDTO> showActiveCourse() {
		List<CourseDTO> listDto=new ArrayList();
		List<Course> list=dao.getActiveCourse();
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
