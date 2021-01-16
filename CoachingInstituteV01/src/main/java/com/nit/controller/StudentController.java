package com.nit.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nit.dto.StaffDTO;
import com.nit.dto.StudentDTO;
import com.nit.service.IStudentService;

@Controller
public class StudentController {
	
	@Autowired
	private IStudentService service;

	@GetMapping("studentAdd.htm")
	public String addGetStudent(@ModelAttribute("student") StudentDTO std) {
		System.out.println("INSIDE GET");
		std.setName("SACHIN");
		std.setContact(78564121l);
		std.setEmail("sachin1112199@gmail.com");
		return "addStudent";
	}

	@PostMapping("studentAdd.htm")
	public String addPostStudent(@ModelAttribute("student") StudentDTO dto) {
		System.out.println("INSIDE POST");
		service.registerStudent(dto);
		return "succes";
	}
	@GetMapping("studentDelete.htm")
	public String deleteStudent(@RequestParam("id") Integer id)
	{
		service.removeStudent(id);
		return "succes";
	}

	@GetMapping("studentEdit.htm")
	public String editGetStudent(@ModelAttribute("student") StudentDTO dto,@RequestParam("id") Integer id)
	{
		 dto=service.showStudent(id);
		return "editStudent";
	}
	
	@PostMapping("studentEdit.htm")
	public String editPostStudent(@ModelAttribute("student") StudentDTO dto)
	{
		service.editStudent(dto);
		return "editStudent";
	}

	@GetMapping("studentShowAll.htm")
	public String showAll(Map<String ,Object> map)
	{
		List<StudentDTO> listDTO=service.showAllStudent();
		map.put("studentList", listDTO);
		return "showAllStudent";
	}

	@InitBinder
	public void myInitBinder(ServletRequestDataBinder binder) {
		System.out.println("StudentController.myInitBinder()");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}
