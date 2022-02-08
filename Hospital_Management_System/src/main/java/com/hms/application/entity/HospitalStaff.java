package com.hms.application.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Table(name = "hospital_staff")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "department")
@DiscriminatorValue("hospital_staff")
public class HospitalStaff {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staff_id")
	@Id
	private int Id;
	
	@NotBlank(message = "Name should not be blank")
	@Column(name = "name")
	@NotNull
	private String name;
	
	@NotBlank(message = "City should not be blank")
	@Column(name = "city")
	@NotNull
	private String city;

	@NotNull
	private int age;

	@NotBlank(message = "Gender should not be blank")
	@Column(name = "gender")
	@NotNull
	private String gender;
	
	@Pattern(regexp="(^$|[0-9]{10})", message = "MobileNumber Must should start with 91 or 0, length 10")
	@NotBlank(message = "mobileNumber should not be blank")
	@Column(name = "mobile")
	private String mobile;
}
