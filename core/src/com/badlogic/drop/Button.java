package com.badlogic.drop;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.graphics.Color;
public class Button {

    final DropGame game;
    OrthographicCamera camera;

    BitmapFont some;
    Rectangle frame;
    GlyphLayout layout;
    int x, y;
    float width, height;
    String text;

    public Button(final DropGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        some = new BitmapFont();

        layout = new GlyphLayout();
        layout.setText(some, "Credits");

        frame = new Rectangle();
        frame.x = 200;
        frame.y = 350;
        frame.width = layout.width;
        frame.height = layout.height;
    }
    

    public void drawingEvent(){

        game.spriteRenderer.begin();         
        game.font.draw(game.spriteRenderer, text, x, y);

        game.shapeRenderer.begin(ShapeType.Line);
        game.shapeRenderer.setColor(Color.RED);
        game.shapeRenderer.rect(x, y - frame.height, frame.width, frame.height);

        game.spriteRenderer.end();
        game.shapeRenderer.end();
    }
}

// if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
// game.setState(GameState.GAME);
// dispose();
// }
