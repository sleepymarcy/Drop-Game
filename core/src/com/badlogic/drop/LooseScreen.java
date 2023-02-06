package com.badlogic.drop;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;

public class LooseScreen implements Screen {

    final DropGame game;
    OrthographicCamera camera;
    Button exitButton;

    public LooseScreen(final DropGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        exitButton = new Button(game, 100, 120, "Back to the menu", GameState.MAIN_MENU);
    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        game.spriteRenderer.setProjectionMatrix(camera.combined);

        game.spriteRenderer.begin();
        game.font.draw(game.spriteRenderer, "YOU'VE LOST!!!", 100, 200);
        game.spriteRenderer.end();
        exitButton.draw();
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
