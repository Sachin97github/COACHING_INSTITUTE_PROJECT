package com.nit.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@Autowired
	private HttpSession session;
	
	/*
	 * @RequestMapping(value="login",method=RequestMethod.GET) public String
	 * handleLogin(Map<String,Object> map,
	 * 
	 * @RequestParam(value="error",required=false) String error,
	 * 
	 * @RequestParam(value="logout",required=false)String logout ) { if(error==null)
	 * map.put("error", value) return "login-form"; }
	 */
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String showLogin()
	{
		return "login-form";
	}
	@RequestMapping(value="/login-error",method=RequestMethod.GET)
	public String showError(Map<String,Object> map)
	{
		map.put("errorMsg", "You are not Authorized");
		return "error";
	}
	
}
