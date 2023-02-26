/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import workshop3a24.Entities.Formation;
import workshop3a24.Entities.Participationformation;
import workshop3a24.Entities.Personne;
import workshop3a24.Services.Formationservice;
import workshop3a24.Services.Personneservice;
import workshop3a24.Services.ServiceParticipationformation;
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
        String d = "2015-03-31";
        Date d1 = new Date(2023 - 1900, 13 - 01, 13);
        //System.out.println(d);
        /*             SimpleDateFormat d1 = new SimpleDateFormat("yyyy-MM-dd");
        int year = 2023;
        int month = 03;
        int day = 9;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, day);

        java.sql.Date date = new java.sql.Date(cal.getTimeInMillis());
        System.out.println(d1.format(date));*/
        //  Personne p = new Personne(8888, "hafez", "Mohamed AKA abou Maher");
        
      
        //  Participationformation p=new Participationformation(132585658,1112,true);
        //ServiceParticipationformation p1 =new ServiceParticipationformation();
        Personneservice p = new Personneservice();
        
        Personne p1= p.afficherByiduser(28);
//System.out.println(p.afficherByiduser(28));
        Formationservice sf = new Formationservice();
        // sf.add(f);
        System.out.println(sf.afficher());
          Formation f = new Formation(28, "test", "test", "syria", d1, d1, "test", false);
          ServiceParticipationformation sff=new ServiceParticipationformation();
         System.out.println(sff.afficher()); 
       
        //  Personne p = new Personne(8888, "hafez", "Mohamed AKA abou Maher");
        // ServicePersonne sp = new ServicePersonne();
        //  sp.add(p);
        //System.out.println(sf.afficher());
        //System.out.println(sf.afficherAccept());
        //p1.add(p);
        //System.out.println(p1.afficher()); 

    }

}
/*Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, 2022);
            calendar.set(Calendar.MONTH, Calendar.DECEMBER);
            calendar.set(Calendar.DAY_OF_MONTH, 25);
            java.util.Date specifiedDate = calendar.getTime();
            Date sqlDate = new Date(specifiedDate.getTime());*/
