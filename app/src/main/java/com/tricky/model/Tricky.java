package com.tricky.model;

import com.tricky.exception.TrickyException;

public class Tricky {
    private char[][] board;
    private char player;
    public Tricky(){
        restart();
    }

    public void select(int i,int j) throws TrickyException {
        if(board[i][j]!=' ') throw new TrickyException("Invalid move");
        board[i][j] = player;
        if(player=='X') player='O';
        else player='X';
    }

    public char getPlayer(){
        return player;
    }

    public char getBoardShape(int i,int j){
        return board[i][j];
    }

    public void restart(){
        board = new char[][]{{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
        player = 'X';
    }

    private boolean horizontalTricky(){
        for(int i=0;i<3;i++){
            if(horizontalTricky(i)) return  true;
        }
        return false;
    }

    private boolean horizontalTricky(int row){
        if(board[row][0]==' ') return false;
        char tmp = board[row][0];
        for(int i=0;i<3;i++){
            if(tmp!=board[row][i]) return  false;
        }
        return true;
    }

    private boolean verticalTricky(){
        for(int i=0;i<3;i++){
            if(verticalTricky(i)) return true;
        }
        return false;
    }
    private boolean verticalTricky(int col){
        if(board[0][col]==' ') return false;
        char tmp = board[0][col];
        for(int i=0;i<3;i++){
            if(tmp!=board[i][col]) return  false;
        }
        return true;
    }

    private boolean leftDiagonalTricky(){
        if(board[0][0]==' ') return false;
        char tmp = board[0][0];
        for(int i=0;i<3;i++){
            if(board[i][i]!=tmp) return false;
        }
        return true;
    }
    private boolean rightDiagonalTricky(){
        if(board[0][2]==' ') return false;
        char tmp = board[0][2];
        int j=2;
        for(int i=0;i<3;i++){
            if(board[i][j]!=tmp) return false;
            j-=1;
        }
        return true;
    }

    public boolean isTricky(){
        return  horizontalTricky() || verticalTricky() ||
                leftDiagonalTricky() || rightDiagonalTricky();
    }

    public boolean isEndGame(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]==' ') return false;
            }
        }
        return true;
    }

}
