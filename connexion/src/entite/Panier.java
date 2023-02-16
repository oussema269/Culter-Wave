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
public class Panier {
    private int id_client;
    private int id_product;
    private int quantite;

   

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Panier( int id_client, int id_product,int quantite) {
        this.id_client = id_client;
        this.id_product = id_product;
         this.quantite = quantite;

    }

    @Override
    public String toString() {
        return "Panier{" + " id_client=" + id_client + ", id_product=" + id_product + ", quantite=" + quantite + '}';
    }

  

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }
    
    
}
