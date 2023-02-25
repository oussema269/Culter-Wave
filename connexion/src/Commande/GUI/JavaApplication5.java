/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.google.gson.reflect.*;
import com.stripe.model.Card;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Token;
import static com.sun.org.apache.xalan.internal.lib.ExsltDynamic.map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static jdk.nashorn.internal.objects.NativeArray.map;
import static jdk.nashorn.internal.objects.NativeDebug.map;

/**
 *
 * @author rassa
 */
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws StripeException {
        // TODO code application logic here
        
      //strive maven version : <version>20.51.0</version>

		// add stripe key
		Stripe.apiKey = ""; //test key will start with sk_test
		 
		/*Earlier we used to retrieve normally, for more check here : https://github.com/talenteddeveloper/Stripe-api/blob/master/AddCardToCustomer.java*/
		//Customer customer = Customer.retrieve("cus_JPujXXXX"); 
		
		/*Now in updated stripe version, need to add source and other params */
		/*Map<String, Object> retrieveParams = new HashMap<String, Object>();
		List<String> expandList = new ArrayList<String>();
		expandList.add("sources");
		retrieveParams.put("expand", expandList);
		Customer customer = Customer.retrieve("cus_NOnHUovMpl7Vw0", retrieveParams, null); //add customer id here : it will start with cus_
		
		Map<String, Object> cardParam = new HashMap<String, Object>(); //add card details
		cardParam.put("number", "4111111111111111");
		cardParam.put("exp_month", "11");
		cardParam.put("exp_year", "2026");
		cardParam.put("cvc", "123");

		Map<String, Object> tokenParam = new HashMap<String, Object>();
		tokenParam.put("card", cardParam);

		Token token = Token.create(tokenParam); // create a token

		Map<String, Object> source = new HashMap<String, Object>();
		source.put("source", token.getId()); //add token as source

		Card card = (Card)customer.getSources().create(source); // add the customer details to which card is need to link
		String cardDetails = card.toJson();
		System.out.println("Card Details : " + cardDetails);
		customer = Customer.retrieve("cus_NOnHUovMpl7Vw0");//change the customer id or use to get customer by id.
		System.out.println("After adding card, customer details : " + customer);*/
		
		// sample output in stripe dashboard : https://github.com/talenteddeveloper/Stripe-api/blob/master/Added%20Card.jpg
         
                Stripe.apiKey ="sk_test_51K1TBAIBKkiTlXRIgX1qQhWhoWBv4IYaWpIXb0dml7OZjZtwjaxMtiILLjoEXupBoon5Zk810WAOkQvVYncB5C61009SjLwRZU"; // add your api key
    		Map<String, Object> params = new HashMap<>();
		params.put("amount", 3000);
		params.put("currency", "usd");
		params.put("customer", "cus_NQK73dnV0DlkWG");

		Charge charge = Charge.create(params);
		System.out.println(charge);
         
    }
    
}
