package com.nit.dto;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CourseDTO {
	@Id
	@GeneratedValue(generator="C_GEN")
	@SequenceGenerator(name="C_GEN",sequenceName="COURSE_SEQUENCE",initialValue=100,allocationSize=1)
	private Integer id;
	private String name;
	private Date startDate;
	private Double price;
	
}
