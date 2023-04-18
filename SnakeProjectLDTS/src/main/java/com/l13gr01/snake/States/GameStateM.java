package com.l13gr01.snake.States;

import com.l13gr01.snake.Action;
import com.l13gr01.snake.Controller.Game.SnakeController;
import com.l13gr01.snake.Game;
import com.l13gr01.snake.Gui.Gui;
import com.l13gr01.snake.Model.Game.Stage;
import com.l13gr01.snake.Model.Game.Wall;
import com.l13gr01.snake.Model.Position;
import com.l13gr01.snake.Viewer.Game.FruitView;
import com.l13gr01.snake.Viewer.Game.SnakeView;
import com.l13gr01.snake.Viewer.Game.StageView;
import com.l13gr01.snake.Viewer.Game.WallView;

import java.io.IOException;

public class GameStateM extends State {
    private Stage stage = new Stage(22,23);
    private int points = 0;
    private SnakeView SnakeDisplay = new SnakeView();
    private SnakeView Snake2Display = new SnakeView();
    private FruitView FruitDisplay = new FruitView();
    private StageView StageDisplay = new StageView();
    private WallView WallDisplay = new WallView();
    SnakeController snakeDirection = new SnakeController(stage.getSnake(), Action.RIGHT);
    SnakeController snakeDirection2 = new SnakeController(stage.getSnake2(), Action.LEFT);

    public GameStateM() {}

    public void draw(Gui gui) throws IOException{
        gui.clear();
        StageDisplay.draw(gui, stage);
        FruitDisplay.draw(gui, stage.getFruit());
        SnakeDisplay.draw(gui, stage.getSnake());
        Snake2Display.draw(gui, stage.getSnake2());
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
                    snakeDirection2.setDirections(Action.DOWN);
                }
            }
            else if (action == Action.LEFT) {
                if(snakeDirection.getAction() != Action.RIGHT) {
                    snakeDirection.setDirections(action);
                    snakeDirection2.setDirections(Action.RIGHT);
                }
            }
            else if (action == Action.DOWN) {
                if(snakeDirection.getAction() != Action.UP) {
                    snakeDirection.setDirections(action);
                    snakeDirection2.setDirections(Action.UP);
                }
            }
            else if (action == Action.RIGHT) {
                if(snakeDirection.getAction() != Action.LEFT) {
                    snakeDirection.setDirections(action);
                    snakeDirection2.setDirections(Action.LEFT);
                }
            }
            else if (action == Action.GROW) {
                stage.getSnake().grow();
                stage.getSnake2().grow();
            }
        }
        if(stage.getSnake().getSelfCollision()){
            gui.close();
            return true;
        }
        else if(stage.getSnake().getBody().contains(stage.getFruit().getPosition())) {
            stage.getSnake().grow();
            stage.getSnake2().grow();
            stage.setFruit(stage.getFruit().generateFruit(stage.getSnake().getBody(), stage.getWalls(), stage.getWidth(), stage.getHeight()));
            points++;
        }
        if(stage.getSnake2().getSelfCollision()){
            gui.close();
            return true;
        }
        else if(stage.getSnake2().getBody().contains(stage.getFruit().getPosition())) {
            stage.getSnake().grow();
            stage.getSnake2().grow();
            stage.setFruit(stage.getFruit().generateFruit(stage.getSnake().getBody(), stage.getWalls(), stage.getWidth(), stage.getHeight()));
            points++;
        }
        for(Wall wall : stage.getWalls()) if (stage.getSnake().getBody().contains(wall.getPosition())){
            gui.close();
            return true;
        }
        for(Wall wall : stage.getWalls()) if (stage.getSnake2().getBody().contains(wall.getPosition())){
            gui.close();
            return true;
        }
        for(Position bodyPart : stage.getSnake().getBody()){
            if(stage.getSnake2().getBody().contains(bodyPart)){
                gui.close();
                return true;
            }
        }
        snakeDirection.movement();
        snakeDirection2.movement();

        draw(gui);
        return false;
    }

    public Stage getStage(){
        return this.stage;
    }
}
