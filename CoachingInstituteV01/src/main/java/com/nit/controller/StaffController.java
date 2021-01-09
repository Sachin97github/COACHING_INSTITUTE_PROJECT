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
import com.nit.service.IStaffService;

@Controller
public class StaffController {
	
	@Autowired
	private IStaffService service;
	
	@GetMapping("/staff/add.htm")
	public String addGetStaff(@ModelAttribute("staff") StaffDTO dto)
	{
		System.out.println("ADD GET STAFF");
		dto.setName("RAM");
		dto.setEmail("sachin7697@yahoo.com");
		dto.setContact(7697019105l);
		dto.setAddress("Bhopal");
		dto.setDob(new Date());
		dto.setDoj(new Date());
		return "addStaff";
	}
	@PostMapping("/staff/add.htm")
	public String addPostStaff(@ModelAttribute("staff") StaffDTO dto)
	{
		System.out.println("ADD POST STAFF");
		service.registerStaff(dto);
		return "succes";
	}
	
	@GetMapping("/staff/delete.htm")
	public String deleteStaff(@RequestParam("id") Integer id)
	{
		System.out.println("DELETE STAFF");
		service.removeStaff(id);
		return "succes";
	}
	@GetMapping("/staff/add.htm")
	public String editGetStaff(@ModelAttribute("staff") StaffDTO dto,@RequestParam("id") Integer id)
	{
		System.out.println("EDIT GET STAFF");
		 dto=service.showStaff(id);
		return "editStaff";
	}
	@GetMapping("/staff/add.htm")
	public String editPostStaff(@ModelAttribute("staff") StaffDTO dto,@RequestParam("id") Integer id)
	{
		System.out.println("EDIT POST STAFF");
		service.editStaff(dto);
		return "succes";
	}
	@GetMapping("/staff/showAll.htm")
	public String showAll(Map<String ,Object> map)
	{
		List<StaffDTO> listDTO=service.allStaff();
		map.put("staffList", listDTO);
		return "showAllStaff";
	}
	
		 @InitBinder
			public   void   myInitBinder(ServletRequestDataBinder binder) {
				System.out.println("StudentController.myInitBinder()");
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
			}
}
