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
    private String nom;

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
