package com.badlogic.drop.gui;

import com.badlogic.drop.DropGame;
import com.badlogic.drop.GameState;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

public class Button {
    String text;
    int x;
    int y;
    int width;
    int height;
    GameState targetState;
    final DropGame game;
    private Rectangle frame;

    private boolean isActive = false;

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

        frame = new Rectangle(x - 10.0f, y - 10.0f, width + 40.0f, height + 20.0f);
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

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void draw() {
        renderText();
        if (isActive)
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
        // if (isMouseOver()) {
        game.shapeRenderer.setColor(Color.WHITE);
        // }
        game.shapeRenderer.rect(frame.x, frame.y, frame.width, frame.height);

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
        return frame.contains(
                Gdx.input.getX(),
                (float) game.viewportHeight - Gdx.input.getY());
    }
}
