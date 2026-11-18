import java.util.Scanner;

class GuessTheNumberGame {
    int num;
    int maxattempts;

    public GuessTheNumberGame(int maxattempts) {
        this.maxattempts = maxattempts;
        num = (int) (Math.random() * 100) + 1;
    }

    public void startGame() {
        Scanner sc = new Scanner(System.in);
        int attempts = 0;

        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("I have chosen a number between 1 and 100.");
        System.out.println("You have " + maxattempts + " attempts to guess it.");

        while (attempts < maxattempts) {
            System.out.print("Enter your guess: ");

            int guess = 0;
            boolean validInput = false;

            if (sc.hasNextInt()) {
                guess = sc.nextInt();
                validInput = true;
            } else {
                System.out.println("Invalid input! Please enter a number between 1-100.");
                sc.next();
                continue;
            }

            if (!validInput) {
                continue;
            }

            attempts++;

            if (guess == num) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts!");
                return;
            } else if (guess < num) {
                System.out.println("Too low! Try a higher number.");
            } else {
                System.out.println("Too high! Try a lower number.");
            }
        }

        System.out.println("Sorry! You ran out of attempts. The number was: " + num);
    }
}
