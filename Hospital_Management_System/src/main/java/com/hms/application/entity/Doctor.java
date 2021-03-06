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
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString(callSuper = true)
@NoArgsConstructor
@DiscriminatorValue("doctor")
public class Doctor extends HospitalStaff {
    
	@NotBlank(message = "Specialization should not be blank")
	@NotNull
	@Column(name = "specialization")
	private String specialization;

	@NotNull
	@Column(name = "experience")
	private int experience;
}
