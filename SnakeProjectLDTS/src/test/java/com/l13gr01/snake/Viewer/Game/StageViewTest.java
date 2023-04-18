package com.l13gr01.snake.Viewer.Game;

import com.l13gr01.snake.Gui.Gui;
import com.l13gr01.snake.Model.Game.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StageViewTest {
    private Stage stage;
    private StageView stageView;
    private Gui gui;
    @BeforeEach
    void setUp(){
        stage = Mockito.mock(Stage.class);
        stageView = new StageView();
        gui = Mockito.mock(Gui.class);
    }
    @Test
    void drawStageCalls(){
        stageView.draw(gui,stage);
        Mockito.verify(gui, Mockito.times(1)).drawStage(Mockito.any());
    }
}