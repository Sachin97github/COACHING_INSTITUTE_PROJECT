package com.nit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "STAFF_CO_IN")
public class Staff {
	@Id
	@GeneratedValue(generator = "EMP_ID_GENERATOR")
	@Column(name = "STAFF_ID")
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
	private Date doj;
}
