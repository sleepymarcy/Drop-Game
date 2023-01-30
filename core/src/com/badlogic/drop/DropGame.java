package com.badlogic.drop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DropGame extends Game {

    SpriteBatch batch;
    BitmapFont font;

    public void create() {
        batch = new SpriteBatch();
        // Use LibGDX's default Arial font.
        font = new BitmapFont();
        setState(GameState.MAIN_MENU);
    }

    public void render() {
        // Without this call, the Screen that you set in the create() method will not be
        // rendered if you override the render method in your Game class!
        super.render();
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    public void setState(GameState type) {
        switch (type) {
            case MAIN_MENU:
                this.setScreen(new MainMenuScreen(this));
                break;
            case GAME:
                this.setScreen(new GameScreen(this));
                break;
            default:
                break;
        }

    }
}
