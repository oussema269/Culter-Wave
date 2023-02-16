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
public class Product {
    private int id_product;
    private double prix;

    public Product(double prix,int id_product) {
        this.prix = prix;
        this.id_product = id_product;
        
    }

    public int getId_product() {
        return id_product;
    }

    public double getPrix() {
        return prix;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    
}
