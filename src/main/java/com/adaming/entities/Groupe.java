package com.adaming.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Groupe implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String code;
	private String libelle;

	@OneToMany(mappedBy = "groupe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Societe> societes = new HashSet<>();

	@OneToOne(fetch = FetchType.EAGER)
	private Adresse adresse;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Set<Societe> getSocietes() {
		return societes;
	}

	public void setSocietes(Set<Societe> societes) {
		this.societes = societes;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Groupe() {

	}

	public Groupe(Long id, String code, String libelle, Set<Societe> societes, Adresse adresse) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.societes = societes;
		this.adresse = adresse;
	}

	public Groupe(String code, String libelle, Set<Societe> societes, Adresse adresse) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.societes = societes;
		this.adresse = adresse;
	}

	public Groupe(String code, String libelle, Set<Societe> societes) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.societes = societes;
	}

}
