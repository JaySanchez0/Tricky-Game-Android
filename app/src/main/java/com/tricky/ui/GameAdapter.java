package com.tricky.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.trick.uiy.R;

public class GameAdapter extends BaseAdapter {
    private GameActivity context;

    public GameAdapter(GameActivity context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return 9;
    }

    @Override
    public Object getItem(int i) {
        int column = i%3;
        int row = i/3;
        return context.getGame().getBoardShape(row,column);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        char shape = (char) getItem(i);
        Button button = (Button) LayoutInflater.from(context)
                .inflate(R.layout.square_item,null).findViewById(R.id.button);
        button.setText(String.valueOf(shape));
        button.setOnClickListener(new GameButtonListener(i/3,i%3,context,button));
        context.addButton(button);
        return button;
    }
}
