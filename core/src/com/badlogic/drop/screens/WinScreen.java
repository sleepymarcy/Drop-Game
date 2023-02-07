package com.badlogic.drop.screens;

import com.badlogic.drop.DropGame;
import com.badlogic.drop.GameState;
import com.badlogic.drop.gui.Button;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;

public class WinScreen implements Screen {

    final DropGame game;
    OrthographicCamera camera;
    Button exitButton;

    public WinScreen(final DropGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, game.viewportWidth, game.viewportHeight);

        exitButton = new Button(game, 100, 120, "Back to the menu", GameState.MAIN_MENU);
    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        game.spriteRenderer.setProjectionMatrix(camera.combined);

        game.spriteRenderer.begin();
        game.font.draw(game.spriteRenderer, "CONGRATULATIONS", 100, 200);
        game.font.draw(game.spriteRenderer, "YOU'VE WON THE GAME", 100, 180);
        game.spriteRenderer.end();
        exitButton.draw();
        exitButton.handleClick();
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
