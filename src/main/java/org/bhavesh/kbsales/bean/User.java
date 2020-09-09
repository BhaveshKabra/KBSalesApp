package org.bhavesh.kbsales.bean;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
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
public class User //implements UserDetails
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5097532230081943722L;
	@Id
	private String username;
	private String position;
	@NotNull
	@Length(min = 5,max=15)
	private String password;
	@CreationTimestamp
	private LocalDateTime createdDate;
	@LastModifiedDate
	private LocalDateTime modifiedDate;
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="user")
	private Collection<Authorities> authorities;
	/*
	@Column(name="accountNonExpired",columnDefinition="TinyInt(1) default 1")
	boolean accountNonExpired;
	@Column(name="accountNonLocked",columnDefinition="TinyInt(1) default 1")
	boolean accountNonLocked;
	@Column(name="credentialsNonExpired",columnDefinition="TinyInt(1) default 1")
	boolean credentialsNonExpired;
	@Column(name="enabled",columnDefinition="TinyInt(1) default 1")
	boolean enabled;
	*/
}
