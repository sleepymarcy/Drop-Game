package com.badlogic.drop.gui;

import com.badlogic.drop.DropGame;
import com.badlogic.drop.GameState;
import com.badlogic.gdx.utils.Array;

public class Menu {
    private final Array<Button> buttonsArray;
    private final int nrOfButtons;
    int activeButton;

    DropGame game;

    int x;
    int y;
    int deltaY;

    public Menu(DropGame game, int nrOfButtons, int x, int y, int deltaY) {
        this.nrOfButtons = nrOfButtons;
        buttonsArray = new Array<>(true, nrOfButtons);

        this.game = game;

        this.x = x;
        this.y = y;
        this.deltaY = deltaY;
    }

    public void addButton(int index, Button button) {
        buttonsArray.insert(index, button);
    }

    public void addButton(int index, String text, GameState targetState) {
        addButton(index,
                new Button(game, x, y + index * deltaY, text, targetState));

    }

    public boolean setActive(int buttonNumber) {
        if (buttonNumber < nrOfButtons) {
            activeButton = buttonNumber;
            return true;
        } else
            return false;
    }

    public void update() {
        for (int i = 0; i < nrOfButtons; i++) {
            buttonsArray.get(i).setActive(false);

            if (buttonsArray.get(i).isMouseOver()) {
                activeButton = i;
                buttonsArray.get(i).handleClick();
            }
        }
        buttonsArray.get(activeButton).setActive(true);
    }

    public void draw() {
        for (Button b : buttonsArray) {
            b.draw();
        }
    }
}
