package grillot.amaury;

public class GameManager {
    GameData gameData;
    TextDisplayManager textDisplayManager;
    InputManager inputManager;
    public GameManager(GameData gameData, TextDisplayManager textDisplayManager, InputManager inputManager) {
        this.gameData = gameData;
        this.textDisplayManager = textDisplayManager;
        this.inputManager = inputManager;
    }

    public void play()
    {
        this.textDisplayManager.displayTitle();
        this.mainLoop();
        this.textDisplayManager.displayGoodbyeMessage();
        this.inputManager.closeScanner();
    }

    private void mainLoop()
    {
        boolean continuePlaying = true;

        while(continuePlaying) {
            textDisplayManager.displayFirstMessage();

            boolean gameWon = this.gameLoop();

            if (gameWon) {
                textDisplayManager.displayGameWinMessage();
            }
            else
            {
                textDisplayManager.displayGameLostMessage();
            }

            textDisplayManager.displayReplayMessage();
            continuePlaying = replay();
            if (continuePlaying) {
                gameData.resetGame();
            }
        }
    }

    private boolean gameLoop()
    {
        while (gameData.getNumber() != gameData.getUserGuess() && gameData.getAttempts() < gameData.getMaxAttempts()) {
            String input =  inputManager.nextLine();
            gameData.setAttempts(gameData.getAttempts() + 1);
            try {
                gameData.setUserGuess(Integer.parseInt(input));
                if (gameData.getUserGuess() == gameData.getNumber()) {
                    return true;
                }
                else {
                    String divergence = getDivergence();
                    textDisplayManager.displayWrongGuessMesage(divergence);
                }
            } catch (NumberFormatException e) {
                textDisplayManager.displayWrongInputMessage(input);
            }
        }
        return false;
    }

    private String getDivergence()
    {
        return gameData.getUserGuess() < gameData.getNumber() ? "smaller" : "greater";
    }

    private boolean replay()
    {
        String userResponse = inputManager.nextLine().trim().toLowerCase();
        return userResponse.equals("yes");
    }
}
