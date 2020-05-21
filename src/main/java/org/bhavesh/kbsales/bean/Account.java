package org.bhavesh.kbsales.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
	private String name;
	private String city;
	@Column(length = 15)
	private Integer gstno;
	@Column(length = 14)
	private Integer fssai;
}
