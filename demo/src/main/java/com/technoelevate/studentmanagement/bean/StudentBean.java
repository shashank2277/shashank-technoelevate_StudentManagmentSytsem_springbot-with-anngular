package com.technoelevate.studentmanagement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@Entity
@JsonRootName("student_db")
@JsonPropertyOrder({"Userid" ,"name"} )
@XmlRootElement(name = "student_db")
@Table(name = "StudentInfo")
public class StudentBean implements Serializable {
	@Id
	@JsonProperty("student_id")
	@Column(name = "Userid")
	private int userid;

	@Column
	private String email;

	@Column
	private double marks;

	@Column(name = "Username")
	private String name;

	@Column
	private String grade;
	
}
