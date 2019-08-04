package challenges.java.guessinggame;

public class Main {

    /// 1. Prompt Player for thier name.
/// 2. Select a random name for the NPC
/// 3. Generate a random number between 1 & 100
/// 4. Prompt player for a guess.
/// 5. If guess is:
///    1. Within 5, print 'ON FIRE!!!'
///    2. Within 10, print 'VERY HOT'
///    3. Within 20, print 'Hot!'
///    4. Within 30, print 'Warm'
///    5. Otherwise print 'Cold...'
/// 6. When the player guesses the number:
///    1. Print 'You got it!'
///    2. Print the number of attempts it took to get a right answer.
///    3. Print the last 5 guesses, excluding the corrent answer.

    public static void main(String[] args) {
        GuessingGame guessingGame = new GuessingGame();
        guessingGame.run();
    }
}
