package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Input.Keys;

public class MainMenuScreen implements Screen {

    final DropGame game;
    OrthographicCamera camera;

    public MainMenuScreen(final DropGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        game.spriteRenderer.setProjectionMatrix(camera.combined);

        if (Gdx.input.isKeyPressed(Keys.NUM_1)) {
            game.setState(GameState.GAME);
            dispose();
        }

        if (Gdx.input.isKeyPressed(Keys.NUM_2)) {
            game.setState(GameState.CREDITS);
            dispose();
        }

        if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
            Gdx.app.exit();
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