package com.tricky.ui;

import android.view.View;
import android.widget.Button;

import com.tricky.model.Tricky;

public class GameButtonListener implements View.OnClickListener {
    private int i;
    private int j;
    private GameActivity context;
    private Button button;

    public GameButtonListener(int i,int j,GameActivity context,Button button){
        this.i = i;
        this.j = j;
        this.button = button;
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        try {
            context.move(i,j,button);
        }catch (Exception e){

        }
    }
}
