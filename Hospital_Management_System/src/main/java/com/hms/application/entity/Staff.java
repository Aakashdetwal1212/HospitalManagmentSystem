package com.hms.application.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString(callSuper = true)
@NoArgsConstructor
@DiscriminatorValue("staff")
public class Staff extends HospitalStaff {

	@NotBlank(message = "SubDepartment should not be blank")
	@NotNull
	@Column(name = "sub_department")
	private String subDepartment;
	
	@NotNull
	@Column(name = "experience")
	private int experience;
}
