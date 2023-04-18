package com.l13gr01.snake.Model.Game;

import java.util.ArrayList;
import java.util.List;

public class Stage {
    private int width;
    private int height;
    private List<Wall> walls;
    private Snake snake = new Snake(4,11);
    private Snake snake2 = new Snake(17, 11);
    private Fruit fruit = new Fruit(5,5);
    private Rabbit rabbit = new Rabbit(0,0);
    private List<Rock> rocks;

    public Stage(int width, int height) {
        this.width = width;
        this.height = height;
        this.walls = createWalls();
        this.rocks = createRocks();
    }

    private List<Rock> createRocks(){
        List<Rock> newRocks = new ArrayList<>();
        newRocks.add(new Rock((int)(Math.random()*width-1)+1,0));
        newRocks.add(new Rock((int)(Math.random()*width-1)+1,-(height/3)));
        newRocks.add(new Rock((int)(Math.random()*width-1)+1, -(2*height/3)));
        return newRocks;
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height- 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }

    public List<Rock> getRocks(){
        return rocks;
    }

    public Fruit getFruit(){
        return fruit;
    }

    public void setFruit(Fruit fruit){
        this.fruit = fruit;
    }

    public Rabbit getRabbit(){
        return rabbit;
    }

    public List<Wall> getWalls(){
        return walls;
    }

    public Snake getSnake(){
        return snake;
    }

    public Snake getSnake2(){
        return snake2;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}