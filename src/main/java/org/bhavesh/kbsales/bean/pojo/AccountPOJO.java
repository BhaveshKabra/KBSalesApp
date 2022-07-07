package org.bhavesh.kbsales.bean.pojo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountPOJO {
	private long id;
	@NotBlank
	@NotNull
	@Length(min = 2,max=255)
	private String name;
	@NotNull
	@NotBlank
	@Length(min = 2,max=255)
	private String city;
	@PositiveOrZero
	private Integer gstno;
	@PositiveOrZero
	private Integer fssai;
	@Email
	private String email;
	public AccountPOJO(AccountPOJO accountPOJO)
	{
		this.city=accountPOJO.getCity();
		this.name=accountPOJO.getName();
		this.fssai=accountPOJO.getFssai();
		this.gstno=accountPOJO.getGstno();
		this.id=accountPOJO.getId();
		this.name=accountPOJO.getName();
	}
}
