package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nit.dto.CourseDTO;
import com.nit.service.ICourseService;

@Controller
public class HomeController {

	//@RequestMapping(value="/home",method=RequestMethod.GET)
	
	@Autowired
	private ICourseService courseService;

	@GetMapping("home.htm")
	public String showHome()
	{	
		System.out.println("home");
		return "home";
	}
	@ModelAttribute("courseList")
	public List<CourseDTO> getCourse()
	{
		return courseService.allCourse();	
	}
}
