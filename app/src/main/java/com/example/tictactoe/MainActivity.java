package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.logging.XMLFormatter;

public class MainActivity extends AppCompatActivity {
      boolean gameActive = true;
//    O - X
//    1 - o
    int activePlayer = 0;
//    0 - X
//    1 - o
//    2 - null
    int [] gameState = {2,2,2,
                        2,2,2,
                        2,2,2};

    int winPositions [][] = {{0,1,2},{3,4,5},{6,7,8},
                            {0,3,6},{1,4,7},{2,5,8},
                            {0,4,8},{2,4,6}};
    public void handleClicked(View view){
        ImageView img = (ImageView) view ;
        int tappedImg = Integer.parseInt(img.getTag().toString());

        if (!gameActive){
            resetTheGame(view);
//            gameReset(view);
        }
        if (gameState[tappedImg]==2) {
            gameState[tappedImg] = activePlayer;

            img.setTranslationY(-1000f);

            if (activePlayer == 0) {
                TextView playerTurn = findViewById(R.id.playerStateArea);
                img.setImageResource(R.drawable.xshapes);
                activePlayer = 1;
                playerTurn.setText("O");
            } else {
                TextView playerTurn = findViewById(R.id.playerStateArea);
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                playerTurn.setText("X");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        ///winnig logic
        for (int [] winpos: winPositions){
           if (gameState[winpos[0]]==gameState[winpos[1]] &&
                   gameState[winpos[1]]==gameState[winpos[2]] &&
                   gameState[winpos[0]]!=2){
               gameActive = false;
               if (gameState[winpos[0]] == 0){
                   TextView winnerAreaTV = findViewById(R.id.winnerAreaTV);
                   TextView text1 = findViewById(R.id.text1);
                   TextView text2 = findViewById(R.id.text2);
                   TextView playerTurn = findViewById(R.id.playerStateArea);
                   text1.setText("");
                   text2.setText("");
                   playerTurn.setText("");
                   winnerAreaTV.setText("Player X Won");
                   Button resetBTN = findViewById(R.id.resetBTN);
                   resetBTN.setVisibility(View.VISIBLE);
               }else {
                   TextView winnerAreaTV = findViewById(R.id.winnerAreaTV);
                   TextView text1 = findViewById(R.id.text1);
                   TextView text2 = findViewById(R.id.text2);
                   TextView playerTurn = findViewById(R.id.playerStateArea);
                   text1.setText("");
                   text2.setText("");
                   playerTurn.setText("");
                   winnerAreaTV.setText("Player O Won");
                   Button resetBTN = findViewById(R.id.resetBTN);
                   resetBTN.setVisibility(View.VISIBLE);
               }
           }
        }
    }
    public void gameReset(View view){
        gameActive = true;
        activePlayer = 0;
        for(int i=0; i<gameState.length; i++){
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.IV1)).setImageResource(0);
        ((ImageView)findViewById(R.id.IV2)).setImageResource(0);
        ((ImageView)findViewById(R.id.IV3)).setImageResource(0);
        ((ImageView)findViewById(R.id.IV4)).setImageResource(0);
        ((ImageView)findViewById(R.id.IV5)).setImageResource(0);
        ((ImageView)findViewById(R.id.IV6)).setImageResource(0);
        ((ImageView)findViewById(R.id.IV7)).setImageResource(0);
        ((ImageView)findViewById(R.id.IV8)).setImageResource(0);
        ((ImageView)findViewById(R.id.IV9)).setImageResource(0);


    }

        public void resetTheGame(View view){
            gameActive = true;
            activePlayer = 0;
            for(int i=0; i<gameState.length; i++){
                gameState[i]=2;
            }
            ((ImageView)findViewById(R.id.IV1)).setImageResource(0);
            ((ImageView)findViewById(R.id.IV2)).setImageResource(0);
            ((ImageView)findViewById(R.id.IV3)).setImageResource(0);
            ((ImageView)findViewById(R.id.IV4)).setImageResource(0);
            ((ImageView)findViewById(R.id.IV5)).setImageResource(0);
            ((ImageView)findViewById(R.id.IV6)).setImageResource(0);
            ((ImageView)findViewById(R.id.IV7)).setImageResource(0);
            ((ImageView)findViewById(R.id.IV8)).setImageResource(0);
            ((ImageView)findViewById(R.id.IV9)).setImageResource(0);
            TextView winnerAreaTV = findViewById(R.id.winnerAreaTV);
            winnerAreaTV.setText("");

            Button resetBTN = findViewById(R.id.resetBTN);
            resetBTN.setVisibility(View.INVISIBLE);

            TextView text1 = findViewById(R.id.text1);
            TextView text2 = findViewById(R.id.text2);
            TextView playerTurn = findViewById(R.id.playerStateArea);
            text1.setText("Player:");
            text2.setText("Turn");
            playerTurn.setText("X");
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button resetBTN = findViewById(R.id.resetBTN);
        resetBTN.setVisibility(View.INVISIBLE);
    }
}