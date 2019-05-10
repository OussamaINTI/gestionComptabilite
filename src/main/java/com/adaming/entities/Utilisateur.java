package com.adaming.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String login;
	private String password;

	@OneToOne
	private Employee employee;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "profil", joinColumns = {
			@JoinColumn(name = "id_utilisateur", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "id_role", table = "role", referencedColumnName = "id") })
	private Set<Role> roles = new HashSet<>();
	

	public Utilisateur() {
		super();
	}

	public Utilisateur(String login, String password, Employee employee, Set<Role> roles) {
		super();
		this.login = login;
		this.password = password;
		this.employee = employee;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", login=" + login + ", password=" + password + ", employee=" + employee
				+ ", roles=" + roles + "]";
	}

}
