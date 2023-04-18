package com.l13gr01.snake.Gui;

import com.l13gr01.snake.Action;
import com.l13gr01.snake.Model.Game.*;
import com.l13gr01.snake.Model.Menu.Menu;

import java.io.IOException;

public interface GuiInterface {
    Action getNextAction() throws IOException;
    void drawText(int col, int row, String color, String text, boolean default_color);
    void drawMenu(Menu menu);
    void drawStage(Stage stage);
    void drawWall(Wall wall);
    void drawSnake(Snake snake);
    void drawRock(Rock rock);
    void drawFruit(Fruit fruit);
    void drawRabbit(Rabbit rabbit);
    void refresh() throws IOException;
    void close() throws IOException;
    void clear();
}
