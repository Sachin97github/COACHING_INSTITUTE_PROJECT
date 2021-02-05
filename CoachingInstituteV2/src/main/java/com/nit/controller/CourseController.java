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
import com.nit.dto.FacultyDTO;
import com.nit.enums.STATE;
import com.nit.service.ICourseService;
import com.nit.service.IFacultyService;

@Controller
public class CourseController {
	
	@Autowired
	private ICourseService service;
	@Autowired
	private IFacultyService facultyService;
		
	@GetMapping("/admin/course/add")
	  public String  addGetCourse(Map<String,Object> map,@ModelAttribute("course") CourseDTO dto)
	  {
		 System.out.println("COURSE ADD GET");
		map.put("facultyList", facultyService.showActiveFaculty());
		 return "addCourse";
	  }
	  @PostMapping("/admin/course/add")
	  public String addPostCourse(@ModelAttribute("course") CourseDTO dto)
	  {
		  System.out.println(dto);
		  System.out.println("COURSE ADD  POST");
		  service.registerCourse(dto);
		  return "redirect:/admin/course";
	  }	  
	  
	  @GetMapping("/admin/course/delete")
	  public String deleteCourse(@RequestParam("courseId") Integer id)
	  {
		  System.out.println("DELETE COURSE "+id);
		  service.removeCourse(id);
		  return "redirect:/admin/course";
		  }
	  @GetMapping("/admin/course/edit")
	  public String editGetCourse(Map<String,Object> map,@ModelAttribute("course") CourseDTO dto,@RequestParam("courseId")Integer id)
	  {
		  CourseDTO dto1=service.showCourse(id);
		  
		  dto.setId(dto1.getId());
		  dto.setName(dto1.getName());
          dto.setStartDate(dto1.getStartDate());
          dto.setPrice(dto1.getPrice());
          
          FacultyDTO fdto=dto1.getFacultyDTO();
          dto.setFacultyDTO(fdto);         
		  System.out.println("EDIT COURSE POST "+dto);
		  map.put("facultyList", facultyService.showActiveFaculty());
		  return "editCourse";
	  }
	  @PostMapping("/admin/course/edit")
	  public String editPostCourse(@ModelAttribute("course") CourseDTO dto)
	  {
		 FacultyDTO dto1=facultyService.showFaculty(dto.getFacultyDTO().getId());
		   dto.setFacultyDTO(dto1);
		   System.out.println("EDIT COURSE POST "+dto);
		   
		  service.editCourse(dto);
		  return "redirect:/admin/course";
	  }
	  @GetMapping("/admin/course/showAll")
		public String showAll(Map<String ,Object> map)
		{
		  System.out.println("/admin/courseShowAll.htm");
			List<CourseDTO> listDTO=service.allCourse();
			System.out.println(listDTO);
			listDTO.forEach(dto->{
				System.out.println(dto);
			});
			map.put("courseList", listDTO);
			return "allCourse";
		}
	  
	  @GetMapping("showActiveCourses")
		public String showActiveCourse(Map<String ,Object> map)
		{
		  System.out.println("courseShowAll.htm");
			List<CourseDTO> listDTO=service.showActiveCourse();
			map.put("courseList", listDTO);
			return "allCourse";
		}
	  
	  @GetMapping("/admin/course/changeState")
	  public String changeCourseState(@RequestParam("courseId") Integer id,@RequestParam("state") String state_key)
	  {
		  STATE state;
		  if(state_key.equalsIgnoreCase("ACTIVE"))
		      state=STATE.ACTIVE;
		  else if(state_key.equalsIgnoreCase("UPCOMING"))
		      state=STATE.UPCOMING;
		  else if(state_key.equalsIgnoreCase("FINISHED"))
		      state=STATE.FINISHED;
		  else
			  return "error";
		  service.changeCourseState(id,state);
		  return "redirect:/admin/course";
	  }
	  
		 @InitBinder
			public   void   myInitBinder(ServletRequestDataBinder binder) {
				System.out.println("StudentController.myInitBinder()");
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
			}
}
