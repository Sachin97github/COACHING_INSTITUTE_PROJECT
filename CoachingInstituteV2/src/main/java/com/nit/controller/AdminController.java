package com.nit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nit.dto.CourseDTO;
import com.nit.dto.FacultyDTO;
import com.nit.dto.StaffDTO;
import com.nit.dto.StudentDTO;
import com.nit.service.ICourseService;
import com.nit.service.IFacultyService;
import com.nit.service.IStaffService;
import com.nit.service.IStudentService;

@Controller
public class AdminController {
	
	@Autowired
	private IStudentService studentService;
	@Autowired
	private ICourseService courseService;
	@Autowired
	private IFacultyService facultyService;
	@Autowired
	private IStaffService staffService;
	
	@GetMapping("/admin/adminPanel")
	public String showAdminPanel()
	{
		return "adminPanel";
	}
	
	@GetMapping("admin/faculties")
	public String showFaculty(Map<String,Object> map)
	{
	   List<FacultyDTO> listDTO= facultyService.allFaculty();
	   map.put("facultyList", listDTO);
	  return "adminFaculties";
	}

	@GetMapping("/admin/staffMembers")
	public String showStaff(Map<String,Object> map)
	{
		List<StaffDTO> listDTO=staffService.allStaff();
		listDTO.forEach(dto->{
			System.out.println(dto);
		});
		map.put("staffList", listDTO);
		return "adminStaff";
	}
	
	@GetMapping("/admin/students")
	public String showStudent(Map<String,Object> map)
	{
		List<StudentDTO> listDTO=studentService.showAllStudent();
		listDTO.forEach(System.out::println);
		map.put("studentList", listDTO);
		return "adminStudents";
	}
	
	@GetMapping("/admin/courses")
	public String showCourse(Map<String,Object> map)
	{
		List<CourseDTO> listDTO=courseService.allCourse();
		map.put("courseList", listDTO);
		return "adminCourses";
	}

}
