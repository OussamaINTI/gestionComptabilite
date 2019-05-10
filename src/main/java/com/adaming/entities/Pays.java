package com.adaming.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pays implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String code;

	@OneToMany(mappedBy = "pays")
	private Set<Gouvernorat> etats = new HashSet<>();

	public Pays() {
		super();
	}

	public Pays(String code, Set<Gouvernorat> etats) {
		super();
		this.code = code;
		this.etats = etats;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Gouvernorat> getEtats() {
		return etats;
	}

	public void setEtats(Set<Gouvernorat> etats) {
		this.etats = etats;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Pays [id=" + id + ", code=" + code + ", etats=" + etats + "]";
	}



}
