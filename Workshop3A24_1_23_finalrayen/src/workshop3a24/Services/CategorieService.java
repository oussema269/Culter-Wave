/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.Services;
import java.util.List;


import java.util.List;
import workshop3a24.Entities.categorie;


public interface CategorieService {

    public void ajoutercategorie(categorie c);
    
    public void modifiercategorie(categorie c);
    
    public void supprimercategorie(int id);
    
    public List<categorie> affichercategories();
}
