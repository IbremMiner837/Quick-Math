package com.jvmfrog.quickmath.game_manager;

public class Game {

    public static void generateInts() {
        int difficulty = GameManager.getInstance().getDifficulty();
        int min = 0;
        int max = 0;
        switch (difficulty) {
            case Constants.EASY:
                min = 1;
                max = 10;
                break;
            case Constants.MEDIUM:
                min = 10;
                max = 100;
                break;
            case Constants.HARD:
                min = 100;
                max = 1000;
                break;
            case Constants.EXPERT:
                min = 1000;
                max = 10000;
                break;
        }
        int firstNumber = MathHelper.getRandomInt(min, max);
        int secondNumber = MathHelper.getRandomInt(min, max);
        int answer = firstNumber + secondNumber;
        GameManager.getInstance().setFirstNumber(firstNumber);
        GameManager.getInstance().setSecondNumber(secondNumber);
        GameManager.getInstance().setAnswer(answer);
    }

    public static void generateMathPlusExample() {
        int firstNumber = GameManager.getInstance().getFirstNumber();
        int secondNumber = GameManager.getInstance().getSecondNumber();
        String mathExample = firstNumber + " + " + secondNumber + " = ";
        GameManager.getInstance().setMathExample(mathExample);
    }

    public static void generateMathMinusExample() {
        int firstNumber = GameManager.getInstance().getFirstNumber();
        int secondNumber = GameManager.getInstance().getSecondNumber();
        String mathExample = firstNumber + " - " + secondNumber + " = ";
        GameManager.getInstance().setMathExample(mathExample);
    }

    public static void generateMathMultiplyExample() {
        int firstNumber = GameManager.getInstance().getFirstNumber();
        int secondNumber = GameManager.getInstance().getSecondNumber();
        String mathExample = firstNumber + " * " + secondNumber + " = ";
        GameManager.getInstance().setMathExample(mathExample);
    }

    public static void generateMathDivideExample() {
        int firstNumber = GameManager.getInstance().getFirstNumber();
        int secondNumber = GameManager.getInstance().getSecondNumber();
        String mathExample = firstNumber + " / " + secondNumber + " = ";
        GameManager.getInstance().setMathExample(mathExample);
    }

    public static void generateRandomMathExample() {
        int random = MathHelper.getRandomInt(1, 4);
        switch (random) {
            case 1:
                generateMathPlusExample();
                break;
            case 2:
                generateMathMinusExample();
                break;
            case 3:
                generateMathMultiplyExample();
                break;
            case 4:
                generateMathDivideExample();
                break;
        }
    }

    public static void checkAnswer(int answer) {
        int correctAnswer = GameManager.getInstance().getAnswer();
        if (answer == correctAnswer) {
            GameManager.getInstance().setScore(GameManager.getInstance().getScore() + 1);
            generateRandomMathExample();
        } else {
            GameManager.getInstance().setLives(GameManager.getInstance().getLives() - 1);
            generateRandomMathExample();
        }
    }

    public static void setLevel() {
        int score = GameManager.getInstance().getScore();
        int level = GameManager.getInstance().getLevel();
        if (score == 10) {
            GameManager.getInstance().setLevel(level + 1);
            GameManager.getInstance().setScore(0);
        }
    }

    public static void setDifficulty() {
        int level = GameManager.getInstance().getLevel();
        int difficulty = GameManager.getInstance().getDifficulty();
        if (level == 10) {
            GameManager.getInstance().setDifficulty(difficulty + 1);
        }
    }
}
