package com.l13gr01.snake.State;

import com.l13gr01.snake.Action;
import com.l13gr01.snake.Controller.Game.SnakeController;
import com.l13gr01.snake.Game;
import com.l13gr01.snake.Gui.Gui;
import com.l13gr01.snake.Model.Position;
import com.l13gr01.snake.States.GameStateM;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameStateMTest {
    private GameStateM gameState = new GameStateM();
    private Gui gui;
    private Game game;
    private SnakeController Up = new SnakeController(gameState.getStage().getSnake(), Action.UP);
    private SnakeController Down = new SnakeController(gameState.getStage().getSnake(),Action.DOWN);
    private SnakeController Left = new SnakeController(gameState.getStage().getSnake(),Action.LEFT);
    private SnakeController Right = new SnakeController(gameState.getStage().getSnake(),Action.RIGHT);
    private ArrayList<Position> body_collision = new ArrayList<>();

    @BeforeEach
    void setUp(){
        gui = Mockito.mock(Gui.class);
        game = Mockito.mock(Game.class);
    }

    @Test
    void QuitTest() throws IOException {
        Mockito.when(gui.getNextAction()).thenReturn(Action.QUIT);
        boolean result = gameState.step(gui,game);
        assertTrue(result);
    }
    @Test
    void SelfCollisionTestUp() throws IOException {

        body_collision.add(new Position(1,0));

        gameState.getStage().getSnake().setBody(body_collision);

        gameState.getStage().getSnake().setHeadPosition(new Position(1,1));
        Up.movement();
        boolean result_up = gameState.step(gui, game);
        assertTrue(result_up);
    }
    @Test
    void SelfCollisionTestDown() throws IOException {

        body_collision.add(new Position(1,2));

        gameState.getStage().getSnake().setBody(body_collision);

        gameState.getStage().getSnake().setHeadPosition(new Position(1,1));
        Down.movement();
        boolean result_down = gameState.step(gui, game);
        assertTrue(result_down);
    }
    @Test
    void SelfCollisionTestLeft() throws IOException {

        body_collision.add(new Position(0,1));

        gameState.getStage().getSnake().setBody(body_collision);

        gameState.getStage().getSnake().setHeadPosition(new Position(1,1));
        Left.movement();
        boolean result_left = gameState.step(gui, game);
        assertTrue(result_left);
    }
    @Test
    void SelfCollisionTestRight() throws IOException {

        body_collision.add(new Position(2,1));

        gameState.getStage().getSnake().setBody(body_collision);

        gameState.getStage().getSnake().setHeadPosition(new Position(1,1));
        Right.movement();
        boolean result_right = gameState.step(gui, game);
        assertTrue(result_right);
    }
    @Test
    void WallCollisionTestUp() throws IOException {

        gameState.getStage().getSnake().setHeadPosition(new Position(5,1));
        Up.movement();
        boolean result_up = gameState.step(gui, game);
        assertTrue(result_up);
    }
    @Test
    void WallCollisionTestDown() throws IOException {

        gameState.getStage().getSnake().setHeadPosition(new Position(5,gameState.getStage().getHeight()-2));
        Down.movement();
        boolean result_down = gameState.step(gui, game);
        assertTrue(result_down);
    }
    @Test
    void WallCollisionTestLeft() throws IOException {

        gameState.getStage().getSnake().setHeadPosition(new Position(1,5));
        Left.movement();
        boolean result_left = gameState.step(gui, game);
        assertTrue(result_left);
    }
    @Test
    void WallCollisionTestRight() throws IOException {

        gameState.getStage().getSnake().setHeadPosition(new Position(gameState.getStage().getWidth()-2,5));
        Right.movement();
        boolean result_right = gameState.step(gui, game);
        assertTrue(result_right);
    }
}
