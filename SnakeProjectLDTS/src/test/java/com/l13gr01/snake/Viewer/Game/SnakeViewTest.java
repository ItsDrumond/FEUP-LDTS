package com.l13gr01.snake.Viewer.Game;

import com.l13gr01.snake.Gui.Gui;
import com.l13gr01.snake.Model.Game.Snake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SnakeViewTest {
    private Snake snake;
    private SnakeView snakeView;
    private Gui gui;
    @BeforeEach
    void setUp(){
        snake = Mockito.mock(Snake.class);
        snakeView = new SnakeView();
        gui = Mockito.mock(Gui.class);
    }
    @Test
    void drawSnakeCalls(){
        snakeView.draw(gui,snake);
        Mockito.verify(gui, Mockito.times(1)).drawSnake(Mockito.any());
    }
}