package com.nit.dto;

import java.io.Serializable;
import java.util.Date;

import com.nit.enums.STATE;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CourseDTO implements Serializable{
	@NotNull
	private Integer id;
	private String name;
	private Date startDate;
	private Double price;
	private FacultyDTO facultyDTO;
	private STATE state=STATE.ACTIVE;
}
