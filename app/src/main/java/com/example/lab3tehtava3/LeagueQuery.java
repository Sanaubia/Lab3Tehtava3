package com.example.lab3tehtava3;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LeagueQuery  {


    public String parse(JSONObject string) {

        JSONObject dataString = string;
        LeagueEngine engine = LeagueApp.giveEngine();
        League lisattava = null;
        lisattava = new League();

        try {

          List<String> lista = new ArrayList<String>();

            JSONArray array = dataString.getJSONArray("competitions");

            for(int i = 0 ; i < array.length() ; i++){
                lista.add(array.getJSONObject(i).getString("name"));

            }
            Log.d("DEBUG**********************", lista.get(0));
            for(int i = 0 ; i < lista.size() ; i++){
                String name = lista.get(i);
                lisattava.setName(name);
                engine.addLeague(lisattava);
            }



        } catch (Exception e) {
            Log.d("Exception**********************", e.toString());

        }

        return "";
    }


}
