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
import com.nit.enums.STATE;
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
	@GetMapping("facultySoftDelete.htm")
	public String softDeleteFaculty(@RequestParam("id") Integer id)
	{
		System.out.println("FACULTY DELETE "+id);
		service.softRemoveFaculty(id);
		return "redirect:faculties.htm";
	}
	@GetMapping("facultyHardDelete.htm")
	public String hardDeleteFaculty(@RequestParam("id") Integer id)
	{
		System.out.println("FACULTY DELETE "+id);
		service.hardRemoveFaculty(id);
		return "redirect:faculties.htm";
	}
	
	
	@GetMapping("facultyEdit.htm")
	public String editGetFaculty(@ModelAttribute("faculty") FacultyDTO dto,@RequestParam("facultyId") Integer id)
	{
		FacultyDTO dto1=new FacultyDTO();
		dto1=service.showFaculty(id);
		dto.setId(dto1.getId());
		dto.setName(dto1.getName());
		dto.setAddress(dto1.getAddress());
		dto.setContact(dto1.getContact());
		dto.setEmail(dto1.getEmail());
		dto.setSubject(dto1.getSubject());
		dto.setState(dto1.getState());
		dto.setDoj(dto1.getDoj());
		dto.setDob(dto1.getDob());
	    System.out.println("GET EDIT FACULTY");
	    System.out.println(dto);
		return "editFaculty";
	}
	@PostMapping("facultyEdit.htm")
	public String editPostFaculty(@ModelAttribute("faculty") FacultyDTO dto)
	{
		System.out.println("POST EDIT FACULTY "+dto);
		   service.editFaculty(dto);
		return "redirect:faculties.htm";
	}
	
	  @GetMapping("facultyChangeState.htm")
	  public String changeFacultyState(@RequestParam("facultyId") Integer id,@RequestParam("state") String state_key)
	  {
		  STATE state;
		  if(state_key.equalsIgnoreCase("ACTIVE"))
		      state=STATE.ACTIVE;
		  else if(state_key.equalsIgnoreCase("NOTACTIVE"))
		      state=STATE.NOTACTIVE;
		  else
			  return "error";
		  service.changeFacultyState(id, state);
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
