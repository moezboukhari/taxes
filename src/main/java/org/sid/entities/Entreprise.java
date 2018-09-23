package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Entreprise implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long code;
	@NotNull
	@Size(min=2,max=20)
	private String nom;
	@NotNull
	@Email
	private String email;
	@Size(min=4,max=60)
	private String raisonSociale;
	@OneToMany(mappedBy="entreprise",fetch=FetchType.LAZY)//mode lazy c'et charger les details avec le maitre
	private Collection<Taxe> taxes;
	public Entreprise() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Entreprise(Long code, String nom, String email, String raisonSociale, Collection<Taxe> taxes) {
		super();
		this.code = code;
		this.nom = nom;
		this.email = email;
		this.raisonSociale = raisonSociale;
		this.taxes = taxes;
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRaisonSociale() {
		return raisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}
	public Collection<Taxe> getTaxes() {
		return taxes;
	}
	public void setTaxes(Collection<Taxe> taxes) {
		this.taxes = taxes;
	}

}
