package com.hms.application.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctor")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class Doctor {
    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int doctorId;
	@NotBlank(message = "DoctorName should not be blank")
	@Column(name = "doctor-name")
	@NotNull
	private String doctorName;
	@NotBlank(message = "City should not be blank")
	@Column(name = "city")
	@NotNull
	private String city;
	@NotNull
	private int age;
	@NotBlank(message = "Specialization should not be blank")
	@Column(name = "specialization")
	@NotNull
	private String specialization;
	@NotBlank(message = "Sex should not be blank")
	@Column(name = "sex")
	@NotNull
	private String sex;
	@Pattern(regexp="(^$|[0-9]{10})", message = "MobileNumber Must should start with 91 or 0, length 10")
	@NotBlank(message = "mobileNumber should not be blank")
	private int mobile;
}
