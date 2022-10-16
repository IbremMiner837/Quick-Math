package com.jvmfrog.quickmath.game_manager;

public class GameManager {

    private static GameManager instance = null;

    private int score;
    private int lives;
    private int level;
    private int difficulty;
    private int firstNumber;
    private int secondNumber;
    private int answer;
    private String mathExample;

    public static GameManager getInstance() {
        Object obj = new Object();
        synchronized (obj) {
            if (instance == null) {
                synchronized (obj) {
                    instance = new GameManager();
                }
            }
        }
        return instance;
    }

    private GameManager() {
        score = 0;
        lives = 3;
        level = 1;
        difficulty = 0;
        firstNumber = 0;
        secondNumber = 0;
        answer = 0;
        mathExample = "";
    }

    private void reset() {
        score = 0;
        lives = 3;
        level = 1;
        difficulty = 0;
        firstNumber = 0;
        secondNumber = 0;
        answer = 0;
        mathExample = "";
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getMathExample() {
        return mathExample;
    }

    public void setMathExample(String mathExample) {
        this.mathExample = mathExample;
    }
}
