package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button, button2, button3, button4, button5, button6, button7, button8, button9, btRetry, btQuit;
    public static ArrayList<Button> listBtn;
    TextView textView;
    public static ArrayList<Character> listeCaracteres;
    public static final Character JOUEUR1 = 'X';
    public static final Character JOUEUR2 = 'Y';
    public static int tour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initBtns();
    }

    private void init(){
        tour=0;
        listeCaracteres = new ArrayList<>();
        for (int a = 0; a<9; a++){
            listeCaracteres.add('.');
        }
        listBtn = new ArrayList<>();
        button = findViewById(R.id.button);
        listBtn.add(button);
        button2 = findViewById(R.id.button2);
        listBtn.add(button2);
        button3 = findViewById(R.id.button3);
        listBtn.add(button3);
        button4 = findViewById(R.id.button4);
        listBtn.add(button4);
        button5 = findViewById(R.id.button5);
        listBtn.add(button5);
        button6 = findViewById(R.id.button6);
        listBtn.add(button6);
        button7 = findViewById(R.id.button7);
        listBtn.add(button7);
        button8 = findViewById(R.id.button8);
        listBtn.add(button8);
        button9 = findViewById(R.id.button9);
        listBtn.add(button9);
        btRetry = findViewById(R.id.btRetry);
        btQuit = findViewById(R.id.btQuit);
        textView = findViewById(R.id.textView);
    }

    private void initBtns(){
        int compteur = 0;
        for (Button btn:listBtn){
            final int compteurFinal = compteur;
            btn.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (MainActivity.listeCaracteres.get(compteurFinal)=='.') {
                        MainActivity.listeCaracteres.set(compteurFinal, MainActivity.getCaractere());
//                        MainActivity.listBtn.get(compteurFinal).setText(MainActivity.getCaractere());
                        testVictory();
                        MainActivity.tour++;
                    }
                }
            });
            compteur++;
        }
    }



    private static Character getCaractere(){
        if(MainActivity.tour%2>0){
            return MainActivity.JOUEUR2;
        }
        return MainActivity.JOUEUR1;
    }


    private void testVictory(){
        if (listeCaracteres.get(0)==MainActivity.JOUEUR1 && listeCaracteres.get(1)==MainActivity.JOUEUR1 && listeCaracteres.get(2)==MainActivity.JOUEUR1 ||
                listeCaracteres.get(0)==MainActivity.JOUEUR1 && listeCaracteres.get(3)==MainActivity.JOUEUR1 && listeCaracteres.get(6)==MainActivity.JOUEUR1 ||
                listeCaracteres.get(1)==MainActivity.JOUEUR1 && listeCaracteres.get(4)==MainActivity.JOUEUR1 && listeCaracteres.get(7)==MainActivity.JOUEUR1 ||
                listeCaracteres.get(2)==MainActivity.JOUEUR1 && listeCaracteres.get(5)==MainActivity.JOUEUR1 && listeCaracteres.get(8)==MainActivity.JOUEUR1 ||
                listeCaracteres.get(3)==MainActivity.JOUEUR1 && listeCaracteres.get(4)==MainActivity.JOUEUR1 && listeCaracteres.get(5)==MainActivity.JOUEUR1 ||
                listeCaracteres.get(6)==MainActivity.JOUEUR1 && listeCaracteres.get(7)==MainActivity.JOUEUR1 && listeCaracteres.get(8)==MainActivity.JOUEUR1 ||
                listeCaracteres.get(0)==MainActivity.JOUEUR1 && listeCaracteres.get(4)==MainActivity.JOUEUR1 && listeCaracteres.get(8)==MainActivity.JOUEUR1 ||
                listeCaracteres.get(2)==MainActivity.JOUEUR1 && listeCaracteres.get(4)==MainActivity.JOUEUR1 && listeCaracteres.get(6)==MainActivity.JOUEUR1){
            onVictory();
        }else if (listeCaracteres.get(0)==MainActivity.JOUEUR2 && listeCaracteres.get(1)==MainActivity.JOUEUR2 && listeCaracteres.get(2)==MainActivity.JOUEUR2 ||
                listeCaracteres.get(0)==MainActivity.JOUEUR2 && listeCaracteres.get(3)==MainActivity.JOUEUR2 && listeCaracteres.get(6)==MainActivity.JOUEUR2 ||
                listeCaracteres.get(1)==MainActivity.JOUEUR2 && listeCaracteres.get(4)==MainActivity.JOUEUR2 && listeCaracteres.get(7)==MainActivity.JOUEUR2 ||
                listeCaracteres.get(2)==MainActivity.JOUEUR2 && listeCaracteres.get(5)==MainActivity.JOUEUR2 && listeCaracteres.get(8)==MainActivity.JOUEUR2 ||
                listeCaracteres.get(3)==MainActivity.JOUEUR2 && listeCaracteres.get(4)==MainActivity.JOUEUR2 && listeCaracteres.get(5)==MainActivity.JOUEUR2 ||
                listeCaracteres.get(6)==MainActivity.JOUEUR2 && listeCaracteres.get(7)==MainActivity.JOUEUR2 && listeCaracteres.get(8)==MainActivity.JOUEUR2 ||
                listeCaracteres.get(0)==MainActivity.JOUEUR2 && listeCaracteres.get(4)==MainActivity.JOUEUR2 && listeCaracteres.get(8)==MainActivity.JOUEUR2 ||
                listeCaracteres.get(2)==MainActivity.JOUEUR2 && listeCaracteres.get(4)==MainActivity.JOUEUR2 && listeCaracteres.get(6)==MainActivity.JOUEUR2){
            onVictory();
        }
    }

    private void onVictory(){
        String msg;
        if (MainActivity.getCaractere()==MainActivity.JOUEUR1){
            msg = "BRUH1";
        }else{
            msg = "BRUH2";
        }
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
    }


}
