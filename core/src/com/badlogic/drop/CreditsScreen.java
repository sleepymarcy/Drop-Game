package com.badlogic.drop;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;

public class CreditsScreen implements Screen {

    final DropGame game;

    OrthographicCamera camera;

    public CreditsScreen(final DropGame game) {
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
        game.font.draw(game.batch, "Credits:", 100, 150);
        game.font.draw(game.batch, "Creators and contributors of LibGDX;", 100, 130);
        game.font.draw(game.batch, "Bartosz \"Suap\" Slapa", 100, 110);
        game.font.draw(game.batch, "Martyna \"SleepyMarcy\" Sowinska", 100, 90);
        game.batch.end();
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
