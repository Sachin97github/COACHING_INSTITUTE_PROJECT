package com.nit.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.nit.enums.STATE;
import com.nit.model.Course;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
public class FacultyDTO implements Serializable {
	private  Integer id;
	private String name;
	private String subject;
	private String email;
	private String address;
	private Long contact;
	private STATE state=STATE.ACTIVE;
	private Set<Course> course=new HashSet();
	private Date dob;
	private Date doj=new Date();
	
}
