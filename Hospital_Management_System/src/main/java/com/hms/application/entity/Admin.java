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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString(callSuper = true)
@DiscriminatorValue("admin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends  HospitalStaff {

	@NotBlank(message = "UserName should not be blank")
	@Column(name = "username")
	@NotNull
	private String userName;

	@NotBlank(message = "Password should not be blank")
	@Column(name = "password")
	@NotNull
	private String password;
	
}
