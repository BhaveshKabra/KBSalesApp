package org.bhavesh.kbsales.bean;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Authorities implements GrantedAuthority
{
	private static final long serialVersionUID = 3973819204191723249L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;
	@Getter
	private String authority;
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name="username",referencedColumnName="username")
	private User user;
	public User getUser() {
		return new User(user);
	}
	public void setUser(User user) {
		this.user = new User(user);
	}
	public Authorities(Long id, String authority, User user) {
		super();
		this.id = id;
		this.authority = authority;
		this.user = new User(user);
	}
	public Authorities(String authority) {
		this.authority = authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	@Override
	public int hashCode() {
		return Objects.hash(authority, id, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Authorities other = (Authorities) obj;
		return Objects.equals(authority, other.authority) && Objects.equals(id, other.id)
				&& Objects.equals(user, other.user);
	}
}