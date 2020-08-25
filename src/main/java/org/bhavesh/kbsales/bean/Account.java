package org.bhavesh.kbsales.bean;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Account {
	@Id
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
	@CreatedDate
	LocalDateTime createdDate;
	@LastModifiedDate
	LocalDateTime modifiedDate;
	@Email
	private String emails;
	@LastModifiedBy
	@ManyToOne(targetEntity = User.class,fetch = FetchType.EAGER)
	private User modifyingUser;
}
