package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Input.Keys;

public class WinScreen implements Screen {

    final DropGame game;
    OrthographicCamera camera;

    public WinScreen(final DropGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        game.spriteRenderer.setProjectionMatrix(camera.combined);

        game.spriteRenderer.begin();
        game.font.draw(game.spriteRenderer, "CONGRATULATIONS", 100, 200);
        game.font.draw(game.spriteRenderer, "YOU'VE WON THE GAME", 100, 180);
        game.font.draw(game.spriteRenderer, "Press escape to open the menu.", 100, 140);
        game.spriteRenderer.end();

        if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
            game.setState(GameState.MAIN_MENU);
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}
