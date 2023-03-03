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
public class Reclamation {
    private int id_reclamation;
    private int id_reclamateur;
    private int id_cible_reclamation;
    private String type_reclamation;
    private String contenu;
   
    

    public Reclamation() {
    }

    public Reclamation(int id_reclamation,int id_reclamateur,int id_cible_reclamation, String type_reclamation, String contenu ) {
        this.id_reclamation = id_reclamation;
        this.id_reclamateur = id_reclamateur;
        this.id_cible_reclamation = id_cible_reclamation;
        this.type_reclamation = type_reclamation;
        this.contenu = contenu;
        
        
        
        
    }
     public Reclamation(int id_reclamateur,int id_cible_reclamation, String type_reclamation, String contenu ) {
        
        this.id_reclamateur = id_reclamateur;
        this.id_cible_reclamation = id_cible_reclamation;
        this.type_reclamation = type_reclamation;
        this.contenu = contenu;
        
        
        
        
    }

    public int getid_reclamation() {
        return id_reclamation;
    }

    public void setid_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }
     public int getid_reclamateur() {
        return id_reclamateur;
    }

    public void setid_reclamateur(int id_reclamateur) {
        this.id_reclamateur = id_reclamateur;
    }
    
    public int getid_cible_reclamation() {
        return id_cible_reclamation;
    }

    public void setid_cible_reclamation(int id_cible_reclamation) {
        this.id_cible_reclamation = id_cible_reclamation;
    }

    public String gettype_reclamation() {
        return type_reclamation;
    }

    public void settype_reclamation(String type_reclamation) {
        this.type_reclamation = type_reclamation;
    }

    

    public String getcontenu() {
        return contenu;
    }

    public void setcontenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "Reclamation{  " + "id_reclamation=" + id_reclamation + " , id_reclamateur=" + id_reclamateur +" , id_cible_reclamation"+id_cible_reclamation  +" , type_reclamation=" + type_reclamation + " , contenu=" + contenu + '}';
    }
    
    
    
    
}
