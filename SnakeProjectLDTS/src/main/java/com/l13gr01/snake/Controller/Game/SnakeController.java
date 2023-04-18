package com.l13gr01.snake.Controller.Game;

import com.l13gr01.snake.Action;
import com.l13gr01.snake.Model.Game.Snake;

public class SnakeController implements Controller {
    private Snake snake;
    private Action action;

    public SnakeController(Snake snake, Action action) {
        this.snake = snake;
        this.action = action;
    }

    public void setDirections(Action directions) {
        this.action = directions;
    }

    public Action getAction() {
        return this.action;
    }

    @Override
    public void movement() {
        switch (action) {
            case LEFT -> snake.moveLeft();
            case RIGHT -> snake.moveRight();
            case UP -> snake.moveUp();
            case DOWN -> snake.moveDown();
            default -> {}
        }
    }
}
