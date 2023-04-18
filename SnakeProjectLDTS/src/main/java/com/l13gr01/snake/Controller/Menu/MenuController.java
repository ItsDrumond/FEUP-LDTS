package com.l13gr01.snake.Controller.Menu;

import com.l13gr01.snake.Action;
import com.l13gr01.snake.Game;
import com.l13gr01.snake.Gui.Gui;
import com.l13gr01.snake.Model.Menu.Menu;
import com.l13gr01.snake.States.*;

import java.io.IOException;

public class MenuController {
    private Menu menu;
    private Menu menu2;
    private State state;
    private boolean selected_mode = false;

    public MenuController(Menu menu, Menu menu2) {
        this.menu = menu;
        this.menu2 = menu2;
    }

    public boolean Update(Gui gui, Game game) throws IOException{
        Action action = gui.getNextAction();
        if (action != Action.NONE) {
            switch (action) {
                default:
                    break;
                case UP:
                    menu.previousEntry();
                    break;
                case DOWN:
                    menu.nextEntry();
                    break;
                case QUIT:
                    gui.close();
                    return true;
                case SELECT:
                    if (menu.isSelectedExit()) {
                        gui.close();
                        return true;
                    }
                    else {
                        if (menu.isSelectedFirsti()) {
                            selected_mode = true;
                            state = new GameStateC();
                        }
                        if (menu.isSelectedSecondi()) {
                            selected_mode = true;
                            state = new GameStateRR();
                        }
                        if (menu.isSelectedThirdi()) {
                            selected_mode = true;
                            state = new GameStateM();
                        }
                        if (menu.isSelectedFourthi()) {
                            selected_mode = true;
                            state = new GameStateL();
                        }
                    }
                    break;
            }
        }
        return false;
    }

    public boolean Update2(Gui gui, Game game) throws IOException{
        Action action = gui.getNextAction();
        if (action != Action.NONE) {
            switch (action) {
                default:
                    break;
                case UP:
                    menu2.previousEntry();
                    break;
                case DOWN:
                    menu2.nextEntry();
                    break;
                case QUIT:
                    gui.close();
                    return true;
                case SELECT:
                    if (menu2.isSelectedFirsti()) {
                        game.setSpeed(90);
                        game.setState(state);
                    } else {
                        if (menu2.isSelectedSecondi()) {
                            game.setSpeed(70);
                            game.setState(state);
                        }
                        if (menu2.isSelectedThirdi()) {
                            game.setSpeed(50);
                            game.setState(state);
                        }
                    }
                    break;
            }
        }
        return false;
    }

    public boolean isSelected_mode(){
        return selected_mode;
    }
}
