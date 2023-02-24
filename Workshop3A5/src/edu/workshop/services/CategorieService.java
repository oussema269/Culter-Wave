/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.workshop.services;
import edu.workshop.entites.categorie;
import java.util.List;


import java.util.List;

import edu.workshop.entites.categorie;

public interface CategorieService {

    public void ajoutercategorie(categorie c);
    
    public void modifiercategorie(categorie c);
    
    public void supprimercategorie(int id);
    
    public List<categorie> affichercategories();
}
