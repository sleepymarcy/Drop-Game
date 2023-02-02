package com.badlogic.drop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class DropGame extends Game {

    // public by default
    SpriteBatch spriteRenderer;
    BitmapFont font;
    ShapeRenderer shapeRenderer;

    public void create() {
        spriteRenderer = new SpriteBatch();
        font = new BitmapFont();
        shapeRenderer = new ShapeRenderer();
        setState(GameState.MAIN_MENU);
    }

    public void render() {
        super.render();
    }

    public void dispose() {
        spriteRenderer.dispose();
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
            case CREDITS:
                this.setScreen(new CreditsScreen(this));
                break;
            case WIN:
                this.setScreen(new WinScreen(this));
                break;
            case LOOSE:
                this.setScreen(new LooseScreen(this));
                break;
            default:
                break;
        }

    }
}
