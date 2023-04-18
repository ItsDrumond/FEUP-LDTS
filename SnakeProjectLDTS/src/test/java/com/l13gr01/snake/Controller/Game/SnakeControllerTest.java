package com.l13gr01.snake.Controller.Game;

import com.l13gr01.snake.Action;
import com.l13gr01.snake.Model.Game.Snake;
import net.jqwik.api.*;
import net.jqwik.api.constraints.Positive;

import static org.junit.jupiter.api.Assertions.*;

class SnakeControllerTest {
    private Snake snake;
    private SnakeController snakeController;
    private Action directions;
    private int x_value;
    private int y_value;
    @Property
    void moveLeft(@ForAll @Positive int x, @ForAll @Positive int y){
        snake = new Snake(x,y);
        x_value = snake.getX();
        y_value = snake.getY();
        snakeController = new SnakeController(snake, directions.LEFT);
        snakeController.movement();
        assertEquals(x_value-1,snake.getX());
        assertEquals(y_value,snake.getY());
    }
    @Property
    void moveRight(@ForAll @Positive int x, @ForAll @Positive int y){
        snake = new Snake(x,y);
        x_value = snake.getX();
        y_value = snake.getY();
        snakeController = new SnakeController(snake, directions.RIGHT);
        snakeController.movement();
        assertEquals(x_value+1,snake.getX());
        assertEquals(y_value,snake.getY());
    }
    @Property
    void moveUp(@ForAll @Positive int x, @ForAll @Positive int y){
        snake = new Snake(x,y);
        x_value = snake.getX();
        y_value = snake.getY();
        snakeController = new SnakeController(snake, directions.UP);
        snakeController.movement();
        assertEquals(x_value,snake.getX());
        assertEquals(y_value-1,snake.getY());
    }
    @Property
    void moveDown(@ForAll @Positive int x, @ForAll @Positive int y){
        snake = new Snake(x,y);
        x_value = snake.getX();
        y_value = snake.getY();
        snakeController = new SnakeController(snake, directions.DOWN);
        snakeController.movement();
        assertEquals(x_value,snake.getX());
        assertEquals(y_value+1,snake.getY());
    }
}