package com.example.android.math;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class GameOverState extends GameState{
    private Label noiDung, Score, BestScore;
    private Label.LabelStyle style;
    private Skin skin;
    private TextButton btn;

    public GameOverState(final GameStateManager gsm) {
        super(gsm);
        skin = new Skin(Gdx.files.internal("uiskin.json"),
                new TextureAtlas(Gdx.files.internal("uiskin.txt")));
        style = new Label.LabelStyle();
        style.font = new BitmapFont(Gdx.files.internal("gamefont.fnt"),
                Gdx.files.internal("gamefont.png"), false);
        noiDung = new Label("GAME OVER", style);
        noiDung.setPosition(60, 300);
        Score = new Label("Score: " + Play.getHighScore(), style);
        Score.setPosition(90, 250);
        BestScore = new Label("Best: " + HightScoreData.getScoreData(), style);
        BestScore.setPosition(90, 200);
        btn = new TextButton("RETRY", skin);
        btn.setBounds(85, 150, 150, 50);
        btn.addListener(new ClickListener(){

            @Override
            public void touchUp(InputEvent event, float x, float y,
                                int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                stage.clear();
                gsm.pusState(1);
            }

        });
    }

    @Override
    public void update(float dt) {
        Gdx.gl.glClearColor(0, 1, 1, 1);
    }

    @Override
    public void draw() {
        stage.addActor(noiDung);
        stage.addActor(Score);
        stage.addActor(BestScore);
        stage.addActor(btn);
    }
}
