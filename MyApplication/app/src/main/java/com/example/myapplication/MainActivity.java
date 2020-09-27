package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button, button2, button3, button4, button5, button6, button7, button8, button9, btRetry, btQuit;
    public ArrayList<Button> listBtn;
    public static final String JOUEUR1 = "X";
    public static final String JOUEUR2 = "O";
    private static GameState state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initBtns();
    }

    private void init(){
        state = new GameState();
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
    }

    private void initBtns(){
        int compteur = 0;
        for (Button btn:listBtn){
            final int compteurFinal = compteur;
            btn.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (state.listeCaracteres.get(compteurFinal).equals(".")) {
                        state.listeCaracteres.set(compteurFinal, MainActivity.getCaractere());
                        listBtn.get(compteurFinal).setText(MainActivity.getCaractere());
                        if (MainActivity.getCaractere().equals("O")){
                            listBtn.get(compteurFinal).setTextColor(Color.BLUE);
                        }else{
                            listBtn.get(compteurFinal).setTextColor(Color.RED);
                        }
                        listBtn.get(compteurFinal).setEnabled(false);
                        testVictory();
                        state.tourPlusUn();
                    }
                }
            });
            compteur++;
        }
        btRetry.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRetry();
            }
        });
        btQuit.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(1);
            }
        });
    }

    private static String getCaractere(){
        if(state.tour%2>0){
            return MainActivity.JOUEUR2;
        }
        return MainActivity.JOUEUR1;
    }

    private void testVictory(){
        if (state.listeCaracteres.get(0)==MainActivity.JOUEUR1 && state.listeCaracteres.get(1)==MainActivity.JOUEUR1 && state.listeCaracteres.get(2)==MainActivity.JOUEUR1 ||
                state.listeCaracteres.get(0)==MainActivity.JOUEUR1 && state.listeCaracteres.get(3)==MainActivity.JOUEUR1 && state.listeCaracteres.get(6)==MainActivity.JOUEUR1 ||
                state.listeCaracteres.get(1)==MainActivity.JOUEUR1 && state.listeCaracteres.get(4)==MainActivity.JOUEUR1 && state.listeCaracteres.get(7)==MainActivity.JOUEUR1 ||
                state.listeCaracteres.get(2)==MainActivity.JOUEUR1 && state.listeCaracteres.get(5)==MainActivity.JOUEUR1 && state.listeCaracteres.get(8)==MainActivity.JOUEUR1 ||
                state.listeCaracteres.get(3)==MainActivity.JOUEUR1 && state.listeCaracteres.get(4)==MainActivity.JOUEUR1 && state.listeCaracteres.get(5)==MainActivity.JOUEUR1 ||
                state.listeCaracteres.get(6)==MainActivity.JOUEUR1 && state.listeCaracteres.get(7)==MainActivity.JOUEUR1 && state.listeCaracteres.get(8)==MainActivity.JOUEUR1 ||
                state.listeCaracteres.get(0)==MainActivity.JOUEUR1 && state.listeCaracteres.get(4)==MainActivity.JOUEUR1 && state.listeCaracteres.get(8)==MainActivity.JOUEUR1 ||
                state.listeCaracteres.get(2)==MainActivity.JOUEUR1 && state.listeCaracteres.get(4)==MainActivity.JOUEUR1 && state.listeCaracteres.get(6)==MainActivity.JOUEUR1){
            onVictory();
        }else if (state.listeCaracteres.get(0)==MainActivity.JOUEUR2 && state.listeCaracteres.get(1)==MainActivity.JOUEUR2 && state.listeCaracteres.get(2)==MainActivity.JOUEUR2 ||
                state.listeCaracteres.get(0)==MainActivity.JOUEUR2 && state.listeCaracteres.get(3)==MainActivity.JOUEUR2 && state.listeCaracteres.get(6)==MainActivity.JOUEUR2 ||
                state.listeCaracteres.get(1)==MainActivity.JOUEUR2 && state.listeCaracteres.get(4)==MainActivity.JOUEUR2 && state.listeCaracteres.get(7)==MainActivity.JOUEUR2 ||
                state.listeCaracteres.get(2)==MainActivity.JOUEUR2 && state.listeCaracteres.get(5)==MainActivity.JOUEUR2 && state.listeCaracteres.get(8)==MainActivity.JOUEUR2 ||
                state.listeCaracteres.get(3)==MainActivity.JOUEUR2 && state.listeCaracteres.get(4)==MainActivity.JOUEUR2 && state.listeCaracteres.get(5)==MainActivity.JOUEUR2 ||
                state.listeCaracteres.get(6)==MainActivity.JOUEUR2 && state.listeCaracteres.get(7)==MainActivity.JOUEUR2 && state.listeCaracteres.get(8)==MainActivity.JOUEUR2 ||
                state.listeCaracteres.get(0)==MainActivity.JOUEUR2 && state.listeCaracteres.get(4)==MainActivity.JOUEUR2 && state.listeCaracteres.get(8)==MainActivity.JOUEUR2 ||
                state.listeCaracteres.get(2)==MainActivity.JOUEUR2 && state.listeCaracteres.get(4)==MainActivity.JOUEUR2 && state.listeCaracteres.get(6)==MainActivity.JOUEUR2){
            onVictory();
        }
    }

    private void onVictory(){
        Toast.makeText(MainActivity.this, "Le joueur "+MainActivity.getCaractere()+" à gagné", Toast.LENGTH_LONG).show();
        for (Button btn:listBtn){
            btn.setEnabled(false);
        }
    }

    private void onRetry(){
        state.onReset();
        for (Button btn:listBtn){
            btn.setText("");
            btn.setEnabled(true);
        }
    }

    @Override
    protected void onPause() {
        Serializer.serialize("save", state, MainActivity.this);
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void getSerialize(Context contexte){
        state = (GameState) Serializer.deserialize("save", contexte);
    }

    private void refresh(){
        try{
            getSerialize(this);
            int compteur = 0;
            for (Button btn:listBtn){
                if (state.listeCaracteres.get(compteur).equals(".")) {
                    listBtn.get(compteur).setText(state.listeCaracteres.get(compteur));
                    if (MainActivity.getCaractere().equals("O")){
                        listBtn.get(compteur).setTextColor(Color.BLUE);
                    }else{
                        listBtn.get(compteur).setTextColor(Color.RED);
                    }
                }
            }
        }catch (Exception e){};
    }
}
