package com.l13gr01.snake.Gui;


import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.l13gr01.snake.Model.Game.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GuiTest {
    private Screen screen;
    private Gui gui;
    private TextGraphics tg;

    @BeforeEach
    void setUp() throws URISyntaxException, IOException, FontFormatException {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(tg);
        gui = new Gui(screen);
    }

    @Test
    void drawStageTest() {
        Stage stage = Mockito.mock(Stage.class);
        gui.drawStage(stage);
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString(Mockito.any()));
    }

    @Test
    void drawWallTest() {
        Wall wall = Mockito.mock(Wall.class);
        gui.drawWall(wall);
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString(Mockito.any()));
    }
    @Test
    void drawSnakeTest(){
        Snake snake = Mockito.mock(Snake.class);
        gui.drawSnake(snake);
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString(Mockito.any()));
    }
    @Test
    void drawRockTest(){
        Rock rock = Mockito.mock(Rock.class);
        gui.drawRock(rock);
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString(Mockito.any()));
    }
    @Test
    void drawFruitTest(){
        Fruit fruit = Mockito.mock(Fruit.class);
        gui.drawFruit(fruit);
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString(Mockito.any()));
    }
    @Test
    void drawRabbitTest(){
        Rabbit rabbit = Mockito.mock(Rabbit.class);
        gui.drawRabbit(rabbit);
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString(Mockito.any()));
    }
}
