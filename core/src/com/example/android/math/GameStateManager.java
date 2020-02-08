package com.example.android.math;

import java.util.Stack;

public class GameStateManager {
    private MainMath math;
    private Stack<GameState> gameStates;
    public static final int Play = 1;
    public static final int GAMEOVER = 2;

    public GameStateManager(MainMath math) {
        super();
        this.math = math;
        gameStates = new Stack<GameState>();
        pusState(Play);
    }

    public MainMath getMath() {
        return math;
    }

    public void update(float dt) {
        gameStates.peek().update(dt);
    }

    public void draw() {
        gameStates.peek().draw();
    }

    public GameState setstate(int state) {
        if (state == Play) {
            return new Play(this);
        } else if (state == GAMEOVER) {
            return new GameOverState(this);
        } else {
            return null;
        }
    }

    public void pusState(int state) {
        gameStates.push(setstate(state));
    }
}
