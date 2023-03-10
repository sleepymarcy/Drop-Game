package com.badlogic.drop.screens;

import java.util.Iterator;

import com.badlogic.drop.DropGame;
import com.badlogic.drop.GameState;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class GameScreen implements Screen {
	final DropGame game;

	Texture dropImage;
	Texture bucketImage;
	Sound dropSound;
	Music rainMusic;
	OrthographicCamera camera;
	Rectangle bucket;
	Array<Rectangle> raindrops;
	long lastDropTime;
	int dropsGathered;
	int dropsLost;

	// constructor
	public GameScreen(final DropGame game) {
		this.game = game;

		dropImage = new Texture(Gdx.files.internal("droplet.png"));
		bucketImage = new Texture(Gdx.files.internal("bucket.png"));

		dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
		rainMusic.setLooping(true);

		camera = new OrthographicCamera();
        camera.setToOrtho(false, game.viewportWidth, game.viewportHeight);

		bucket = new Rectangle();
		bucket.x = game.viewportWidth / 2 - 64 / 2;
		bucket.y = 20;
		bucket.width = 64;
		bucket.height = 64;

		// create the raindrops array and spawn the first raindrop
		raindrops = new Array<Rectangle>();
		spawnRaindrop();

	}

	private void spawnRaindrop() {
		Rectangle raindrop = new Rectangle();
		raindrop.x = MathUtils.random(0, game.viewportWidth - 64);
		raindrop.y = game.viewportHeight;
		raindrop.width = 64;
		raindrop.height = 64;
		raindrops.add(raindrop);
		lastDropTime = TimeUtils.nanoTime();
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);

		camera.update();

		game.spriteRenderer.setProjectionMatrix(camera.combined);

		game.spriteRenderer.begin();
		game.font.draw(game.spriteRenderer, "Drops Collected: " + dropsGathered, 0, game.viewportHeight);
		game.font.draw(game.spriteRenderer, "Drops Lost: " + dropsLost, 0, game.viewportHeight - 20);

		game.spriteRenderer.draw(bucketImage, bucket.x, bucket.y, bucket.width, bucket.height);
		for (Rectangle raindrop : raindrops) {
			game.spriteRenderer.draw(dropImage, raindrop.x, raindrop.y);
		}
		game.spriteRenderer.end();

		// process user input
		if (Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			bucket.x = touchPos.x - 64 / 2;
		}
		if (Gdx.input.isKeyPressed(Keys.LEFT))
			bucket.x -= 200 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Keys.RIGHT))
			bucket.x += 200 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
			game.setState(GameState.MAIN_MENU);
			dispose();
		}

		if (bucket.x < 0)
			bucket.x = 0;
		if (bucket.x > game.viewportWidth - 64)
			bucket.x = game.viewportWidth - 64;

		// check if we need to create a new raindrop
		if (TimeUtils.nanoTime() - lastDropTime > 1000000000)
			spawnRaindrop();

		// move the raindrops, remove any that are beneath the bottom edge of
		// the screen or that hit the bucket. In the later case we increase the
		// value our drops counter and add a sound effect.
		Iterator<Rectangle> iter = raindrops.iterator();
		while (iter.hasNext()) {
			Rectangle raindrop = iter.next();
			raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
			if (raindrop.y + 64 < 0) {
				dropsLost++;
				iter.remove();
			}
			if (raindrop.overlaps(bucket)) {
				dropsGathered++;
				dropSound.play();
				iter.remove();
			}
		}

		if (dropsGathered >= 5) {
			game.setState(GameState.WIN);
			dispose();
		}

		if (dropsLost >= 5) {
			game.setState(GameState.LOOSE);
			dispose();
		}

	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		rainMusic.play();
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
		dropImage.dispose();
		bucketImage.dispose();
		dropSound.dispose();
		rainMusic.dispose();
	}

}