package com.example.android.math;

import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class GameState {
    protected GameStateManager gsm;
    protected MainMath math;
    protected Stage stage;

    public GameState(GameStateManager gsm) {
        super();
        this.gsm = gsm;
        math = gsm.getMath();
        stage = math.getStage();
    }

    public abstract void update(float dt);

    public abstract void draw();
}
