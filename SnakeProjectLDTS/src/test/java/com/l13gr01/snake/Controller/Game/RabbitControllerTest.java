package com.l13gr01.snake.Controller.Game;

import com.l13gr01.snake.Action;
import com.l13gr01.snake.Model.Game.Rabbit;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.Positive;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RabbitControllerTest {
    private Rabbit rabbit;
    private RabbitController rabbitController;
    private int x_value;
    private int y_value;
    @Property
    void moveLeft(@ForAll @Positive int x, @ForAll @Positive int y){
        rabbit = new Rabbit(x,y);
        x_value = rabbit.getX();
        y_value = rabbit.getY();
        rabbitController = new RabbitController(rabbit, Action.LEFT);
        rabbitController.movement();
        assertEquals(x_value-1,rabbit.getX());
        assertEquals(y_value,rabbit.getY());
    }
    @Property
    void moveRight(@ForAll @Positive int x, @ForAll @Positive int y){
        rabbit = new Rabbit(x,y);
        x_value = rabbit.getX();
        y_value = rabbit.getY();
        rabbitController = new RabbitController(rabbit, Action.RIGHT);
        rabbitController.movement();
        assertEquals(x_value+1,rabbit.getX());
        assertEquals(y_value,rabbit.getY());
    }
    @Property
    void moveUp(@ForAll @Positive int x, @ForAll @Positive int y){
        rabbit = new Rabbit(x,y);
        x_value = rabbit.getX();
        y_value = rabbit.getY();
        rabbitController = new RabbitController(rabbit, Action.UP);
        rabbitController.movement();
        assertEquals(x_value,rabbit.getX());
        assertEquals(y_value-1,rabbit.getY());
    }
    @Property
    void moveDown(@ForAll @Positive int x, @ForAll @Positive int y){
        rabbit = new Rabbit(x,y);
        x_value = rabbit.getX();
        y_value = rabbit.getY();
        rabbitController = new RabbitController(rabbit, Action.DOWN);
        rabbitController.movement();
        assertEquals(x_value,rabbit.getX());
        assertEquals(y_value+1,rabbit.getY());
    }
}
