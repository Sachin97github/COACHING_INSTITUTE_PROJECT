package com.nit.model;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
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
	private LocalDate dob;
	private LocalDate doj;
}
