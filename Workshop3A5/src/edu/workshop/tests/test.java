package edu.workshop.tests;

import edu.workshop.utils.MyConnection;
import edu.workshop.entites.produit;
import edu.workshop.entites.categorie;
import edu.workshop.services.CRUDproduit;
import edu.workshop.services.CRUDcategorie;
import edu.workshop.services.ProduitService;
import java.util.List;

public class test {

    public static void main(String[] args) {
        
        MyConnection connexion = MyConnection.getInstance();
        
        // Test de la classe CRUDcategorie
        CRUDcategorie crudCategorie = new CRUDcategorie();
       /* 
        // Test de l'ajout d'une catégorie
        categorie cat1 = new categorie("Livre");
        crudCategorie.ajoutercategorie(cat1);
        
        // Test de la modification d'une catégorie
        categorie cat2 = new categorie(1, "Musique");
        crudCategorie.modifiercategorie(cat2);
        
        // Test de l'affichage de toutes les catégories
        List<categorie> categories = crudCategorie.affichercategories();
        for (categorie cat : categories) {
            System.out.println(cat);
        }
        
        // Test de la suppression d'une catégorie
        crudCategorie.supprimercategorie(1);
        
        // Test de la classe CRUDproduit
        CRUDproduit crudProduit = new CRUDproduit();
        
        // Test de l'ajout d'un produit
        produit prod1 = new produit("hemmas", 10, (float) 20.0, 1);
        crudProduit.ajouterproduit(prod1);
        
        // Test de la modification d'un produit
        produit prod2 = new produit(1, "produit modifié", 15, (float) 25.0, 1);
        crudProduit.modifierproduit(prod2);
        
        // Test de l'affichage de tous les produits
        List<produit> produits = crudProduit.afficherproduits();
        for (produit prod : produits) {
            System.out.println(prod);
        }
        
        // Test de la suppression d'un produit
        crudProduit.supprimerproduit(1);
        
        // Test de l'affichage des produits par catégorie
        ProduitService crudProduitParCategorie = new CRUDproduit();
        List<produit> produitsParCategorie = crudProduitParCategorie.afficherProduitsParCategorie(2);
        for (produit prod : produitsParCategorie) {
            System.out.println(prod);
        }*/
    }
}
