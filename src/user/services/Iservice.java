/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.services;

import java.util.List;

/**
 *
 * @author FIRAS
 */
public interface Iservice<U> {
    public void ajouter(U u);
    public List<U> afficher();
    public void modifier(U u);
    public void supprimer(U u);
    
}
