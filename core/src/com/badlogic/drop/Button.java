package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
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

    void setText(String text) {
        this.text = text;
    }

    void setBottomLeft(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void setTargetState(GameState targetState) {
        this.targetState = targetState;
    }

    void draw() {
        renderText();
        renderRectangle();
    }

    void renderText() {
        BitmapFont font = game.font;
        font.getData().setScale(1.4f, 1.4f);
        SpriteBatch spriteRenderer = game.spriteRenderer;

        spriteRenderer.begin();
        font.draw(spriteRenderer, this.text, this.x, this.y + this.height);
        spriteRenderer.end();
    }

    void renderRectangle() {
        ShapeRenderer shapeRenderer = game.shapeRenderer;

        shapeRenderer.begin(ShapeType.Line);
        shapeRenderer.setColor(0, 0, 0.2f, 1);
        shapeRenderer.rect(this.x - 10, this.y - 10, this.width + 40, this.height + 20);
        shapeRenderer.end();
    }

    private void changeToTargetState() {
        game.setState(targetState);
    }

    // czy zostałem kliknięty?
    void clickHandler() {
        int inputX = Gdx.input.getX();
        int inputY = 480 - Gdx.input.getY();

        if (inputX >= x - 10 && inputX - 10 <= x - 10 + width + 40 && inputY - 10 >= y - 10 && inputY - 10 <= y - 10 + height + 20
                &&
                Gdx.input.isButtonPressed(Buttons.LEFT)) {
            changeToTargetState();
        }
    }
}
