package org.example.Cell;

import org.example.Player;

public class CellJail extends Cell {
    public void jail(Player player){
        player.setPosition(9);
        player.setPrisonKey(1);
    }

    public CellJail(int position, String name) {
        super(position, name);
    }

    public CellJail() {
    }
    @Override
    public String toString(){
        return "CellJail = {name" + super.getName() +
                ", position" + super.getPosition() +
                "}";
    }
}
