package org.bhavesh.kbsales.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Account extends Auditable<String>{
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getGstno() {
		return gstno;
	}
	public void setGstno(Integer gstno) {
		this.gstno = gstno;
	}
	public Integer getFssai() {
		return fssai;
	}
	public void setFssai(Integer fssai) {
		this.fssai = fssai;
	}
	public String getEmails() {
		return emails;
	}
	public void setEmails(String emails) {
		this.emails = emails;
	}
	public Account(Long id, String name,String city, Integer gstno, Integer fssai,String emails) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.gstno = gstno;
		this.fssai = fssai;
		this.emails = emails;
	}
	public Account(Account account) {
		this.id = account.id;
		this.name = account.name;
		this.city = account.city;
		this.gstno = account.gstno;
		this.fssai = account.fssai;
		this.emails = account.emails;
	}
}
