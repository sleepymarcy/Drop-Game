package com.badlogic.drop;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Button {

    final DropGame game;
    OrthographicCamera camera;

    BitmapFont some;
    Rectangle frame;
    GlyphLayout layout;
    int x, y;
    float width, height;

    public Button(final DropGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        some = new BitmapFont();

        layout = new GlyphLayout();
        layout.setText(some, "Credits");
        
        frame = new Rectangle();
        frame.x = x;
        frame.y = y;
        frame.width = layout.width;
        frame.height = layout.height;
    }
}


// game.spriteRenderer.begin();

// game.font.draw(game.spriteRenderer, "Welcome to Drop!!!", 200, 400);
// game.font.draw(game.spriteRenderer, "Start", x = 200, y = 350);
// game.font.draw(game.spriteRenderer, "Credits", 200, 300);
// game.font.draw(game.spriteRenderer, "Exit", 200, 250);

// game.shapeRenderer.begin(ShapeType.Line);
// game.shapeRenderer.setColor(Color.RED);

// game.shapeRenderer.rect(x, y - text.height, text.width, text.height);        
// game.shapeRenderer.rect(x, y - text.height - 50, text.width, text.height);
// game.shapeRenderer.rect(x, y - text.height - 100, text.width, text.height);

// game.spriteRenderer.end();
// game.shapeRenderer.end();

// if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {            
//     game.setState(GameState.GAME);
//     dispose();
// }
