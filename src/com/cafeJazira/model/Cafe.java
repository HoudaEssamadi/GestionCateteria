package com.cafeJazira.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cafe")
public class Cafe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Produit")
	private String Produit;
	
	@Column(name="Nom")
	private String Nom;
	
	@Column(name="Categorie")
	private String Categorie;
	
	@Column(name="Quantite")
	private String Quantite;
	
	@Column(name="Prix")
	private String Prix;

	public Cafe() {
		super();
	}

	public Cafe(String produit, String nom, String categorie, String quantite, String prix) {
		super();
		Produit = produit;
		Nom = nom;
		Categorie = categorie;
		Quantite = quantite;
		Prix = prix;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduit() {
		return Produit;
	}

	public void setProduit(String produit) {
		Produit = produit;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getCategorie() {
		return Categorie;
	}

	public void setCategorie(String categorie) {
		Categorie = categorie;
	}

	public String getQuantite() {
		return Quantite;
	}

	public void setQuantite(String quantite) {
		Quantite = quantite;
	}

	public String getPrix() {
		return Prix;
	}

	public void setPrix(String prix) {
		Prix = prix;
	}
	
	

}
