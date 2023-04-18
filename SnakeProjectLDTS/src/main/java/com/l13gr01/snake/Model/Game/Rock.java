package com.l13gr01.snake.Model.Game;

import com.l13gr01.snake.Model.Position;

public class Rock extends Element{
    public Rock(int x, int y){
        super(x,y);
    }

    public void setPosition(Position position){
        this.position = position;
    }

    public void moveDown(){
        setPosition(getPosition().moveDown());
    }

    public boolean canMoveDown(int stage_height){
        return getY() < stage_height;
    }

    public void redeployRock(int stage_width){
        setPosition(new Position((int) (Math.random()*stage_width-1)+1, 0));
    }
}
