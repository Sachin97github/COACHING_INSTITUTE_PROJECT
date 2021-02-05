package com.nit.aspect;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import com.nit.errors.NotAuthorizedException;

public class SecurityCheckAspect {
	
	@Autowired
	private HttpSession session;
	
	public void checkLogin(JoinPoint jp) throws NotAuthorizedException
	{
		if(session.getAttribute("user")==null)  		
			 throw new NotAuthorizedException("not Authorized");
	}
}
