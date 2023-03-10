/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import java.util.HashMap;
import java.util.Map;
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
public class PaymentApi {
    
    public static void pay(int f) throws StripeException {
        Stripe.apiKey ="sk_test_51K1TBAIBKkiTlXRIgX1qQhWhoWBv4IYaWpIXb0dml7OZjZtwjaxMtiILLjoEXupBoon5Zk810WAOkQvVYncB5C61009SjLwRZU"; // add your api key
    		Map<String, Object> params = new HashMap<>();
		params.put("amount", f);
		params.put("currency", "usd");
		params.put("customer", "cus_NQK73dnV0DlkWG");

		Charge charge = Charge.create(params);
		System.out.println(charge);
         

    }
    
}
