/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author asus
 */
public class User {
    
    private int id_client;
    
    public String getAdresse() {
        return adresse;
    }

    public User(int id_client, String nom, String adresse, String email) {
        this.id_client = id_client;
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
    }
  public User( String nom, String adresse, String email) {
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
    }
    @Override
    public String toString() {
        return "User{" + "id_client=" + id_client + ", nom=" + nom + ", adresse=" + adresse + ", email=" + email + '}';
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    private String nom,adresse,email;

    public User(int id_client, String nom) {
        this.id_client = id_client;
        this.nom = nom;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId_client() {
        return id_client;
    }

    public String getNom() {
        return nom;
    }
}
