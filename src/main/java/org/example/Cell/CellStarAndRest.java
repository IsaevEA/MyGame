package org.example.Cell;

import lombok.ToString;

@ToString
public class CellStarAndRest extends Cell {
    public CellStarAndRest(int position, String name) {
        super(position, name);
    }


    @Override
    public String toString() {
        return "CellStarAndRest {"+
                " name=" + super.getName() +
                " position=" + super.getPosition()+
                "}";
    }
}
