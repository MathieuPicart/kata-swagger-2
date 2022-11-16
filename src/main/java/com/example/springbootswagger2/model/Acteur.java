package com.example.springbootswagger2.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class Acteur {
    @ApiModelProperty(notes = "Nom de l'acteur", name="nom", required=true, value="test nom")
    private String nom;
    @ApiModelProperty(notes = "Prénom de l'acteur", name="prenom", required=true, value="test prenom")
    private String prenom;
    @ApiModelProperty(notes = "Date de naissance de l'acteur", name="dateNaissance", required=true, value="test dateNaissance")
    private Date dateNaissance;
    @ApiModelProperty(notes = "Filmographie de l'acteur", name="filmographie", required=true, value="test filmographie")
    private Film filmographie;

    public Acteur(String nom, String prenom, Date dateNaissance, Film filmographie) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.filmographie = filmographie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Film getFilmographie() {
        return filmographie;
    }

    public void setFilmographie(Film filmographie) {
        this.filmographie = filmographie;
    }

    @Override
    public String toString() {
        return "Acteur [nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", filmographie="
                + filmographie + "]";
    }
}
