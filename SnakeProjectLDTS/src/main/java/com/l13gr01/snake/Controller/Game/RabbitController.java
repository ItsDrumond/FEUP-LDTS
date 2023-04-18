package com.l13gr01.snake.Controller.Game;

import com.l13gr01.snake.Action;
import com.l13gr01.snake.Model.Game.Rabbit;

public class RabbitController implements Controller{
    private Rabbit rabbit;
    private Action action;

    public RabbitController(Rabbit rabbit){
        this.rabbit = rabbit;
    }
    public RabbitController(Rabbit rabbit, Action action){
        this.rabbit = rabbit;
        this.action = action;
    }

    public void setAction(Action action){
        this.action = action;
    }
    @Override
    public void movement(){
        switch (action) {
            case LEFT -> rabbit.moveLeft();
            case RIGHT -> rabbit.moveRight();
            case UP -> rabbit.moveUp();
            case DOWN -> rabbit.moveDown();
            default -> {}
        }
    }
}
