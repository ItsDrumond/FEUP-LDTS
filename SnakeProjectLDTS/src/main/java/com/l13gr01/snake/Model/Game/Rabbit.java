package com.l13gr01.snake.Model.Game;

import com.l13gr01.snake.Model.Position;

import java.util.ArrayList;
import java.util.List;

public class Rabbit extends Element{
    public Rabbit (int x, int y){
        super(x,y);
    }

    public Rabbit generateRabbit(ArrayList<Position> body, List<Wall> walls, int ROW_COUNT, int COL_COUNT, Fruit fruit){
        int row, column;
        boolean collides;
        while(true){
            collides = false;
            row = (int)(Math.random() * ROW_COUNT);
            column = (int)(Math.random() * COL_COUNT);
            if(!body.contains(new Position(row, column)) && !new Position(row, column).equals(fruit.getPosition())){
                for(Wall wall : walls){
                    if(wall.getPosition().equals(new Position(row,column))){
                        collides = true;
                    }
                }
                if(!collides){break;}
            }
        }
        return new Rabbit(row,column);
    }

    public boolean randomChance(){
        return Math.random() >= 0.995;
    }

    public void moveLeft() {
        setRabbit(getPosition().moveLeft());
    }

    public void moveRight() {
        setRabbit(getPosition().moveRight());
    }

    public void moveDown() {
        setRabbit(getPosition().moveDown());
    }

    public void moveUp() {
        setRabbit(getPosition().moveUp());
    }

    public int findNearestWall(int width, int height){
        Position A = new Position(width/2, 0);
        Position B = new Position(0, height/2);
        Position C = new Position(width/2, height);
        Position D = new Position(width, height/2);
        int[] Distances = new int[4];
        Distances[0] = getPosition().distance(A);
        Distances[1] = getPosition().distance(B);
        Distances[2] = getPosition().distance(C);
        Distances[3] = getPosition().distance(D);

        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < Distances.length; i++){
            if (Distances[i] <= min){
                min = Distances[i];
                index = i;
            }
        }
        return index+1;
    }

    public void setRabbit(Position position){
        this.position = position;
    }
}
