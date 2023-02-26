/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24;

import workshop3a24.Entities.Personne;
import workshop3a24.Services.ServicePersonne;
import workshop3a24.Utils.MyDB;

/**
 *
 * @author Mohamed
 */
public class Workshop3A24 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//     A a = A.getInstance();
//     A a1 =A.getInstance();
//        System.out.println(a.hashCode());
//        System.out.println(a1.hashCode());
//        MyDB a = MyDB.getInstance();
//        MyDB a1 = MyDB.getInstance();
//        System.out.println(a.hashCode());
//        System.out.println(a1.hashCode());

        Personne p = new Personne(8888, "hafez", "Mohamed AKA abou Maher");
        ServicePersonne sp = new ServicePersonne();
        //sp.add(p);
        System.out.println( sp.afficher());
    }
    
}
