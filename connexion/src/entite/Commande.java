/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.util.Date;

/**
 *
 * @author asus
 */
public class Commande {
private int id,id_client,etat;
    private Date dateP;
public Commande( int id,int id_client, Date dateP, int etat) {
       this.id=id;
        this.id_client = id_client;
        this.dateP = dateP;
        this.etat=etat;
    }
    public Commande( int id,int id_client, Date dateP) {
       this.id=id;
        this.id_client = id_client;
        this.dateP = dateP;
    }
  public Commande( int id_client) {
       
        this.id_client = id_client;
        
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public Date getDateP() {
        return dateP;
    }

    public void setDateP(Date dateP) {
        this.dateP = dateP;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", id_client=" + id_client + ", dateP=" + dateP + '}';
    }
    


}
