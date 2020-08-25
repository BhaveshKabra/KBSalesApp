package org.bhavesh.kbsales.bean.pojo;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountPOJO {
	@NotBlank
	@NotNull
	@Size(min = 2,max=255)
	private String name;
	@NotNull
	@NotBlank
	@Size(min = 2,max=255)
	private String city;
	@Column(length = 15)
	private Integer gstno;
	@Column(length = 14)
	private Integer fssai;
}
