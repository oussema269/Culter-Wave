/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Commande;
import java.util.List;

/**
 *
 * @author asus
 */
public interface InterfaceService<T> {
     List<T> afficher() ;
    void ajouter(T c);
    void modifier( T c , T c1);
    void supprimer( int i);
    
}
