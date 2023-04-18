package com.l13gr01.snake.States;

import com.l13gr01.snake.Game;
import com.l13gr01.snake.Gui.Gui;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class State {
    public State(){}

    public abstract Boolean step(Gui gui, Game game) throws IOException, InterruptedException, URISyntaxException, FontFormatException;
}
