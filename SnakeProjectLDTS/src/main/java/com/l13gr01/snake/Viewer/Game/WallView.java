package com.l13gr01.snake.Viewer.Game;

import com.l13gr01.snake.Gui.Gui;
import com.l13gr01.snake.Model.Game.Wall;

import java.util.List;

public class WallView {
    public void draw(Gui gui, List<Wall> walls){
        for(Wall wall : walls){
            gui.drawWall(wall);
        }
    }
}
