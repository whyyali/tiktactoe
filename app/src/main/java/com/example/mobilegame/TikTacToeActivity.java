package com.example.mobilegame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TikTacToeActivity extends AppCompatActivity {
    private TextView playerOneScore , playerTwoScore, playerStatus;
    private AppCompatButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private AppCompatButton resetGame;
    boolean activePLayer;
    int playerOneScoreCount, playerTwoScoreCount, roundCount, flag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tik_tac_toe);
        activePLayer = true;
        playerOneScoreCount = 0;
        playerTwoScoreCount = 0;
        roundCount = 0;
        flag = 0;

        b1 = ""; b2 = ""; b3 = ""; b4 = ""; b5 = ""; b6 = ""; b7 = ""; b8 = ""; b9 = "";

        playerOneScore = findViewById(R.id.playerOneScore);
        playerTwoScore = findViewById(R.id.playerTwoScore);
        playerStatus = findViewById(R.id.screen);
        resetGame = findViewById(R.id.resetButton);

        init();

    }

    public void init(){
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
    }

    public void Check(View v){
        AppCompatButton currentButton = (AppCompatButton) v;
        if (currentButton.getText().toString().equals("")){
            if (activePLayer && flag == 0){
                ((AppCompatButton) v).setText("X");
                ((AppCompatButton) v).setTextColor(Color.parseColor("#DC2334"));
                flag = 1;
            } else{
                ((AppCompatButton) v).setText("O");
                ((AppCompatButton) v).setTextColor(Color.parseColor("#70FFEA"));
                flag = 0;
            }
            roundCount++;

            if (roundCount > 4){
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();
            }

            if (winnerCheck()){
                if (activePLayer){
                    playerOneScoreCount++;
                    updatePlayerScore();
                    Toast.makeText(this, "Player One Winner", Toast.LENGTH_SHORT).show();
                    playAgain();
                } else {
                    playerTwoScoreCount++;
                    updatePlayerScore();
                    Toast.makeText(this, "Player Two Winner", Toast.LENGTH_SHORT).show();
                    playAgain();
                }
            }else if (roundCount == 9){
                Toast.makeText(this, "Match Draw", Toast.LENGTH_SHORT).show();
                playAgain();
            } else{
                activePLayer = !activePLayer;
            }

            if (playerOneScoreCount > playerTwoScoreCount){
               playerStatus.setText("Player One is Winning!");
            } else if (playerTwoScoreCount > playerOneScoreCount) {
                playerStatus.setText("Player Two os Winning!");
            } else {
                playerStatus.setText("");
            }

            resetGame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   playAgain();
                   playerOneScoreCount = 0;
                   playerTwoScoreCount = 0;
                   playerStatus.setText("");
                   updatePlayerScore();
                }
            });
        }
    }

     public boolean winnerCheck(){
        boolean winnerResult = false;
        if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")){
             winnerResult = true;
        } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
            winnerResult = true;
        } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")){
            winnerResult = true;
        } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")){
            winnerResult = true;
        } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")){
            winnerResult = true;
        } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")){
            winnerResult = true;
        } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")){
            winnerResult = true;
        } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")){
            winnerResult = true;
        }
        return winnerResult;
    }

    public void updatePlayerScore(){
        playerOneScore.setText(""+ playerOneScoreCount);
        playerTwoScore.setText(""+ playerTwoScoreCount);
    }
    public void playAgain(){
        roundCount = 0;
        flag = 0;
        activePLayer = true;
        btn1.setText(""); btn2.setText(""); btn3.setText("");
        btn4.setText(""); btn5.setText(""); btn6.setText("");
        btn7.setText(""); btn8.setText(""); btn9.setText("");
        b1 = ""; b2 = ""; b3 = ""; b4 = ""; b5 = ""; b6 = ""; b7 = ""; b8 = ""; b9 = "";
    }

}