package com.nit.dto;

import java.util.Date;

import com.nit.model.Faculty;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CourseDTO {
	@NotNull
	private Integer id;
	private String name;
	private Date startDate;
	private Double price;
	private FacultyDTO facultyDTO;
}
