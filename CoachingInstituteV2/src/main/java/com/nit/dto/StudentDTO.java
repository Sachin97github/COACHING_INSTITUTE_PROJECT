package com.nit.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class StudentDTO implements Serializable {
	
	private Integer id;
	private String name;
	private String email;
	private Long contact;
	private String address;
	private Date dob;
	private Date doj=new Date();
	private Set<Integer> courseids=new HashSet();

}
