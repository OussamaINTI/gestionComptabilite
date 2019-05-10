package com.adaming.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Ville implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String libelle;
	private String codePostal;

	@OneToMany(mappedBy = "ville")
	private Set<Adresse> adresses = new HashSet<>();

	@ManyToOne(fetch = FetchType.EAGER)
	private Gouvernorat gouvernorat;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(Set<Adresse> adresses) {
		this.adresses = adresses;
	}

	public Gouvernorat getGouvernorat() {
		return gouvernorat;
	}

	public void setGouvernorat(Gouvernorat gouvernorat) {
		this.gouvernorat = gouvernorat;
	}
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public Ville() {

	}

	public Ville(Long id, String libelle, String codePostal, Set<Adresse> adresses, Gouvernorat gouvernorat) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.codePostal = codePostal;
		this.adresses = adresses;
		this.gouvernorat = gouvernorat;
	}

	public Ville(String libelle, String codePostal, Set<Adresse> adresses, Gouvernorat gouvernorat) {
		super();
		this.libelle = libelle;
		this.codePostal = codePostal;
		this.adresses = adresses;
		this.gouvernorat = gouvernorat;
	}

	public Ville(String libelle, String codePostal, Gouvernorat gouvernorat) {
		super();
		this.libelle = libelle;
		this.codePostal = codePostal;
		this.gouvernorat = gouvernorat;
	}

	public Ville(String libelle, String codePostal) {
		super();
		this.libelle = libelle;
		this.codePostal = codePostal;
	}

	@Override
	public String toString() {
		return "Ville [id=" + id + ", libelle=" + libelle + ", codePostal=" + codePostal + ", gouvernorat="
				+ gouvernorat + "]";
	}

}
