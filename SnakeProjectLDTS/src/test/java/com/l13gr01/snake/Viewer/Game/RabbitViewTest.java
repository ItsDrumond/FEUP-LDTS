package com.l13gr01.snake.Viewer.Game;

import com.l13gr01.snake.Gui.Gui;
import com.l13gr01.snake.Model.Game.Rabbit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RabbitViewTest {
    private Rabbit rabbit;
    private RabbitView rabbitView;
    private Gui gui;
    @BeforeEach
    void setUp(){
        rabbit = Mockito.mock(Rabbit.class);
        rabbitView = new RabbitView();
        gui = Mockito.mock(Gui.class);
    }
    @Test
    void drawRabbitCalls(){
        rabbitView.draw(gui,rabbit);
        Mockito.verify(gui, Mockito.times(1)).drawRabbit(Mockito.any());
    }
}