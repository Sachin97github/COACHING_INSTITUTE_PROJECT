package com.nit.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="STD_CO_IN")
public class Student {
	@Id
	@GeneratedValue(generator="STD_ID_GENERATOR")
	@Column(name="STD_ID")
	private Integer id;
	private String name;
	private String email;
	
	/*
	 * @ElementCollection
	 * 
	 * @Column(name="CONTACT")
	 * 
	 * @CollectionTable(name="STUDENT_CONTACT_CO_IN",
	 * joinColumns=@JoinColumn(name="STUDENT_ID",referencedColumnName="STD_ID"))
	 * 
	 * @MapKeyColumn(name="TYPE")
	 */
	private String address;
	private Long contact;
	private Date doj=new Date();
	private Date dob;
	
	@ElementCollection
	@CollectionTable(name="STD_COURSE")
	@JoinColumn(name="STDID",referencedColumnName="STD_ID")
	@Column(name="COURSEID")
	private Set<Integer> courseids;

}
