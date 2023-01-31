package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Input.Keys;

public class MainMenuScreen implements Screen {
    final DropGame game;

    OrthographicCamera camera;

    // The Screen interface does not provide any sort of create() method,
    // so we instead use a constructor

    public MainMenuScreen(final DropGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "Welcome to Drop!!!", 200, 400);
        game.font.draw(game.batch, "Press 1 to start the game;", 200, 350);
        game.font.draw(game.batch, "Press 2 to see credits;", 200, 300);
        game.font.draw(game.batch, "Press escape to exit;", 200, 250);
        game.font.draw(game.batch, "Press tab to open menu;", 200, 200);
        game.batch.end();

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

        if (Gdx.input.isKeyPressed(Keys.TAB)) {
            game.setState(GameState.MAIN_MENU);
            dispose();
        }

        // if (Gdx.input.isTouched()) {
        // game.setState(GameState.GAME);
        // dispose();
        // }
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