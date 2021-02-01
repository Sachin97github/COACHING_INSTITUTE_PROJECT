package com.nit.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.nit.enums.STATE;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@Entity
@Table(name="FACULTY_CO_IN")
public class Faculty {
	
	@Id
	@GeneratedValue(generator="EMP_ID_GENERATOR")
	@Column(name="FACULTY_ID")
    private  Integer id;
	private String name;
	private String subject;
	private String email;
	private String address;
	private Long contact;
	private STATE state=STATE.ACTIVE;
	
	/*
	 * @ElementCollection
	 * 
	 * @Column(name="CONTACT")
	 * 
	 * @CollectionTable(name="CONTACT_CO_IN",
	 * joinColumns=@JoinColumn(name="EMP_ID",referencedColumnName="FACULTY_ID"))
	 * 
	 * @MapKeyColumn(name="TYPE") private Map<String,Long> contact;
	 */ 
	private LocalDate dob;
	private LocalDate doj;
	
	@OneToMany(targetEntity=Course.class,fetch=FetchType.EAGER,orphanRemoval=true,cascade=CascadeType.ALL)
	@JoinColumn(name="FACULTY_ID",referencedColumnName="FACULTY_ID")
	private Set<Course> course;
	
}
