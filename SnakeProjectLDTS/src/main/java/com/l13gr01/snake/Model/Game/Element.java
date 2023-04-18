package com.l13gr01.snake.Model.Game;

import com.l13gr01.snake.Model.Position;

public abstract class Element {
    protected Position position;

    public Element(int x, int y){
        position = new Position(x,y);
    }

    public int getX(){
        return position.getX();
    }

    public int getY(){
        return position.getY();
    }

    public Position getPosition(){
        return position;
    }
}
