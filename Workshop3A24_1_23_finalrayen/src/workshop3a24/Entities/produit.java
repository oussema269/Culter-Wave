package workshop3a24.Entities;
public class produit {
    private int id, stock, id_cat,id_owner;
    private float prix;
    private String lib;
   


    public produit() {
    }

    public produit(String lib, int stock, float prix) {
        this.stock = stock;
        this.prix = prix;
        this.lib = lib;
    }

    public produit( String lib, int stock, float prix, int id_cat,int id_owner) {
        
        this.lib = lib;
        this.stock = stock;
        this.prix = prix;
        this.id_cat = id_cat;
        this.id_owner=id_owner;
    }

    public produit(int id, String lib, int stock, float prix, int id_cat) {
        
        this.id = id;
        this.lib = lib;
        this.stock = stock;
        this.prix = prix;
        this.id_cat = id_cat;
      
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
    public int getId_owner()
    {
        return id_owner;
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
        public void setId_owner()
    {
        this.id_owner=id_owner;
    }

    

    @Override
    public String toString() {
        return "Produit [id=" + id + ", lib=" + lib + ", prix=" + prix + ", stock=" + stock + ", id_cat=" + id_cat + "]";
    }
}
