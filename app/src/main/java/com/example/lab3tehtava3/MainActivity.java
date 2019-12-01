package com.example.lab3tehtava3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.textclassifier.TextLinks;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        final TextView vastaus = (TextView) findViewById (R.id.textView);

        String url = "https://api.football-data.org/v2/competitions?areas=2072";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest (Request.Method.GET, url, null , new Response.Listener<JSONObject> ( ) {
            @Override
            public void onResponse(JSONObject response) {
                vastaus.setText ("Response: " + response.toString ());
                Log.d ("VASTAUS", response.toString ( ));
            }
        }, new Response.ErrorListener ( ) {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ERROR", "VIRHE!!!!");
            }
        });

        //MySingleton.getIsntace(this).addToRequestQueue(jsonObjectRequest);
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }
}
