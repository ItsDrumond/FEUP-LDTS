package com.l13gr01.snake.States;

import com.l13gr01.snake.Action;
import com.l13gr01.snake.Controller.Game.SnakeController;
import com.l13gr01.snake.Game;
import com.l13gr01.snake.Gui.Gui;
import com.l13gr01.snake.Model.Game.Stage;
import com.l13gr01.snake.Model.Game.Wall;
import com.l13gr01.snake.Viewer.Game.*;

import java.io.IOException;

public class GameStateC extends State {
    private Stage stage = new Stage(22,23);
    private SnakeView SnakeDisplay = new SnakeView();
    private FruitView FruitDisplay = new FruitView();
    private StageView StageDisplay = new StageView();
    private WallView WallDisplay = new WallView();
    private int points = 0;
    SnakeController snakeDirection = new SnakeController(stage.getSnake(), Action.RIGHT);

    public GameStateC(){}

    public void draw(Gui gui) throws IOException{
        gui.clear();
        StageDisplay.draw(gui, stage);
        FruitDisplay.draw(gui, stage.getFruit());
        SnakeDisplay.draw(gui, stage.getSnake());
        WallDisplay.draw(gui, stage.getWalls());
        gui.drawText(0,0,"#FFFFFF", String.valueOf(points), false);
        gui.refresh();
    }

    @Override
    public Boolean step(Gui gui, Game game) throws IOException {
        Action action = gui.getNextAction();
        if(action != Action.NONE) {
            if (action == Action.EOF) {
                return true;
            }
            else if (action == Action.QUIT) {
                gui.close();
                return true;
            }
            else if (action == Action.UP) {
                if(snakeDirection.getAction() != Action.DOWN) {
                    snakeDirection.setDirections(action);
                }
            }
            else if (action == Action.LEFT) {
                if(snakeDirection.getAction() != Action.RIGHT) {
                    snakeDirection.setDirections(action);
                }
            }
            else if (action == Action.DOWN) {
                if(snakeDirection.getAction() != Action.UP) {
                    snakeDirection.setDirections(action);
                }
            }
            else if (action == Action.RIGHT) {
                if(snakeDirection.getAction() != Action.LEFT) {
                    snakeDirection.setDirections(action);
                }
            }
            else if (action == Action.GROW) {
                stage.getSnake().grow();
            }
        }
        if(stage.getSnake().getSelfCollision()){
            gui.close();
            return true;
        }
        else if(stage.getSnake().getBody().contains(stage.getFruit().getPosition())) {
            stage.getSnake().grow();
            stage.setFruit(stage.getFruit().generateFruit(stage.getSnake().getBody(), stage.getWalls(), stage.getWidth(), stage.getHeight()));
            points++;
        }
        for(Wall wall : stage.getWalls()){
            if(stage.getSnake().getBody().contains(wall.getPosition())){
                gui.close();
                return true;
            }
        }
        snakeDirection.movement();
        draw(gui);
        return false;
    }

    public Stage getStage(){
        return this.stage;
    }
}
