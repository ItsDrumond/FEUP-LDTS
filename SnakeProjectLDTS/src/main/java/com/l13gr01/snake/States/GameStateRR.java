package com.l13gr01.snake.States;

import com.l13gr01.snake.Action;
import com.l13gr01.snake.Controller.Game.RabbitController;
import com.l13gr01.snake.Controller.Game.RockController;
import com.l13gr01.snake.Controller.Game.SnakeController;
import com.l13gr01.snake.Game;
import com.l13gr01.snake.Gui.Gui;
import com.l13gr01.snake.Model.Game.Rock;
import com.l13gr01.snake.Model.Game.Stage;
import com.l13gr01.snake.Model.Game.Wall;
import com.l13gr01.snake.Model.Position;
import com.l13gr01.snake.Viewer.Game.*;

import java.io.IOException;
import java.util.ArrayList;

public class GameStateRR extends State{
    private Stage stage = new Stage(22,23);
    private RockView RockDisplay = new RockView();
    private RockController rocks = new RockController(stage.getRocks(), stage.getWidth(), stage.getHeight());
    private SnakeView SnakeDisplay = new SnakeView();
    private FruitView FruitDisplay = new FruitView();
    private StageView StageDisplay = new StageView();
    private RabbitView RabbitDisplay = new RabbitView();
    private WallView WallDisplay = new WallView();
    private int points = 0;
    private int fruitEatenWhileSpawned = 0;
    private int rabbitDirection;
    private ArrayList<Position> last_positions = new ArrayList<>();
    private ArrayList<Position> first_positions = new ArrayList<>();
    RabbitController rabbitController = new RabbitController(stage.getRabbit());
    SnakeController snakeDirection = new SnakeController(stage.getSnake(), Action.RIGHT);

    public GameStateRR(){}

    public void draw(Gui gui) throws IOException{
        gui.clear();
        StageDisplay.draw(gui, stage);
        FruitDisplay.draw(gui, stage.getFruit());
        RabbitDisplay.draw(gui, stage.getRabbit());
        SnakeDisplay.draw(gui, stage.getSnake());
        for(Rock rock : stage.getRocks()){RockDisplay.draw(gui, rock);}
        WallDisplay.draw(gui, stage.getWalls());
        gui.drawText(0,0,"#FFFFFF", String.valueOf(points), false);
        gui.refresh();
    }

    @Override
    public Boolean step(Gui gui, Game game) throws IOException {
        first_positions.clear();
        first_positions.add(stage.getSnake().getPosition());
        for (Rock rock : stage.getRocks()) {
            first_positions.add(rock.getPosition());
        }
        Action action = gui.getNextAction();
        if (action != Action.NONE) {
            if (action == Action.EOF) {
                return true;
            } else if (action == Action.QUIT) {
                gui.close();
                return true;
            } else if (action == Action.UP) {
                if (snakeDirection.getAction() != Action.DOWN) {
                    snakeDirection.setDirections(action);
                }
            } else if (action == Action.LEFT) {
                if (snakeDirection.getAction() != Action.RIGHT) {
                    snakeDirection.setDirections(action);
                }
            } else if (action == Action.DOWN) {
                if (snakeDirection.getAction() != Action.UP) {
                    snakeDirection.setDirections(action);
                }
            } else if (action == Action.RIGHT) {
                if (snakeDirection.getAction() != Action.LEFT) {
                    snakeDirection.setDirections(action);
                }
            } else if (action == Action.GROW) {
                stage.getSnake().grow();
            }
        }
        if (stage.getRabbit().randomChance() && stage.getRabbit().getPosition().equals(new Position(0, 0))) {
            fruitEatenWhileSpawned = 0;
            stage.getRabbit().setRabbit(stage.getRabbit().generateRabbit(stage.getSnake().getBody(), stage.getWalls(), stage.getHeight(), stage.getWidth(), stage.getFruit()).getPosition());
            rabbitDirection = stage.getRabbit().findNearestWall(stage.getWidth(), stage.getHeight());
        }
        if (fruitEatenWhileSpawned >= 3 && stage.getRabbit().getX() >= 1 && stage.getRabbit().getX() <= stage.getWidth() - 1 && stage.getRabbit().getY() <= stage.getHeight() - 1 && stage.getRabbit().getY() + 1 >= 0) {
            switch (rabbitDirection) {
                case 1 -> rabbitController.setAction(Action.UP);
                case 2 -> rabbitController.setAction(Action.LEFT);
                case 3 -> rabbitController.setAction(Action.DOWN);
                case 4 -> rabbitController.setAction(Action.RIGHT);
            }
            rabbitController.movement();
        }
        if (!(stage.getRabbit().getX() >= 1 && stage.getRabbit().getX() <= stage.getWidth() - 1 && stage.getRabbit().getY() <= stage.getHeight() - 1 && stage.getRabbit().getY() + 1 >= 0)) {
            fruitEatenWhileSpawned = 0;
            stage.getRabbit().setRabbit(new Position(0, 0));
        }
        if (stage.getSnake().getSelfCollision()) {
            gui.close();
            return true;
        }
        else if (stage.getSnake().getBody().contains(stage.getFruit().getPosition())) {
            stage.getSnake().grow();
            stage.setFruit(stage.getFruit().generateFruit(stage.getSnake().getBody(), stage.getWalls(), stage.getWidth(), stage.getHeight()));
            if (!stage.getRabbit().getPosition().equals(new Position(0, 0))) fruitEatenWhileSpawned++;
            points++;
        }
        if (stage.getSnake().getHead().equals(stage.getRabbit().getPosition())) {
            stage.getRabbit().setRabbit(new Position(0, 0));
            stage.getSnake().cutInHalf();
        }
        for (Wall wall : stage.getWalls()) {
            if (stage.getSnake().getBody().contains(wall.getPosition())) {
                gui.close();
                return true;
            }
        }
        for (Rock rock : stage.getRocks()) {
            if (stage.getSnake().getHead().equals(rock.getPosition())) {
                gui.close();
                return true;
            }
        }
        snakeDirection.movement();
        rocks.movement();
        for (Position position : first_positions) {
            for (Position position2 : last_positions) {
                if (first_positions.contains(new Position(position.getX(), position.getY() - 1)) && last_positions.contains(new Position(position2.getX(), position2.getY() - 1))) {
                    gui.close();
                    return true;
                }
            }
        }
        last_positions.clear();
        last_positions.add(stage.getSnake().getPosition());
        for (Rock rock : stage.getRocks()) {
            last_positions.add(rock.getPosition());
        }
        draw(gui);
        return false;
    }

    public Stage getStage(){
        return this.stage;
    }
}
