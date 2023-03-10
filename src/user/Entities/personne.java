/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.Entities;

/**
 *
 * @author FIRAS
 */
public class personne {
    int id ;
    String Nom , Prenom ,Email,password ;  
    String Type ;
    int isActive;
    public personne() {
    }

    public personne(String Nom, String Prenom, String Email, String password, String Type) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Email = Email;
        this.password = password;
        this.Type = Type ;
    }

   
    public int getId() {
        return id;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
    

    public void setId(int id) {
        this.id = id;
    }


    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    @Override
    public String toString() {
        return "personne{" + "id=" + id + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Email=" + Email + ", password=" + password + ", Type=" + Type + ", isActive=" + isActive + '}';
    }
    

}