package grillot.amaury;

public class TextDisplayManager {
    private GameData gameData;


    public TextDisplayManager(GameData gameData) {
        this.gameData = gameData;
    }

    public void displayTitle()
    {
        System.out.println("-===========================-");
        System.out.println("=== " + this.gameData.getTitle() + "===");
        System.out.println("-===========================-");
    }

    public void displayWinMessage()
    {
        System.out.println("You found it after " + gameData.getAttempts() + " tries!");
    }

    public void displayWrongGuessMesage(String divergence)
    {
        System.out.print("Wrong! Your number is " + divergence + " than the correct one. ");
        this.displayAttemptsLeft();
    }

    public void displayWrongInputMessage(String input)
    {
        System.out.println("Your input was '" + input + "', please enter a valid integer. ");
        this.displayAttemptsLeft();
    }
    public void displayFirstMessage()
    {
        System.out.println("Guess the number (between 1 and 100)!");

        System.out.println("debug : the expected number is " + gameData.getNumber());
    }
    public void displayGameOverMessage()
    {
        System.out.println("You lose after " + gameData.getMaxAttempts() + " tries, the expected number was " + gameData.getNumber());
    }

    public void displayAttemptsLeft()
    {
        System.out.println(gameData.getAttemptsLeft() + "/" + gameData.getMaxAttempts() + " tries left");
    }

    public void displayReplayMessage()
    {
        System.out.println("----------------------------------------------------");
        System.out.println("Do you want to try again with a new number (yes/no)?");
    }

    public void displayGoodbyeMessage()
    {
        System.out.println("== Thanks for playing! ==");
    }
}
