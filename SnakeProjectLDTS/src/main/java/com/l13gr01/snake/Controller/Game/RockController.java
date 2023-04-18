package com.l13gr01.snake.Controller.Game;

import com.l13gr01.snake.Model.Game.Rock;

import java.util.List;

public class RockController implements Controller {
    private final List<Rock> rocks;
    private final int stage_width;
    private final int stage_height;

    public RockController(List<Rock> rocks, int stage_width, int stage_height){
        this.rocks = rocks;
        this.stage_width = stage_width;
        this.stage_height = stage_height;
    }

    @Override
    public void movement(){
        for(Rock rock : rocks){
            if(rock.canMoveDown(stage_height)){
                rock.moveDown();
            }
            else{
                rock.redeployRock(stage_width);
            }
        }
    }
}
