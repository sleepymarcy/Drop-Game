package com.badlogic.drop;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen implements Screen {

    final DropGame game;
    OrthographicCamera camera;
    Button startButton;
    Button creditsButton;
    Button exitButton;

    public MainMenuScreen(final DropGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        startButton = new Button(game, 300, 300, "Start", GameState.GAME);
        creditsButton = new Button(game, 300, 250, "Credits", GameState.CREDITS);
        exitButton = new Button(game, 300, 200, "Exit", GameState.EXIT);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        game.spriteRenderer.setProjectionMatrix(camera.combined);
        game.shapeRenderer.setProjectionMatrix(camera.combined);

        startButton.draw();
        creditsButton.draw();
        exitButton.draw();
        startButton.clickHandler();
        creditsButton.clickHandler();
        exitButton.clickHandler();
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