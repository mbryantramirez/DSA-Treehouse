package challenges.java.guessinggame;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

class GuessingGame {
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private int randomNum;
    private String[] npcNames = {"Reinhilde Cadell",
            "Itai Alžběta",
            "Klopas Rhoda",
            "Punit Onyekachi",
            "Dhaval Aoibhinn"
    };
    private Queue<Integer> guessQueue;
    private int numGuesses;

    void run() {
        guessQueue = new LinkedList<>();
        System.out.println("Enter your name");
        String name = scanner.nextLine();
        String npcName = randomName();
        randomNum = random.nextInt(99) + 1;
        System.out.println(randomNum);
        System.out.println("Player 1: " + name);
        System.out.println("Player 2: " + npcName);
        guess();
        printResults();
    }

    private void printResults() {
        System.out.println("Number of guesses: " + numGuesses);
        System.out.println("Last 5 guesses");
        while (!guessQueue.isEmpty()) {
            System.out.print(guessQueue.poll() + " ");
        }
    }

    private void guess() {
        boolean notFound = true;
        while (notFound) {
            System.out.println("Take a guess");
            int guess = scanner.nextInt();
            if (guess == randomNum) {
                notFound = false;
                System.out.println("YOU GOT IT");
            } else if (guess >= Math.abs(randomNum - 5) && guess <= Math.abs(randomNum + 5)) {
                System.out.println("ON FIRE");
                addGuess(guess);
            } else if (guess >= Math.abs(randomNum - 10) && guess <= Math.abs(randomNum + 10)) {
                System.out.println("VERY HOT");
                addGuess(guess);
            } else if (guess >= Math.abs(randomNum - 20) && guess <= Math.abs(randomNum + 20)) {
                System.out.println("HOT");
                addGuess(guess);
            } else if (guess >= Math.abs(randomNum - 30) && guess <= Math.abs(randomNum + 30)) {
                System.out.println("WARM");
                addGuess(guess);
            } else {
                System.out.println("COLD");
                addGuess(guess);
            }
        }
    }

    private void addGuess(int guess) {
        if (guessQueue.size() == 5) {
            guessQueue.poll();
            guessQueue.add(guess);
        } else {
            guessQueue.add(guess);
        }
        numGuesses++;
    }

    private String randomName() {
        return npcNames[random.nextInt(npcNames.length)];
    }
}
