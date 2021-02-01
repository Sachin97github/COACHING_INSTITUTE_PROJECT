package com.nit.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.nit.enums.STATE;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name="COURSE_CO_IN_TWO")
@ToString
public class Course {
	@Id
	/*
	 * @GeneratedValue(generator="C_GEN")
	 * 
	 * @SequenceGenerator(name="C_GEN",sequenceName="COURSE_SEQUENCE",initialValue=
	 * 1001,allocationSize=1)
	 */
	@GeneratedValue(generator="COURSE_ID_GEN_TWO")
	@Column(name="COURSE_ID")
	@NotNull
	private Integer id;
	private String name;
	private Date startDate;
	private Double price;
	private STATE state=STATE.ACTIVE;
	
	/*
	 * @ElementCollection
	 * 
	 * @CollectionTable(name="FACULTY_COUSRE")
	 * 
	 * @JoinColumn(name="COURSEID",referencedColumnName="COURSE_ID")
	 * 
	 * @Column(name="FACULTY_ID") private Set<Integer> facultyId;
	 */
	@ManyToOne(targetEntity=Faculty.class,fetch=FetchType.EAGER,cascade=CascadeType.DETACH)
	@JoinColumn(name="FACULTYID",referencedColumnName="FACULTY_ID")
	private Faculty faculty;
	
}
