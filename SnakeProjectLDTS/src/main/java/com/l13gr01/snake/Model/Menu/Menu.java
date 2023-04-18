package com.l13gr01.snake.Model.Menu;

import com.l13gr01.snake.Model.Game.Element;

import java.util.Arrays;
import java.util.List;

public class Menu extends Element{
    private final List<String> entries;
    private int currentEntry = 0;

    public Menu() {
        super(10,10);
        this.entries = Arrays.asList("Classic","Rabbits & Rocks", "Two Snakes","Limitless", "Exit");
    }

    public Menu(boolean Menu2) {
        super(10,10);
        this.entries = Arrays.asList("Easy", "Medium","Insane");
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public void setSelected(int i){
        currentEntry = i;
    }

    public boolean isSelectedFirsti() {
        return isSelected(0);
    }

    public boolean isSelectedSecondi() {
        return isSelected(1);
    }

    public boolean isSelectedThirdi() {
        return isSelected(2);
    }

    public boolean isSelectedFourthi() {
        return isSelected(3);
    }
    public boolean isSelectedExit() {
        return isSelected(4);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}