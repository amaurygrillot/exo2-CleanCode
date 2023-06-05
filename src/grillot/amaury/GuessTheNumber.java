package grillot.amaury;

import java.util.Scanner;
import java.util.Random;


public class GuessTheNumber {

    public static void main(String[] args) {
        GameData gameData = new GameData(10, "GUESS THE NUMBER GAME");
        TextDisplayManager textDisplayManager = new TextDisplayManager(gameData);
        InputManager inputManager = new InputManager();
        GameManager gameManager = new GameManager(gameData, textDisplayManager, inputManager);
        gameManager.play();
    }
}
