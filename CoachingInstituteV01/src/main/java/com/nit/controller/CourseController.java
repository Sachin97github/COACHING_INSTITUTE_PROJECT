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

import com.nit.dto.CourseDTO;
import com.nit.dto.StudentDTO;
import com.nit.service.ICourseService;

@Controller
public class CourseController {
	
	@Autowired
	private ICourseService service;
		
	@GetMapping("/course/add.htm")
	  public String  addGetCourse(@ModelAttribute("course") CourseDTO dto)
	  {
		  System.out.println("INSIDE GET");
		  dto.setName("Java");
		  dto.setPrice(1000d);
		  dto.setStartDate(new Date());
		  return "addCourse";
	  }
	  @PostMapping("/course/add.htm")
	  public String addPostCourse(@ModelAttribute("course") CourseDTO dto)
	  {
		  System.out.println("INSIDE POST");
		  service.registerCourse(dto);
		  return "addCourse";
	  }	  
	  
	  @GetMapping("/course/delete.htm")
	  public String deleteCourse(@RequestParam("id") Integer id)
	  {
		  System.out.println("DELETE COURSE");
		  service.removeCourse(id);
		  return "";
		  }
	  @GetMapping("/course/edit.htm")
	  public String editGetCourse(@ModelAttribute("course") CourseDTO dto,@RequestParam("id") Integer id)
	  {
		   dto= service.showCourse(id);
		  return "editCourse";
	  }
	  @PostMapping("/course/edit.htm")
	  public String editPostCourse(@ModelAttribute("course") CourseDTO dto)
	  {
		   service.editCourse(dto);
		  return "editCourse";
	  }
	  @GetMapping("/course/showAll.htm")
		public String showAll(Map<String ,Object> map)
		{
			List<CourseDTO> listDTO=service.allCourse();
			map.put("courseList", listDTO);
			return "showAllCourse";
		}
	  
	  
		 @InitBinder
			public   void   myInitBinder(ServletRequestDataBinder binder) {
				System.out.println("StudentController.myInitBinder()");
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
			}
}
