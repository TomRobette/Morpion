package com.example.myapplication;

import android.widget.Button;

import java.util.ArrayList;

public class GameState {
    public ArrayList<String> listeCaracteres;
    public int tour;

    public GameState(){
        listeCaracteres = new ArrayList<>();
        for (int a = 0; a<9; a++){
            listeCaracteres.add(".");
        }
    }

    public void tourPlusUn(){
        tour++;
    }

    public void onReset(){
        tour=0;
        listeCaracteres = new ArrayList<>();
        for (int a = 0; a<9; a++){
            listeCaracteres.add(".");
        }
    }


}
