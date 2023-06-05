package grillot.amaury;

import java.util.Random;

public class RandomGenerator {
    private static Random generator = new Random();

    public static int getRandomNumber(int range)
    {
        return generator.nextInt(range) + 1;
    }
}
