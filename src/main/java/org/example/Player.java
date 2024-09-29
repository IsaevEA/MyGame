package org.example;

import lombok.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Setter
@Getter

public class Player extends Thread{
    private String playerName;
    private int balance = 1500;
    private int position = 0;
    private  int prisonKey = 0;
    private boolean isBlocked;
    private int chance = 1;


    public Player(String playerName){
        this.playerName = playerName;
    }
    public Player(){}


    @Override
    public String toString() {
        return "Player{" +
                ", Имя игрока='" + playerName + '\'' +
                ", баланс=" + balance +
                ", позиция=" + position +
                '}';
    }


}
