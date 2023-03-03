/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author rayen
 */
public class User {
    private int id;
    private String nom;
   
    private int type;

    public User() {
    }

    public User(int id, String nom, int type) {
        this.id = id;
        this.nom = nom;
        
        this.type = type;
    }
     public User( String nom, int type){
     this.id = id;
     this.type = type;
     }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom +  ", type=" + type + '}';
    }
    
    
    
    
}
