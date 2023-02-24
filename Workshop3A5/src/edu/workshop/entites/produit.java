package edu.workshop.entites; 
public class produit {
    private int id, stock, id_cat;
    private float prix;
    private String lib;

    public produit() {
    }

    public produit(String lib, int stock, float prix, int id_cat) {
        this.stock = stock;
        this.prix = prix;
        this.lib = lib;
        this.id_cat = id_cat;
    }

    public produit(int id, String lib, int stock, float prix, int id_cat) {
        this.id = id;
        this.lib = lib;
        this.stock = stock;
        this.prix = prix;
        this.id_cat = id_cat;
    }

    public produit(String text, float parseFloat, int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    @Override
    public String toString() {
        return "Produit [id=" + id + ", lib=" + lib + ", prix=" + prix + ", stock=" + stock + ", id_cat=" + id_cat + "]";
    }
}
