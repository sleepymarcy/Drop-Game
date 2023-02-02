package com.badlogic.drop;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;

public class CreditsScreen implements Screen {

    private static final int SCROLL_SPEED = 160;

    final DropGame game;
    OrthographicCamera camera;
    private int y;

    public CreditsScreen(final DropGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        this.y = 0;
    }

    @Override
    public void render(float delta) {
        this.y += SCROLL_SPEED * delta;

        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "Credits:", 100, 0 + this.y);
        game.font.draw(game.batch, "Creators and contributors of LibGDX;", 100, -20 + this.y);
        game.font.draw(game.batch, "Coding: Martyna \"SleepyMarcy\", Sowinska", 100, -40 + this.y);

        game.font.draw(game.batch, "Coached by: Bartosz \"Suap\" Slapa", 100, -80 + this.y);

        game.batch.end();

        if (y - 80 >= 480 + 30) {
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
