package com.mygdx.gameworld;

public class GameWorld {

    private int score = 0;

    private float runTime = 0; // runTime lleva la cuenta del tiempo que un objeto lleva en una animación determinada

    private GameState currentState;
    public enum GameState{
        READY, RUNNING, GAMEOVER, HIGHSCORE
    }

    public GameWorld(){
        currentState = GameState.READY;
    }

    public void update(float delta){
        runTime += delta;

        switch (currentState) {
            case READY:
            case RUNNING:
            case GAMEOVER:
            case HIGHSCORE:
            default:
                break;
        }
    }

    public boolean isReady() {
        return currentState == GameState.READY;
    }

    public boolean isGameOver() {
        return currentState == GameState.GAMEOVER;
    }

    public boolean isRunning() {
        return currentState == GameState.RUNNING;
    }

    public boolean isHighScore() {
        return currentState == GameState.HIGHSCORE;
    }

    public void start() {
        currentState = GameState.RUNNING;
    }
}
