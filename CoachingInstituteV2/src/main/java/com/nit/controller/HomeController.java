package com.nit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nit.service.ICourseService;

@Controller
public class HomeController {

	//@RequestMapping(value="/home",method=RequestMethod.GET)
	
	@Autowired
	private ICourseService courseService;

	@GetMapping("home")
	public String showHome(Map<String,Object> map)
	{	
		map.put("courseList", courseService.showActiveCourse());
		System.out.println("home");
		return "home";
	}
}
