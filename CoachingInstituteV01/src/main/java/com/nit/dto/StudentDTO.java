package com.nit.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class StudentDTO {
	
	private Integer id;
	private String name;
	private String email;
	private Long contact;
	private String address;
	private Date dob;
	private Date doj;

}
