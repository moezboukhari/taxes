package org.sid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("TVA")
public class TVA extends Taxe{
public TVA() {
	// TODO Auto-generated constructor stub
}

public TVA(Long id, String titre, Date dateTaxe, double montant, Entreprise entreprise) {
	super(id, titre, dateTaxe, montant, entreprise);
	// TODO Auto-generated constructor stub
}

}
