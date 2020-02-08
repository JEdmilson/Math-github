package com.example.android.math;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.Random;

public class Play extends GameState {
    private Slider slider;
    private Image sai, dung;
    private int soX, soY, soZ, soZchan, phepcong;
    private Label.LabelStyle style;
    private Label noiDung, Score;
    private Random r;
    private boolean nd;
    private int rd;
    public static int HighScore;

    public Play(GameStateManager gsm) {
        super(gsm);
        HighScore = 0;
        nd = true;
        r = new Random();
        style = new Label.LabelStyle();
        style.font = new BitmapFont(Gdx.files.internal("whiteFont.fnt"),
                Gdx.files.internal("whiteFont.png"), false);
        noiDung = new Label("0", style);
        noiDung.setFontScale(4);
        noiDung.setPosition(100,280);
        Score = new Label("0", style);
        Score.setFontScale(2);
        Score.setPosition(100, 520);

        sai = new Image(new Texture(Gdx.files.internal("sai.png")));
        sai.setWidth(150);
        sai.setHeight(150);
        sai.setX(320 - 155);
        sai.setY(5);

        dung = new Image(new Texture(Gdx.files.internal("dung.png")));
        dung.setWidth(150);
        dung.setHeight(150);
        dung.setX(5);
        dung.setY(5);
        noiDung();
        dung.addListener(new ClickListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button) {
                traLoidung();
                return super.touchDown(event, x, y, pointer, button);
            }

        });
        sai.addListener(new ClickListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button) {
                traloiSai();
                return super.touchDown(event, x, y, pointer, button);
            }

        });
        rd = r.nextInt(3);
    }

    @Override
    public void update(float dt) {
        if (slider != null) {
            slider.update();
            if (slider.getIlong() == 0) {
                slider.setRunning(false);
                nd = false;
            }
        }
        if (nd) {
            noiDung.setText(soX + " + " + soY + " = " + soZchan);
        } else {
            stage.clear();
            Music.play("gameover");
            if (HighScore > HightScoreData.getScoreData()) {
                HightScoreData.addScore(HighScore);
            }
            gsm.pusState(2);
        }
        Score.setText("" + HighScore);
    }

    @Override
    public void draw() {
        if (rd == 0) {
            Gdx.gl.glClearColor(0, 1, 0, 1);
        }
        if (rd == 1) {
            Gdx.gl.glClearColor(1, 0, 0, 1);
        }
        if (rd == 2) {
            Gdx.gl.glClearColor(0, 0, 1, 1);
        }
        if (slider != null) {
            stage.addActor(slider.getSlider());
        }
        stage.addActor(sai);
        stage.addActor(dung);
        stage.addActor(noiDung);
        stage.addActor(Score);
    }

    public void noiDung() {
        soX = r.nextInt(6) + 1;
        soY = r.nextInt(6) + 1;
        soZ = r.nextInt(12) + 1;
        phepcong = soX + soY;
        if (soZ % 2 == 0) {
            soZchan = soZ;
        } else {
            soZchan = phepcong;
        }
    }

    public static int getHighScore() {
        return HighScore;
    }

    public void traLoidung() {
        if (slider == null) {
            slider = new Slider();
        }
        if (phepcong == soZchan) {
            HighScore += 1;
            slider.setIlong(300);
            Music.play("point");
            noiDung();
        } else {
            slider = null;
            nd = false;
        }
    }

    public void traloiSai() {
        if (slider == null) {
            slider = new Slider();
        }
        if (phepcong != soZchan) {
            HighScore += 1;
            slider.setIlong(300);
            Music.play("point");
            noiDung();
        } else {
            slider = null;
            nd = false;
        }
    }
}
