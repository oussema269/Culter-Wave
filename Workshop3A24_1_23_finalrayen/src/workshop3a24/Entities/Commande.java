/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.Entities;
import java.util.Date;

/**
 *
 * @author asus
 */
public class Commande {
private int id,id_client,quantite,etat;
    private Date dateP;
    double prix,totale;
    String nomProduit,nom_Client,adresse;
   public Commande(int id,int id_client, int etat, Date dateP, double totale) {
        this.id=id;
        this.id_client = id_client;
        this.etat = etat;
        this.dateP = dateP;
        this.totale = totale;
    }
    public Commande(int id_client, int etat, Date dateP, double totale) {
        this.id_client = id_client;
        this.etat = etat;
        this.dateP = dateP;
        this.totale = totale;
    }
  public Commande(int id_client, int etat, double totale) {
        this.id_client = id_client;
        this.etat = etat;
        this.totale = totale;
    }
    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    

    public Commande(int id, int id_client, int quantite, int etat, Date dateP, double prix, String nomProduit, String nom_Client) {
        this.id = id;
        this.id_client = id_client;
        this.quantite = quantite;
        this.etat = etat;
        this.dateP = dateP;
        this.prix = prix;
        this.nomProduit = nomProduit;
        this.nom_Client = nom_Client;
    }

    public String getNom_Client() {
        return nom_Client;
    }

    public void setNom_Client(String nom_Client) {
        this.nom_Client = nom_Client;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }
public Commande( int id,int id_client, Date dateP, int etat) {
       this.id=id;
        this.id_client = id_client;
        this.dateP = dateP;
        this.etat=etat;
    }

    public Commande(int id, int id_client, Date dateP) {
        this.id = id;
        this.id_client = id_client;
        this.dateP = dateP;
    }
    public Commande( int id_client , int etat) {
        this.id_client = id_client;
        this.etat=etat;
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
