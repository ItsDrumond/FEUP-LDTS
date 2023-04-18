package com.l13gr01.snake.Controller.Menu;

import com.l13gr01.snake.Action;
import com.l13gr01.snake.Game;
import com.l13gr01.snake.Gui.Gui;
import com.l13gr01.snake.Model.Menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuControllerTest {

    MenuController menuController;
    Menu menu = new Menu();
    Menu menu2 = new Menu(true);
    Gui gui;
    Game game;
    @BeforeEach
    void setUp(){
        gui = Mockito.mock(Gui.class);
        game = Mockito.mock(Game.class);
        menuController = new MenuController(menu, menu2);
    }
    @Test
    void moveUpTopLimitTest() throws IOException{
        menu.setSelected(0);
        Mockito.when(gui.getNextAction()).thenReturn(Action.UP);
        menuController.Update(gui, game);
        assertEquals(true, menu.isSelected(4));
        assertEquals("Exit", menu.getEntry(4));
    }
    @Test
    void moveUpTest() throws IOException{
        menu.setSelected(2);
        Mockito.when(gui.getNextAction()).thenReturn(Action.UP);
        menuController.Update(gui, game);
        assertEquals(true, menu.isSelected(1));
        assertEquals("Rabbits & Rocks", menu.getEntry(1));
    }
    @Test
    void moveDownBottomLimitTest() throws IOException{
        menu.setSelected(4);
        Mockito.when(gui.getNextAction()).thenReturn(Action.DOWN);
        menuController.Update(gui, game);
        assertEquals(true, menu.isSelected(0));
        assertEquals("Classic", menu.getEntry(0));
    }
    @Test
    void moveDownTest() throws IOException{
        menu.setSelected(2);
        Mockito.when(gui.getNextAction()).thenReturn(Action.DOWN);
        menuController.Update(gui, game);
        assertEquals(true, menu.isSelected(3));
        assertEquals("Limitless", menu.getEntry(3));
    }
    @Test
    void moveUpTopLimitTest_Update2() throws IOException{
        menu2.setSelected(0);
        Mockito.when(gui.getNextAction()).thenReturn(Action.UP);
        menuController.Update2(gui, game);
        assertEquals(true, menu2.isSelected(2));
        assertEquals("Insane", menu2.getEntry(2));
    }
    @Test
    void moveUpTest_Update2() throws IOException{
        menu2.setSelected(2);
        Mockito.when(gui.getNextAction()).thenReturn(Action.UP);
        menuController.Update2(gui, game);
        assertEquals(true, menu2.isSelected(1));
        assertEquals("Medium", menu2.getEntry(1));
    }
    @Test
    void moveDownBottomLimitTest_Update2() throws IOException{
        menu2.setSelected(2);
        Mockito.when(gui.getNextAction()).thenReturn(Action.DOWN);
        menuController.Update2(gui, game);
        assertEquals(true, menu2.isSelected(0));
        assertEquals("Easy", menu2.getEntry(0));
    }
    @Test
    void moveDownTest_Update2() throws IOException{
        menu2.setSelected(1);
        Mockito.when(gui.getNextAction()).thenReturn(Action.DOWN);
        menuController.Update2(gui, game);
        assertEquals(true, menu2.isSelected(2));
        assertEquals("Insane", menu2.getEntry(2));
    }
}
