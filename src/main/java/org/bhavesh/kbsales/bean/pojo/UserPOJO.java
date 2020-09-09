package org.bhavesh.kbsales.bean.pojo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPOJO {
	@NotNull
	@NotEmpty
	@Length(min = 3,max=30)
	private String username;
	private String position;
	@NotNull
	@Length(min = 5,max=15)
	private String password;
}
