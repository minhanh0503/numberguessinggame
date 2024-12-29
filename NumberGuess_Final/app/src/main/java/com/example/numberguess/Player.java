package com.example.numberguess;

public class Player implements Comparable<Player>{
    private String userName;
    private int userPoints;

    public Player() {
        this.userName = "";
        this.userPoints = 0;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserPoints() {
        return userPoints;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public void setUserPoints(int point) {
        this.userPoints = point;
    }
    public int compareTo(Player other) {
        return other.userPoints - this.userPoints;
    }
}
