package grillot.amaury;

import java.util.Scanner;

public class InputManager {
    private Scanner scanner;
    public InputManager() {
        this.scanner = new Scanner(System.in);
    }

    public String nextLine()
    {
        return this.scanner.nextLine();
    }

    public void closeScanner()
    {
        this.scanner.close();
    }
}
