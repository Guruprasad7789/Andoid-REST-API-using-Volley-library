package com.guru.volley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestQueue requestQueue;
     //   Log.d("guru1","The url is "+url.toString());
        requestQueue= Volley.newRequestQueue(this);
        URL url= null;
        try {
            url = new URL("https://fishinreach.com/wp-json/wc/v3/products/attributes?per_page=100&"+AuthenticationWoocommerce.getAuth());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Log.d("guru1", "onCreate: https://fishinreach.com/wp-json/wc/v3/products/attributes?per_page=100&"+AuthenticationWoocommerce.getAuth());
                JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET,url.toString(), null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                        for(int i=0;i<response.length();i++){
                            JSONObject object=response.getJSONObject(i);
                            Log.d("guru1", "on response "+object.getString("name"));
                        }
                        //    Log.d("guru1", "size is "+response.length());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("guru1","something went wrong1");
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}
