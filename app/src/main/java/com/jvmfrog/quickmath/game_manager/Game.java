package com.jvmfrog.quickmath.game_manager;

public class Game {

    public static void generateQuestion() {
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

    public static void generateMathExample() {
        int firstNumber = GameManager.getInstance().getFirstNumber();
        int secondNumber = GameManager.getInstance().getSecondNumber();
        String mathExample = firstNumber + " + " + secondNumber + " = ";
        GameManager.getInstance().setMathExample(mathExample);
    }

    public static void checkAnswer(int answer) {
        int correctAnswer = GameManager.getInstance().getAnswer();
        if (answer == correctAnswer) {
            GameManager.getInstance().setScore(GameManager.getInstance().getScore() + 1);
        } else {
            GameManager.getInstance().setLives(GameManager.getInstance().getLives() - 1);
        }
    }
}
