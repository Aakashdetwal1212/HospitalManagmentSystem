package com.hms.application.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "patient")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id")
	@Id
	private int patientId;
	
	@NotBlank(message = "PatientName should not be blank")
	@Column(name = "name")
	@NotNull
	private String patientName;
	
	@NotNull
	private int age;
	
	@NotBlank(message = "Gender should not be blank")
	@Column(name = "gender")
	@NotNull
	private String gender;
	
	@NotBlank(message = "City should not be blank")
	@Column(name = "city")
	@NotNull
	private String city;
	
	@Pattern(regexp="(^$|[0-9]{10})", message = "MobileNumber Must should start with 91 or 0, length 10")
	@NotBlank(message = "mobileNumber should not be blank")
	@Column(name = "mobile")
	private int mobile;
	
	@NotBlank(message = "Disease should not be blank")
	@Column(name = "disease")
	@NotNull
	private String disease;
	
	@NotBlank(message = "Treatement should not be blank")
	@Column(name = "treatments")
	@NotNull
	private String treatments;
	
	@NotNull
	private int noOfDays;
}
