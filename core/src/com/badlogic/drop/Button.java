package com.badlogic.drop;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Button {
    // ATRYBUTY
    // napis
    String text;
    // prostokąt? - wysokość szerokość, lewy dolny róg
    int x;
    int y;
    int width;
    int height;
    // screen do ktorego kieruje
    GameState targetState;

    final DropGame game;

    // KONSTRUKTOR
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

    // SET
    // ustaw napis (na stale)
    void setText(String text) {
        this.text = text;
    }

    // ustaw lewy dolny róg
    void setBottomLeft(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // ustaw target screen
    void setTargetState(GameState targetState) {
        this.targetState = targetState;
    }

    // GET (tak jakby)
    // narysuj się
    void draw(/* ???????kurwa */) {
        // 1) wypisać tekst
        renderText();
        // 2) narysować prostokąt
        renderRectangle();

        // ShapeRenderer x;
        // SpriteBatch spriteRenderer;
        // BitmapFont font;

        // game.font.draw(game.spriteRenderer, "Drops Lost: " + dropsLost, 0, 460);
        // game.spriteRenderer.draw(bucketImage, bucket.x, bucket.y, bucket.width,
        // bucket.height);
    }

    void renderText() {
        // BitmapFont font = new BitmapFont();
        // SpriteBatch batch = new SpriteBatch();

        BitmapFont font = game.font;
        SpriteBatch batch = game.spriteRenderer;

        batch.begin();
        font.draw(batch, this.text, this.x, this.y + this.height);
        batch.end();
    }

    void renderRectangle() {
        // ShapeRenderer shape = new ShapeRenderer();
        ShapeRenderer shape = game.shapeRenderer;

        shape.begin(ShapeType.Line);
        shape.setColor(Color.CORAL);
        shape.rect(this.x, this.y, this.width, this.height);
        shape.end();
    }
    // wywołaj odpowiedni screen
    // czy zostałem kliknięty?
}
