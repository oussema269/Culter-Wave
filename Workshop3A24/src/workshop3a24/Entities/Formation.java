/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.Entities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author dell
 */

public class Formation {

    int id, ownerid;
    String description, titre, pays, type,Email,nom;
    boolean confirmation;
    Date debut, fin;

    public Formation(int ownerid, String description, String titre, String pays, String type, String Email, String nom, boolean confirmation, Date debut, Date fin) {
        this.ownerid = ownerid;
        this.description = description;
        this.titre = titre;
        this.pays = pays;
        this.type = type;
        this.Email = Email;
        this.nom = nom;
        this.confirmation = confirmation;
        this.debut = debut;
        this.fin = fin;
    }
    

  

   


    

    public Formation() {
    }

    public Formation(int ownerid, String description, String titre, String pays, Date debut, Date fin, String type, boolean confirmation) {

        this.ownerid = ownerid;
        this.description = description;
        this.titre = titre;
        this.pays = pays;
        this.debut = debut;
        this.fin = fin;
        this.type = type;
        this.confirmation = confirmation;
    }

    public Formation(int id, int ownerid, String description, String titre, String pays, String type, boolean confirmation, Date debut, Date fin) {
        this.id = id;
        this.ownerid = ownerid;
        this.description = description;
        this.titre = titre;
        this.pays = pays;
        this.type = type;
        this.confirmation = confirmation;
        this.debut = debut;
        this.fin = fin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }

    public int getId() {
        return id;
    }

    public int getOwnerid() {
        return ownerid;
    }

    public String getDescription() {
        return description;
    }

    public String getTitre() {
        return titre;
    }

    public String getPays() {
        return pays;
    }

    public Date getDebut() {
        return debut;
    }

    public Date getFin() {
        return fin;
    }

    public String getType() {
        return type;
    }

    public boolean isConfirmation() {
        return confirmation;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Formation{" + "id=" + id + ", ownerid=" + ownerid + ", description=" + description + ", titre=" + titre + ", pays=" + pays + ", type=" + type + ", Email=" + Email + ", nom=" + nom + ", confirmation=" + confirmation + ", debut=" + debut + ", fin=" + fin + '}';
    }

   
   
}
