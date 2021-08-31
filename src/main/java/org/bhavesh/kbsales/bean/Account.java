package org.bhavesh.kbsales.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EqualsAndHashCode
public class Account extends Auditable<String>{
	@Id
	@NotBlank
	@NotNull
	@Length(min = 2,max=255)
	private String name;
	@NotNull
	@NotBlank
	@Length(min = 2,max=255)
	private String city;
	@Column(length = 15)
	private Integer gstno;
	@Column(length = 14)
	private Integer fssai;
	@CreatedDate
	Date createdDate;
	@LastModifiedDate
	Date modifiedDate;
	@Email
	private String emails;
	/*
	@LastModifiedBy
	@ManyToOne(targetEntity = User.class,fetch = FetchType.EAGER)
	private User lastModifiedBy;
	
	@LastModifiedBy
	@ManyToOne(targetEntity = User.class,fetch = FetchType.EAGER)
	private User createdBy;
	*/
}
