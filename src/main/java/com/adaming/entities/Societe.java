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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Societe implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String code;
	private String libelle;

	@OneToMany(mappedBy = "societe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Agence> agences = new HashSet<>();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "groupe", referencedColumnName = "id")
	private Groupe groupe;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "adresse", referencedColumnName = "id")
	private Adresse adresse;
	

	public Societe(Long id, String code, String libelle, Set<Agence> agences, Groupe groupe, Adresse adresse) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.agences = agences;
		this.groupe = groupe;
		this.adresse = adresse;
	}

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

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
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

	public Societe() {

	}

}
