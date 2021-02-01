package com.nit.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class StaffDTO implements Serializable{
	
	private Integer id;
	private String name;
	private String email;
	private String address;
	/*
	 * @ElementCollection
	 * 
	 * @Column(name="CONTACT")
	 * 
	 * @CollectionTable(name="CONTACT_CO_IN",
	 * joinColumns=@JoinColumn(name="EMP_ID",referencedColumnName="STAFF_ID"))
	 * 
	 * @MapKeyColumn(name="TYPE")
	 */
	private Long contact;

	private Date dob;
	private Date doj=new Date();

}
