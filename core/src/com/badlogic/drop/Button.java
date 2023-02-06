package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Button {
    String text;
    int x;
    int y;
    int width;
    int height;
    GameState targetState;
    final DropGame game;

    public Button(DropGame game, int x, int y, String text, GameState targetState) {
        this.game = game;
        setText(text);
        setBottomLeft(x, y);
        setTargetState(targetState);

        GlyphLayout layout;
        layout = new GlyphLayout();
        layout.setText(game.font, this.text);
        width = (int) layout.width;
        height = (int) layout.height;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setBottomLeft(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setTargetState(GameState targetState) {
        this.targetState = targetState;
    }

    public void draw() {
        renderText();
        renderRectangle();
    }

    private void renderText() {        
        game.font.getData().setScale(1.4f, 1.4f);        

        game.spriteRenderer.begin();
        game.font.draw(game.spriteRenderer, this.text, this.x, this.y + this.height);
        game.spriteRenderer.end();
    }

    private void renderRectangle() {
        game.shapeRenderer.begin(ShapeType.Line);
        game.shapeRenderer.setColor(0, 0, 0.2f, 1);
        if (isMouseOver()) {
            game.shapeRenderer.setColor(Color.WHITE);
        }
        game.shapeRenderer.rect(this.x - 10, this.y - 10, this.width + 40, this.height + 20);

        game.shapeRenderer.end();
    }

    private void changeToTargetState() {
        game.setState(targetState);
    }

    // czy zostałem kliknięty?
    public void handleClick() {
        if (isMouseOver()
                &&
                Gdx.input.isButtonPressed(Buttons.LEFT)) {
            changeToTargetState();
        }
    }

    boolean isMouseOver() {
        int inputX = Gdx.input.getX();
        int inputY = 480 - Gdx.input.getY();

        return inputX >= x - 10 && inputX - 10 <= x - 10 + width + 40 && inputY - 10 >= y - 10
                && inputY - 10 <= y - 10 + height + 20;
    }
}
