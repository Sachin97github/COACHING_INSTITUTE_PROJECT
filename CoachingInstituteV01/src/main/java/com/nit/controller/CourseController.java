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
		
	@GetMapping("courseAdd.htm")
	  public String  addGetCourse(@ModelAttribute("course") CourseDTO dto)
	  {
		  System.out.println("INSIDE GET");
		  dto.setName("Java");
		  dto.setPrice(1000d);
		  dto.setStartDate(new Date());
		  return "addCourse";
	  }
	  @PostMapping("courseAdd.htm")
	  public String addPostCourse(@ModelAttribute("course") CourseDTO dto)
	  {
		  System.out.println(dto);
		  System.out.println("INSIDE POST");
		  service.registerCourse(dto);
		  return "succes";
	  }	  
	  
	  @GetMapping("courseDelete.htm")
	  public String deleteCourse(@RequestParam("id") Integer id)
	  {
		  System.out.println("DELETE COURSE");
		  service.removeCourse(id);
		  return "";
		  }
	  @GetMapping("courseEdit.htm")
	  public String editGetCourse(@ModelAttribute("course") CourseDTO dto,@RequestParam("id") Integer id)
	  {
		   dto= service.showCourse(id);
		  return "editCourse";
	  }
	  @PostMapping("courseEdit.htm")
	  public String editPostCourse(@ModelAttribute("course") CourseDTO dto)
	  {
		   service.editCourse(dto);
		  return "editCourse";
	  }
	  @GetMapping("courseShowAll.htm")
		public String showAll(Map<String ,Object> map)
		{
		  System.out.println("courseShowAll.htm");
			List<CourseDTO> listDTO=service.allCourse();
			System.out.println(listDTO);
			listDTO.forEach(dto->{
				System.out.println(dto);
			});
			map.put("courseList", listDTO);
			return "allCourse";
		}
	  
	  
		 @InitBinder
			public   void   myInitBinder(ServletRequestDataBinder binder) {
				System.out.println("StudentController.myInitBinder()");
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
			}
}
