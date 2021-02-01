package com.nit.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nit.dto.StudentDTO;
import com.nit.service.ICourseService;
import com.nit.service.IStudentService;

@Controller
public class StudentController {
	
	@Autowired
	private IStudentService service;

	@Autowired
	private HttpSession session;
	
	@Autowired
	private ICourseService courseService;
	
	@GetMapping("studentAdd.htm")
	public String addGetStudent(@ModelAttribute("student") StudentDTO std) {
		System.out.println("INSIDE STUDENT GET");
		std.setName("SACHIN");
		std.setContact(78564121l);
		std.setEmail("sachin1112199@gmail.com");
		return "addStudent";
	}

	@PostMapping("studentAdd.htm")
	public String addPostStudent(@ModelAttribute("student") StudentDTO dto,HttpServletRequest req) {
		System.out.println("INSIDE STUDENT POST");
		req.getSession().setAttribute("currentStudentId",
				service.registerStudent(dto));
		System.out.println("added to Session"+dto);
		return "redirect:addCourseToStudent.htm";
	}
	@GetMapping("addCourseToStudent.htm")
	public String showCourseToAdd(Map<String,Object> map)
	{
		 map.put("courseList", courseService.showActiveCourse());
		 return "addStudentCourse"; 
	}
	
	@GetMapping("studentAddCourse.htm")
	public String addCourseToStudent(Map<String,Object> map,@RequestParam("courseId") Integer courseId,HttpServletRequest req)
	{
		System.out.println("studentAddCourse.htm :: "+courseId);
		String resultPage;
		StudentDTO dto=(StudentDTO)req.getSession().getAttribute("currentStudentId");
		  dto.getCourseids().add(courseId);
		 service.editStudent(dto);
		 map.put("courseList", courseService.showActiveCourse());
		 return "addStudentCourse";
	}    
	
	@GetMapping("studentDelete.htm")
	public String deleteStudent(@RequestParam("staffId") Integer id)
	{
		System.out.println("DELETE REQUEST FOR + "+id);
		service.removeStudent(id);
		return "redirect:students.htm";
	}
	@GetMapping("studentEdit.htm")
	public String editGetStudent(@ModelAttribute("student") StudentDTO dto,@RequestParam("staffId") Integer id)
	{
		 StudentDTO dto1=service.showStudent(id);
		 dto.setId(dto1.getId());
		 dto.setName(dto1.getName());
		 dto.setAddress(dto1.getAddress());
		 dto.setContact(dto1.getContact());
		 dto.setEmail(dto1.getEmail());
		 dto.setDob(dto1.getDob());		 
		return "editStudent";
	}
	@PostMapping("studentEdit.htm")
	public String editPostStudent(@ModelAttribute("student") StudentDTO dto)
	{
		service.editStudent(dto);		
		return "redirect:students.htm";
	}

	@GetMapping("studentShowAll.htm")
	public String showAll(Map<String ,Object> map)
	{
		List<StudentDTO> listDTO=service.showAllStudent();
		listDTO.forEach(System.out::println);
		map.put("studentList", listDTO);
		return "allStudent";
	}                                            
	@InitBinder
	public void myInitBinder(ServletRequestDataBinder binder) {
		System.out.println("StudentController.myInitBinder()");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}
