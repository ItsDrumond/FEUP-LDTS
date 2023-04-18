package com.l13gr01.snake.State;

import com.l13gr01.snake.Action;
import com.l13gr01.snake.Game;
import com.l13gr01.snake.Gui.Gui;
import com.l13gr01.snake.States.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuStateTest {

    private MenuState menuState;
    private Gui gui;
    private Game game;

    @BeforeEach
    void setUp() {
        gui = Mockito.mock(Gui.class);
        game = Mockito.mock(Game.class);
    }
    @Test
    void quitTest() throws IOException, URISyntaxException, FontFormatException {
        menuState = new MenuState();
        Mockito.when(gui.getNextAction()).thenReturn(Action.QUIT);
        boolean result = menuState.step(gui,game);
        assertTrue(result);
    }
}