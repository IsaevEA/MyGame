package org.example.Cell;

import org.example.Player;

public class CellTax  extends Cell {
    public CellTax(int position, String name) {
        super(position, name);
    }

    public void tax(Player player){
        //TODO переделать на switch case
        if (getPosition() == 8 || getPosition() == 21){
            if (player.getBalance() >= 45){
                player.setBalance(player.getBalance() - 45);
            }else player.setBlocked(true);
        } else if (getPosition() == 13 || getPosition() == 33) {
            if (player.getBalance() >= 70){
                player.setBalance(player.getBalance() - 70);
            }else player.setBlocked(true);
        }

    }
    @Override
    public String toString(){
        return "CellTax = {name" + super.getName() +
                ", position= " + super.getPosition() +
                "}";
    }
}
