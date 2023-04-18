package com.l13gr01.snake.Viewer.Game;

import com.l13gr01.snake.Gui.Gui;
import com.l13gr01.snake.Model.Game.Snake;

public class SnakeView {
    public void draw(Gui gui, Snake snake){
        gui.drawSnake(snake);
    }
}
