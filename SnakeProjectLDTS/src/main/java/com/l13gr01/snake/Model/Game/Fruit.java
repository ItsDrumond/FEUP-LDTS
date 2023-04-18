package com.l13gr01.snake.Model.Game;

import com.l13gr01.snake.Model.Position;

import java.util.ArrayList;
import java.util.List;

public class Fruit extends Element {
    public Fruit(int x, int y) {
        super(x, y);
    }

    public Fruit generateFruit(ArrayList<Position> body, List<Wall> walls, int ROW_COUNT, int COL_COUNT){
        int row, column;
        boolean collides;
        while(true){
            collides = false;
            row = (int)(Math.random() * ROW_COUNT);
            column = (int)(Math.random() * COL_COUNT);
            if(!body.contains(new Position(row, column))){
                for(Wall wall : walls){
                    if(wall.getPosition().equals(new Position(row,column))){
                        collides = true;
                    }
                }
                if(!collides){break;}
            }
        }
        return new Fruit(row,column);
    }
}
