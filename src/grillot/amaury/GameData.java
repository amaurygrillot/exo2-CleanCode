package grillot.amaury;

public class GameData {
    private int userGuess = 0;
    private int attempts = 0;
    private int maxAttempts = 10;
    private String title;
    private int number;

    public GameData(int maxAttempts, String title) {
        this.userGuess = 0;
        this.attempts = 0;
        this.maxAttempts = maxAttempts;
        this.title = title;
        number = RandomGenerator.getRandomNumber(100);
    }

    public int getAttemptsLeft()
    {
        return this.maxAttempts - this.attempts;
    }

    public String getTitle (){
        return this.title;
    }

    public int getUserGuess() {
        return userGuess;
    }

    public void setUserGuess(int userGuess) {
        this.userGuess = userGuess;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public void setMaxAttempts(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void resetGame() {
        this.userGuess = 0;
        this.attempts = 0;
        this.number = RandomGenerator.getRandomNumber(100);
    }
}
