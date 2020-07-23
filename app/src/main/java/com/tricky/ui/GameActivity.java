package com.tricky.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.trick.uiy.R;
import com.tricky.model.Tricky;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    private Tricky game;
    private ArrayList<Button> buttons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView();
        this.getSupportActionBar().hide();
    }

    private void gameView(){
        setContentView(R.layout.activity_main);
        game = new Tricky();
        buttons=new ArrayList<Button>();
        ((GridView)findViewById(R.id.gameBoard)).setAdapter(new GameAdapter(this));
    }

    private void winnerView(char player){
        setContentView(R.layout.winner_view);
        ((TextView)findViewById(R.id.win)).setText("Player "+String.valueOf(player));
    }

    public void addButton(Button button){
        buttons.add(button);
    }

    public Tricky getGame(){
        return game;
    }

    public void restart(View view){
        game.restart();
        for(Button button:buttons){
            button.setText("");
        }
    }

    public void move(int i, int j, Button button) {
        try {
            char player = game.getPlayer();
            game.select(i, j);
            button.setText(String.valueOf(player));
            if(game.isTricky()) winnerView(player);
            else if(game.isEndGame()) loserView();
        }catch (Exception e){

        }

    }

    private void loserView() {
        setContentView(R.layout.loser_view);
    }

    public void restartAgain(View view){
        gameView();
    }

}