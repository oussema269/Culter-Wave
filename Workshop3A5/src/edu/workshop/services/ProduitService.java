package edu.workshop.services;

import edu.workshop.entites.produit;
import java.util.List;

public interface ProduitService {
    void ajouterproduit(produit p);
    void modifierproduit(produit p);
    void supprimerproduit(int id);
    List<produit> afficherproduits();
    public List<produit> afficherProduitsParCategorie(int id_cat);



}
