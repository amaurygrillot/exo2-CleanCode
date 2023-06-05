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

            this.gameLoop();

            if (gameData.getNumber() != gameData.getUserGuess()) {
                textDisplayManager.displayGameOverMessage();
            }

            textDisplayManager.displayReplayMessage();
            String userResponse = inputManager.nextLine().trim().toLowerCase();
            continuePlaying = userResponse.equals("yes");
            if (continuePlaying) {
                gameData.setUserGuess(0);
                gameData.setAttempts(0);
            }
        }
    }

    private void gameLoop()
    {
        while (gameData.getNumber() != gameData.getUserGuess() && gameData.getAttempts() < gameData.getMaxAttempts()) {
            String input =  inputManager.nextLine();
            gameData.setAttempts(gameData.getAttempts() + 1);
            try {
                gameData.setUserGuess(Integer.parseInt(input));
                if (gameData.getUserGuess() == gameData.getNumber()) {
                    textDisplayManager.displayWinMessage();
                    break;
                } else {
                    String divergence = gameData.getUserGuess() < gameData.getNumber() ? "smaller" : "greater";
                    textDisplayManager.displayWrongGuessMesage(divergence);
                }
            } catch (NumberFormatException e) {
                textDisplayManager.displayWrongInputMessage(input);
            }
        }
    }
}
