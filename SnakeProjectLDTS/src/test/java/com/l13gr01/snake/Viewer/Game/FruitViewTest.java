package com.l13gr01.snake.Viewer.Game;

import com.l13gr01.snake.Gui.Gui;
import com.l13gr01.snake.Model.Game.Fruit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class FruitViewTest {
    private Fruit fruit;
    private FruitView fruitView;
    private Gui gui;
    @BeforeEach
    void setUp(){
        fruit = Mockito.mock(Fruit.class);
        fruitView = new FruitView();
        gui = Mockito.mock(Gui.class);
    }
    @Test
    void drawFruitCalls(){
        fruitView.draw(gui,fruit);
        Mockito.verify(gui, Mockito.times(1)).drawFruit(Mockito.any());
    }
}
