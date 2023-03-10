package edu.workshop.api;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Sms {
   public  Sms(){
     // Find your Account SID and Auth Token at twilio.com/console
    // and set the environment variables. See http://twil.io/secure
    final String ACCOUNT_SID = "AC0eef8f895570c8fc0968985034fd9695";
    final String AUTH_TOKEN = "3206f17a354ba03eb206bd9d9eb19240";

   
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+21627865222"),
                new com.twilio.type.PhoneNumber("+15674065783"),
                "un produit a été crée")
            .create();

        System.out.println(message.getSid());
    
    }
   
    
}