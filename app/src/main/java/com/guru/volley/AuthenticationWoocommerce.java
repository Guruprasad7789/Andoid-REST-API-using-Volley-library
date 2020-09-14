package com.guru.volley;

public class AuthenticationWoocommerce {

    private final static String consumerKey="ck_5284fa04c5918c1e90b9274afcee549bf62badbe";
    private final static String consumerSecret="cs_355ac1e9f92157c2be6addb9642c4caa40d66592";
    private final  static String authString="consumer_key="+consumerKey+"&consumer_secret="+consumerSecret;

    public static String getAuth(){
        return authString;
    }

}
