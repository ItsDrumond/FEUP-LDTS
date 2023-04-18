package com.l13gr01.snake;

import com.l13gr01.snake.Gui.Gui;
import com.l13gr01.snake.States.MenuState;
import com.l13gr01.snake.States.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;


public class Game {
    private State state = new MenuState();
    private Gui gui = new Gui();
    private int FPS = 30;

    public Game() throws IOException, URISyntaxException, FontFormatException {}

    public void step() throws IOException, InterruptedException, URISyntaxException, FontFormatException {
        while(true) {
            if (state.step(gui, this)){
                break;
            }
            Thread.sleep(FPS);
        }
    }
    public void setSpeed(int value){
        this.FPS = value;
    }
    public void setState(State state){
        this.state = state;
    }
}
