package com.example.android.math;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Slider {
    private Image slider;
    private int ilong;
    private boolean running;

    public Slider() {
        super();
        running = true;
        ilong = 710;
        slider = new Image(new Texture(Gdx.files.internal("load.png")));
        slider.setX(0);
        slider.setY(1000);
        slider.setWidth(ilong);
    }

    public Image getSlider() {
        return slider;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void update() {
        if (running) {
            ilong -= 2;
            slider.setWidth(ilong);
            slider.invalidate();
            if (ilong < 0) {
                ilong = 700;
            }
        }
    }

    public int getIlong() {
        return ilong;
    }

    public void setIlong(int ilong) {
        this.ilong = ilong;
    }
}
