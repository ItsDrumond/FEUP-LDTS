package com.l13gr01.snake.Viewer.Menu;

import com.l13gr01.snake.Model.Menu.Menu;
import com.l13gr01.snake.Gui.Gui;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MenuViewTest {
    private Menu menu;
    private MenuView menuView;
    private Gui gui;
    @BeforeEach
    void setUp(){
        menu = Mockito.mock(Menu.class);
        menuView = new MenuView();
        gui = Mockito.mock(Gui.class);
    }
    @Test
    void drawFruitCalls(){
        menuView.draw(gui,menu);
        Mockito.verify(gui, Mockito.times(1)).drawMenu(Mockito.any());
    }
}
