package com.example.springbootswagger2.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class Film {
    @ApiModelProperty(notes = "Titre du film", name="titre", required=true, value="test titre")
    private String titre;
    @ApiModelProperty(notes = "Réalisateur du film", name="realisateur", required=true, value="test realisateur")
    private String realisateur;
    @ApiModelProperty(notes = "Acteur principal du film", name="acteurPrincipal", required=true, value="test acteurPrincipal")
    private Acteur acteurPrincipal;
    @ApiModelProperty(notes = "Date de sortie du film", name="dateSortie", required=true, value="test dateSortie")
    private Date dateSortie;

    public Film(String titre, String realisateur, Acteur acteurPrincipal, Date dateSortie) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.acteurPrincipal = acteurPrincipal;
        this.dateSortie = dateSortie;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public Acteur getActeurPrincipal() {
        return acteurPrincipal;
    }

    public void setActeurPrincipal(Acteur acteurPrincipal) {
        this.acteurPrincipal = acteurPrincipal;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    @Override
    public String toString() {
        return "Film [titre=" + titre + ", realisateur=" + realisateur + ", acteurPrincipal=" + acteurPrincipal
                + ", dateSortie=" + dateSortie + "]";
    }
}
