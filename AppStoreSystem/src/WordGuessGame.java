import java.util.Scanner;

class WordGuessGame {
    Scanner sc = new Scanner(System.in);

    String[] words = {
            "APPLE", "BREAD", "CHAIR", "DANCE", "EARTH", "FLAME", "GRAPE", "HEART",
            "IGLOO", "JELLY", "KNIFE", "LEMON", "MONEY", "NIGHT", "OCEAN", "PIANO",
            "QUEEN", "RIVER", "SMILE", "TABLE", "UMBRA", "VOICE", "WATER", "XENON",
            "YACHT", "ZEBRA", "BEACH", "CLOUD", "DRINK", "FLOWER", "GHOST", "HOUSE",
            "IMAGE", "JOKER", "KITTY", "LIGHT", "MUSIC", "NOVEL", "ORBIT", "PEARL",
            "QUIET", "ROBOT", "SHARP", "TIGER", "UNITY", "VIRUS", "WHALE", "YOUTH",
            "ZESTY", "PLANT"
    };

    int play(String playerName) {
        int randomIndex = (int)(Math.random() * 50);
        String secretWord = words[randomIndex];

        int attemptsLeft = 10;
        boolean guessed = false;

        System.out.println("\n" + playerName + "'s Turn");
        System.out.println("Guess the 5-letter word");
        System.out.println("You have 10 attempts\n");

        while (attemptsLeft > 0 && !guessed) {
            System.out.println("Attempts left: " + attemptsLeft);
            System.out.print("Enter guess: ");
            String guess = sc.next().toUpperCase();

            if (guess.length() != 5) {
                System.out.println("ERROR: Enter ONLY 5-letter word!\n");
                continue;
            }

            attemptsLeft--;
            guessed = checkGuess(secretWord, guess);

            if (guessed) {
                System.out.println("Correct! Word guessed.");
                return 10 - attemptsLeft;
            }
        }

        System.out.println("No attempts left!");
        System.out.println("Correct word was: " + secretWord);
        return 10;
    }

    boolean checkGuess(String secret, String guess) {
        char[] result = {'-', '-', '-', '-', '-'};
        boolean correct = true;

        for (int i = 0; i < 5; i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                result[i] = guess.charAt(i);
            } else {
                correct = false;
            }
        }

        System.out.print("Result: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(result[i]);
        }
        System.out.println();

        for (int i = 0; i < 5; i++) {
            char g = guess.charAt(i);
            if (guess.charAt(i) != secret.charAt(i) && secret.indexOf(g) != -1) {
                System.out.println(g + " -> correct letter but wrong position");
            }
        }
        System.out.println();

        return correct;
    }
}



