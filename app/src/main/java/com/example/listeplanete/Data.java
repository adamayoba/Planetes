package com.example.listeplanete;

import android.widget.ListView;

import java.util.ArrayList;

public class Data {
    private ArrayList<String> planetes;
   public Data() {
       installePlanetes();
   }

    public ArrayList<String> getPlanetes() {
        return planetes;
    }

    private void installePlanetes() {
        planetes = new ArrayList<String>();
        planetes.add("Mercure");
        planetes.add("Venus");
        planetes.add("Terre");
        planetes.add("Mars");
        planetes.add("Jupiter");
        planetes.add("Saturne");
        planetes.add("Uranus");
        planetes.add("Neptune");
        planetes.add("Pluton");
    }
}
