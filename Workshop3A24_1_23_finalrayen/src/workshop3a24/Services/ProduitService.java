package workshop3a24.Services;

import java.util.List;
import workshop3a24.Entities.produit;

public interface ProduitService {
    void ajouterproduit(produit p);
    void modifierproduit(produit p);
    void supprimerproduit(int id);
    List<produit> afficherproduits();
    public List<produit> afficherProduitsParCategorie(int id_cat);



}
