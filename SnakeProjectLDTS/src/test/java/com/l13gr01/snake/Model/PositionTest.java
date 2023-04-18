package com.l13gr01.snake.Model;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Property
    void moveLeft(@ForAll int x, @ForAll int y) {
        assertEquals(x - 1, new Position(x, y).moveLeft().getX());
        assertEquals(y, new Position(x, y).moveLeft().getY());
    }

    @Property
    void moveRight(@ForAll int x, @ForAll int y) {
        assertEquals(x + 1, new Position(x, y).moveRight().getX());
        assertEquals(y, new Position(x, y).moveRight().getY());
    }

    @Property
    void moveUp(@ForAll int x, @ForAll int y) {
        assertEquals(x, new Position(x, y).moveUp().getX());
        assertEquals(y - 1, new Position(x, y).moveUp().getY());
    }

    @Property
    void moveDown(@ForAll int x, @ForAll int y) {
        assertEquals(x, new Position(x, y).moveDown().getX());
        assertEquals(y + 1, new Position(x, y).moveDown().getY());
    }

    @Property
    void getX(@ForAll int x, @ForAll int y){
        assertEquals(x, new Position(x,y).getX());
        assertEquals(y, new Position(x,y).getY());
    }

    @Property
    void getY(@ForAll int x, @ForAll int y){
        assertEquals(x, new Position(x,y).getX());
        assertEquals(y, new Position(x,y).getY());
    }

    @Property
    void equals(@ForAll int x, @ForAll int y){
        Position same = new Position(x,y);
        Position same_ = new Position(x,y);
        assertEquals(true,same.equals(same_));
    }

    @Property
    void not_equals(@ForAll int x, @ForAll int y){
        Position same = new Position(x,y);
        Position diff1 = new Position(x+1,y+1);
        Position diff2 = new Position(x-1,y-1);
        Position diff3 = new Position(x+1,y-1);
        Position diff4 = new Position(x-1,y+1);
        Position diff5 = new Position(x,y+1);
        Position diff6 = new Position(x,y-1);
        Position diff7 = new Position(x+1,y);
        Position diff8 = new Position(x-1,y);
        assertEquals(false,same.equals(diff1));
        assertEquals(false,same.equals(diff2));
        assertEquals(false,same.equals(diff3));
        assertEquals(false,same.equals(diff4));
        assertEquals(false,same.equals(diff5));
        assertEquals(false,same.equals(diff6));
        assertEquals(false,same.equals(diff7));
        assertEquals(false,same.equals(diff8));
    }
}