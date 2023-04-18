package com.l13gr01.snake.Viewer.Game;

import com.l13gr01.snake.Gui.Gui;
import com.l13gr01.snake.Model.Game.Rock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RockViewTest {
    private Rock rock;
    private RockView rockView;
    private Gui gui;
    @BeforeEach
    void setUp(){
        rock = Mockito.mock(Rock.class);
        rockView = new RockView();
        gui = Mockito.mock(Gui.class);
    }
    @Test
    void drawRockCalls(){
        rockView.draw(gui,rock);
        Mockito.verify(gui, Mockito.times(1)).drawRock(Mockito.any());
    }
}
