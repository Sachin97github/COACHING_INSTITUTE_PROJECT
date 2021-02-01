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

import com.nit.dto.FacultyDTO;
import com.nit.dto.StudentDTO;
import com.nit.service.IFacultyService;

@Controller
public class FacultyController {

	@Autowired
	IFacultyService service;

	@GetMapping("facultyAdd.htm")
	public String addGetFaculty(@ModelAttribute("faculty") FacultyDTO faculty) {
		
		faculty.setEmail("Sachin@gmail.com");
		System.out.println("Inside Get");
		return "addFaculty";
	}

	@PostMapping("facultyAdd.htm")
	public String addPostFaculty(@ModelAttribute("faculty") FacultyDTO faculty) {
		System.out.println("INSIDE POST");
		System.out.println(faculty);
		service.registerFaculty(faculty);
		return "redirect:faculties.htm";
	}
	@GetMapping("facultyDelete.htm")
	public String deleteFaculty(@RequestParam("id") Integer id)
	{
		System.out.println("FACULTY DELETE "+id);
		service.removeFaculty(id);
		return "redirect:faculties.htm";
	}
	
	@GetMapping("facultyEdit.htm")
	public String editGetFaculty(@ModelAttribute("faculty") FacultyDTO faculty,@RequestParam("id") Integer id)
	{
	    faculty=service.showFaculty(id);
		return "editFaculty";
	}
	@PostMapping("facultyEdit.htm")
	public String editPostFaculty(@ModelAttribute("faculty") FacultyDTO faculty)
	{
	    service.editFaculty(faculty);
		return "redirect:faculties.htm";
	}
	
	@GetMapping("facultyShowAll.htm")
	public String showAll(Map<String ,Object> map)
	{
		List<FacultyDTO> listDTO=service.allFaculty();
		map.put("facultyList", listDTO);
		return "allFaculty";
	}
	@GetMapping("facultyShowActive.htm")
	public String showActiveFaculty(Map<String ,Object> map)
	{
		List<FacultyDTO> listDTO=service.showActiveFaculty();
		map.put("facultyList", listDTO);
		return "allFaculty";
	}
	
	@InitBinder
	public void myInitBinder(ServletRequestDataBinder binder) {
		System.out.println("FacultyController.myInitBinder()");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}
