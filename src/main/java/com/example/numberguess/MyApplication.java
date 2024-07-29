package com.example.numberguess;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {
    private Player currentPlayer = null;
    private List<Player> playerList = new ArrayList<>();

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public List getPlayerList() {
        return playerList;
    }
}
