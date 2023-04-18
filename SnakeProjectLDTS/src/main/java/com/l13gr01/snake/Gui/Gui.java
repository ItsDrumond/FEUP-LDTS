package com.l13gr01.snake.Gui;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.l13gr01.snake.Action;
import com.l13gr01.snake.Model.Game.*;
import com.l13gr01.snake.Model.Position;
import com.l13gr01.snake.Model.Menu.Menu;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Gui implements GuiInterface{
    private Screen screen;
    private TextGraphics tg;
    private final int terminalSizeCol = 22;
    private final int terminalSizeRows = 23;

    public Gui() throws URISyntaxException, IOException, FontFormatException {
        screen = createScreen(createTerminal(loadSquareFont()));
        tg = screen.newTextGraphics();
    }
    public Gui(Screen screen) throws URISyntaxException, IOException, FontFormatException {
        this.screen = screen;
        tg = screen.newTextGraphics();
    }

    public Screen createScreen(Terminal terminal) throws IOException{
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    public Terminal createTerminal(AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(terminalSizeCol,terminalSizeRows);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal;
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        terminal = terminalFactory.createTerminal();
        return terminal;
    }

    public AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 15);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    @Override
    public Action getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return Action.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return Action.EOF;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return Action.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return Action.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return Action.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return Action.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return Action.LEFT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'g') return Action.GROW;

        if (keyStroke.getKeyType() == KeyType.Enter) return Action.SELECT;

        return Action.NONE;
    }

    @Override
    public void drawText(int col, int row, String color, String text, boolean default_color){
       if(!default_color){
           tg.setForegroundColor(TextColor.Factory.fromString(color));
       }
       else{
           tg.setBackgroundColor(TextColor.Factory.fromString("#13D700"));
           tg.setForegroundColor(TextColor.Factory.fromString("#000000"));
       }
       tg.putString(col,row,text);
   }

    @Override
    public void drawMenu(Menu menu) {
        tg.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        String sub = "Serpent";
        tg.putString(7,6,sub);

        for (int j = 0; j < menu.getNumberEntries(); j++) {
            String str = menu.getEntry(j);
            if(menu.isSelected(j)){
                tg.setForegroundColor(TextColor.Factory.fromString("#FFD700"));
            } else {
                tg.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
            }
            tg.putString(5,j+10, str);
        }
    }

    @Override
    public void drawStage(Stage stage){
        tg.setBackgroundColor(TextColor.Factory.fromString("#13D700"));
        tg.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(stage.getWidth(), stage.getHeight()), ' ');
    }

    @Override
    public void drawWall(Wall wall){
        tg.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        tg.fillRectangle(new TerminalPosition(wall.getX(), wall.getY()), new TerminalSize(1, 1), ' ');
    }

    @Override
    public void drawSnake(Snake snake){
        tg.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        for(Position body_piece : snake.getBody()){
            tg.fillRectangle(new TerminalPosition(body_piece.getX(), body_piece.getY()), new TerminalSize(1, 1), ' ');
        }
    }

    @Override
    public void drawRock(Rock rock){
        tg.setBackgroundColor(TextColor.Factory.fromString("#808080"));
        tg.fillRectangle(new TerminalPosition(rock.getX(), rock.getY()), new TerminalSize(1,1), ' ');
    }

    @Override
    public void drawFruit(Fruit fruit){
        tg.setBackgroundColor(TextColor.Factory.fromString("#FF0000"));
        tg.fillRectangle(new TerminalPosition(fruit.getX(), fruit.getY()), new TerminalSize(1, 1), ' ');
    }

    @Override
    public void drawRabbit(Rabbit rabbit){
        tg.setBackgroundColor(TextColor.Factory.fromString("#0000FF"));
        tg.fillRectangle(new TerminalPosition(rabbit.getX(), rabbit.getY()), new TerminalSize(1, 1), ' ');
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.stopScreen();
    }

    @Override
    public void clear() {
        screen.clear();
    }
}
