package com.l13gr01.snake.Viewer.Game;

import com.l13gr01.snake.Gui.Gui;
import com.l13gr01.snake.Model.Game.Stage;
import com.l13gr01.snake.Model.Game.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class WallViewTest {
    private List<Wall> walls;
    private Stage stage;
    private WallView wallView;
    private Gui gui;
    @BeforeEach
    void setUp() {
        stage = new Stage(5,5);
        walls = stage.getWalls();
        wallView = new WallView();
        gui = Mockito.mock(Gui.class);
    }
    @Test
    void drawWallCalls(){
        wallView.draw(gui, walls);
        Mockito.verify(gui, Mockito.times((2*(stage.getHeight()-1))+(2*(stage.getWidth()-1)))).drawWall(Mockito.any());
    }
}
