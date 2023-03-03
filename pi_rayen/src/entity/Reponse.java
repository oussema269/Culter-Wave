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
public class Reponse {
    private int id_reponse;
    private int id_reclamation;
    private String repo;
    
   
    

    public Reponse() {
    }

    public Reponse(int id_reponse,int id_reclamation, String repo ) {
        this.id_reclamation = id_reclamation;
        this.id_reponse = id_reponse;
        this.repo = repo;
        
        
        
        
        
    }
     public Reponse(int id_reclamation, String repo ) {
        
        this.id_reclamation = id_reclamation;
        this.repo = repo;
        
    }

    public int getId_reponse() {
        return id_reponse;
    }

    public void setId_reponse(int id_reponse) {
        this.id_reponse = id_reponse;
    }

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    

    @Override
    public String toString() {
        return "Reponse{  " + "id_reponse=" + id_reponse + " , id_reclamation=" + id_reclamation +" , reponse= "+repo  + '}';
    }

    
    
    
    
    
}
