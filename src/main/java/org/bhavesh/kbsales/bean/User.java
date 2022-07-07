package org.bhavesh.kbsales.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class User implements UserDetails ,Serializable
{
	public User(String username, String position, String password,
			LocalDateTime createdDate, LocalDateTime modifiedDate, Collection<Authorities> authorities,
			boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
		super();
		this.username = username;
		this.position = position;
		this.password = password;
		this.createdDate = createdDate.plusSeconds(0);
		this.modifiedDate = modifiedDate.plusHours(0);
		this.authorities=new ArrayList<>(10);
		this.authorities.addAll(authorities);
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}
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
	@Column(name="accountNonExpired",columnDefinition="TinyInt(1) default 1")
	boolean accountNonExpired;
	@Column(name="accountNonLocked",columnDefinition="TinyInt(1) default 1")
	boolean accountNonLocked;
	@Column(name="credentialsNonExpired",columnDefinition="TinyInt(1) default 1")
	boolean credentialsNonExpired;
	@Column(name="enabled",columnDefinition="TinyInt(1) default 1")
	boolean enabled;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate.plusSeconds(0);
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDateTime getModifiedDate() {
		return modifiedDate.plusSeconds(0);
	}
	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public Collection<Authorities> getAuthorities() { 
		ArrayList <Authorities> authortity=new ArrayList<>(10);
		authortity.addAll(authorities);
		return authortity;
	}
	public void setAuthorities(Collection<Authorities> authorities) {
		this.authorities=new ArrayList<>(10); 
		this.authorities.addAll(authorities);
	}
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public User(User user) {
		this.username=user.getUsername();
		this.password=user.getPassword();
		this.position=user.getPosition();
		this.accountNonExpired=user.isAccountNonExpired();
		this.accountNonLocked=user.isAccountNonLocked();
		this.authorities=new ArrayList<>(10);
		this.authorities.addAll(authorities);
		this.createdDate=user.getCreatedDate();
		this.credentialsNonExpired=user.isCredentialsNonExpired();
		this.enabled=user.isEnabled();
		this.modifiedDate=user.getModifiedDate();
	}
	@Override
	public int hashCode() {
		return Objects.hash(accountNonExpired, accountNonLocked, authorities, createdDate, credentialsNonExpired,
				enabled, modifiedDate, password, position, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return accountNonExpired == other.accountNonExpired && accountNonLocked == other.accountNonLocked
				&& Objects.equals(authorities, other.authorities) && Objects.equals(createdDate, other.createdDate)
				&& credentialsNonExpired == other.credentialsNonExpired && enabled == other.enabled
				&& Objects.equals(modifiedDate, other.modifiedDate) && Objects.equals(password, other.password)
				&& Objects.equals(position, other.position) && Objects.equals(username, other.username);
	}
}