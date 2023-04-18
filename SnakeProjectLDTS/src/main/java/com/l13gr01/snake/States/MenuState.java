package com.l13gr01.snake.States;

import com.l13gr01.snake.Controller.Menu.MenuController;
import com.l13gr01.snake.Game;
import com.l13gr01.snake.Gui.Gui;
import com.l13gr01.snake.Model.Menu.Menu;
import com.l13gr01.snake.Viewer.Menu.MenuView;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MenuState extends State{
    private Menu menu = new Menu();
    private Menu menu2 = new Menu(true);
    private MenuController menuController = new MenuController(menu, menu2);
    private MenuView menuView = new MenuView();

    public MenuState(){}

    @Override
    public Boolean step(Gui gui, Game game) throws IOException, URISyntaxException, FontFormatException{
        if(menuController.isSelected_mode()){
            boolean res = menuController.Update2(gui, game);
            gui.clear();
            menuView.draw(gui, menu2);
            gui.refresh();
            return res;
        }
        boolean res = menuController.Update(gui, game);
        gui.clear();
        menuView.draw(gui, menu);
        gui.refresh();
        return res;
    }
}
