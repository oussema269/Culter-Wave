/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.Entities;

/**
 *
 * @author dell
 */
public class Participationformation {
    
    int idParticipationFormation,idFormation,idUser;
    Boolean confirmation;
    String titre,email,nom;

    public Participationformation(int idFormation, int idUser, Boolean confirmation, String titre, String email, String nom) {
        this.idFormation = idFormation;
        this.idUser = idUser;
        this.confirmation = confirmation;
        this.titre = titre;
        this.email = email;
        this.nom = nom;
    }
    
    
    

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    

    public Participationformation( int idFormation, int idUser, Boolean confirmation) {
        this.idFormation = idFormation;
        this.idUser = idUser;
        this.confirmation = confirmation;
    }

    public Participationformation() {
    }

    public int getIdParticipationFormation() {
        return idParticipationFormation;
    }

    public int getIdFormation() {
        return idFormation;
    }

    public int getIdUser() {
        return idUser;
    }

    public Boolean getConfirmation() {
        return confirmation;
    }

    public void setIdParticipationFormation(int idParticipationFormation) {
        this.idParticipationFormation = idParticipationFormation;
    }

    public void setIdFormation(int idFormation) {
        this.idFormation = idFormation;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setConfirmation(Boolean confirmation) {
        this.confirmation = confirmation;
    }

    @Override
    public String toString() {
        return "Participationformation{" + "idParticipationFormation=" + idParticipationFormation + ", idFormation=" + idFormation + ", idUser=" + idUser + ", confirmation=" + confirmation + ", titre=" + titre + ", email=" + email + ", nom=" + nom + '}';
    }

   
    
    
    
    
}
