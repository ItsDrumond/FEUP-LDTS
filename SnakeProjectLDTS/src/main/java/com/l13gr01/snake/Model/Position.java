package com.l13gr01.snake.Model;

import java.util.Objects;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Position moveLeft(){
        return new Position(this.x-1, this.y);
    }

    public Position moveRight(){
        return new Position(this.x+1, this.y);
    }

    public Position moveUp(){
        return new Position(this.x, this.y-1);
    }

    public Position moveDown(){
        return new Position(this.x, this.y+1);
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null){
            return false;
        }
        if (!(o instanceof Position)){
            return false;
        }
        Position p = (Position) o;
        return this.x == p.getX() && this.y == p.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int distance(Position position){
        return (int ) Math.sqrt(Math.pow((this.x - position.x ),2) + Math.pow((this.y - position.y),2));
    }
}
