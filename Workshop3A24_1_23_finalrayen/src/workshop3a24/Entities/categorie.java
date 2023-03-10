package workshop3a24.Entities;

public class categorie {
    private int id_cat;
    private String categorie;

    public categorie(int id_cat, String categorie) {
        this.id_cat = id_cat;
        this.categorie = categorie;
    }

    public categorie(String categorie) {
        this.categorie = categorie;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "categorie{" + "id_cat=" + id_cat + ", categorie=" + categorie + '}';
    }
}
