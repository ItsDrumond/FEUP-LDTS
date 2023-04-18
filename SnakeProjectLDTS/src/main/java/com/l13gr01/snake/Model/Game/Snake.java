package com.l13gr01.snake.Model.Game;

import com.l13gr01.snake.Model.Position;

import java.util.ArrayList;

public class Snake extends Element{
    private ArrayList<Position> body;
    private boolean selfCollision = false;

    public Snake(int x, int y){
        super(x,y);
        body = new ArrayList<>();

        int snake_Body_Size_Init = 4;
        for (int i = 0; i < snake_Body_Size_Init; i++){
            body.add(new Position(x,y));
        }
    }

    public void moveLeft(){
        ArrayList<Position> oldBody = getBody();
        Position oldHead = getHead();
        if(!oldBody.contains(oldHead.moveLeft())) {
            Position newHead = oldHead.moveLeft();
            oldBody.add(0,newHead);
            oldBody.remove(oldBody.size()-1);
            setBody(oldBody);
            setHeadPosition(newHead);
        }
        else{
            selfCollision = true;
        }
    }

    public void moveRight(){
        ArrayList<Position> oldBody = getBody();
        Position oldHead = getHead();
        if(!oldBody.contains(oldHead.moveRight())) {
            Position newHead = oldHead.moveRight();
            oldBody.add(0,newHead);
            oldBody.remove(oldBody.size()-1);
            setBody(oldBody);
            setHeadPosition(newHead);
        }
        else{
            selfCollision = true;
        }
    }

    public void moveUp(){
        ArrayList<Position> oldBody = getBody();
        Position oldHead = getHead();
        if(!oldBody.contains(oldHead.moveUp())) {
            Position newHead = oldHead.moveUp();
            oldBody.add(0,newHead);
            oldBody.remove(oldBody.size()-1);
            setBody(oldBody);
            setHeadPosition(newHead);
        }
        else{
            selfCollision = true;
        }
    }

    public void moveDown(){
        ArrayList<Position> oldBody = getBody();
        Position oldHead = getHead();
        if(!oldBody.contains(oldHead.moveDown())){
            Position newHead = oldHead.moveDown();
            oldBody.add(0,newHead);
            oldBody.remove(oldBody.size()-1);
            setBody(oldBody);
            setHeadPosition(newHead);
        }
        else{
            selfCollision = true;
        }
    }

    public void cutInHalf(){
        if(body.size() >= 8) {
            int length = body.size();
            while (body.size() > (length / 1.5)) {
                body.remove(body.size()-1);
            }
        }
    }

    public ArrayList<Position> getBody(){
        return body;
    }

    public Position getHead(){
        return this.position;
    }

    public void setBody(ArrayList<Position> newBody){
        this.body = newBody;
    }

    public void setHeadPosition(Position position) {
        this.position = position;
    }

    public boolean getSelfCollision(){
        return selfCollision;
    }

    public void grow(){
        body.add(getHead());
    }
}
