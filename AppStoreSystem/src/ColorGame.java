import java.util.Scanner;

class ColorGame {
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";

    static String[] colorNames = {"RED", "GREEN", "YELLOW", "BLUE"};
    static String[] colorCodes = {RED, GREEN, YELLOW, BLUE};

    Scanner sc = new Scanner(System.in);

    int play(String playerName) {
        int score = 0;
        long startTime = System.currentTimeMillis();
        long timeLimit = 20000;

        System.out.println("\n" + playerName + "'s turn starts!");
        System.out.println("You have 20 seconds. GO!");

        while (System.currentTimeMillis() - startTime < timeLimit) {
            int wordIndex = (int)(Math.random() * colorNames.length);
            int colorIndex = (int)(Math.random() * colorCodes.length);

            System.out.println(colorCodes[colorIndex] + colorNames[wordIndex] + RESET);
            System.out.print("Answer: ");

            String answer = sc.next().toUpperCase();

            if (answer.equals(colorNames[colorIndex])) {
                score++;
                System.out.println("Correct\n");
            } else {
                System.out.println("Wrong\n");
            }
        }

        System.out.println("Time Over for " + playerName);
        System.out.println(playerName + "'s Score: " + score);
        return score;
    }
}
