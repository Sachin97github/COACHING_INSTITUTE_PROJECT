package com.nit.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
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
	
	@GetMapping("staffAdd.htm")
	public String addGetStaff(@ModelAttribute("staff") StaffDTO dto)
	{
		System.out.println("ADD GET STAFF");
		return "addStaff";
	}
	@PostMapping("staffAdd.htm")
	public String addPostStaff(@ModelAttribute("staff") StaffDTO dto)
	{
		System.out.println("ADD POST STAFF");
		service.registerStaff(dto);
		return "redirect:staffMembers.htm";
	}
	
	@GetMapping("staffDelete.htm")
	public String deleteStaff(@RequestParam("id") Integer id)
	{
		System.out.println("DELETE STAFF "+id);
		service.removeStaff(id);
		return "redirect:staffMembers.htm";
	}
	@GetMapping("staffEdit.htm")
	public String editGetStaff(@ModelAttribute("staff") StaffDTO dto,@RequestParam("staffId") Integer id)
	{
		System.out.println("EDIT GET STAFF");
		 StaffDTO dto1=service.showStaff(id);
		 dto.setId(dto1.getId());
		 dto.setName(dto1.getName());
		 dto.setAddress(dto1.getAddress());
		 dto.setContact(dto1.getContact());
         dto.setDob(dto1.getDob());
         dto.setEmail(dto1.getEmail());
		return "editStaff";
	}
	@PostMapping("staffEdit.htm")
	public String editPostStaff(@ModelAttribute("staff") StaffDTO dto)
	{
		System.out.println("EDIT POST STAFF");
		service.editStaff(dto);
		return "redirect:staffMembers.htm";
	}
	@GetMapping("staffShowAll.htm")
	public String showAll(Map<String ,Object> map)
	{
		List<StaffDTO> listDTO=service.allStaff();
		map.put("staffList", listDTO);
		return "allStaff";
	}
	
		 @InitBinder
			public   void   myInitBinder(ServletRequestDataBinder binder) {
				System.out.println("StudentController.myInitBinder()");
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
			}
}
