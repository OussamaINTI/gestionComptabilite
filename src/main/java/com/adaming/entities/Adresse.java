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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Adresse implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Groupe groupe;

	@OneToMany(mappedBy = "adresse")
	private Set<Agence> agences = new HashSet<>();

	@OneToMany(mappedBy = "adresse")
	@JsonIgnore
	private Set<Societe> societes = new HashSet<>();

	@OneToMany(mappedBy = "adresse")
	@JsonIgnore
	private Set<Employee> employees = new HashSet<>();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ville", referencedColumnName = "id")
	private Ville ville;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Agence> getAgences() {
		return agences;
	}

	public void setAgences(Set<Agence> agences) {
		this.agences = agences;
	}

	public Set<Societe> getSocietes() {
		return societes;
	}

	public void setSocietes(Set<Societe> societes) {
		this.societes = societes;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public Adresse() {

	}

}
