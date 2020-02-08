package com.example.android.math;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class MainMath extends ApplicationAdapter {
	private Stage stage;
	private GameStateManager gsm;

	@Override
	public void create() {
		stage = new Stage();
		gsm = new GameStateManager(this);
		Music.load("point","sfx_point.wav");
		Music.load("gameover", "sfx_over.wav");

		HightScoreData.load();
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void resize(int width, int height) {
		//stage.setViewport(320, 480);
		// stage.getViewport().update(width, height);
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.draw();
	}

	public Stage getStage() {
		return stage;
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}
}
