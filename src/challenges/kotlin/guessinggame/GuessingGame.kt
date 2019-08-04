package challenges.kotlin.guessinggame

import java.util.*
import kotlin.math.abs

class GuessingGame {

    private val scanner: Scanner = Scanner(System.`in`)
    private val random: Random = Random()
    private val npcNames = arrayOf("Reinhilde Cadell",
            "Itai Alžběta",
            "Klopas Rhoda",
            "Punit Onyekachi",
            "Dhaval Aoibhinn")
    private val guessQueue = LinkedList<Int>()
    private var numGuesses = 0
    private var randomNum: Int = 0

    fun run() {
        println("Enter your name")
        val name = scanner.nextLine()
        val npcName = randomName()
        randomNum = random.nextInt(99) + 1
        println("Player 1: $name vs Player 2: $npcName")
        guess()
        printResults()
    }

    private fun printResults() {
        println("Number of guesses: $numGuesses")
        println("Last 5 guesses")
        while (guessQueue.isNotEmpty()) {
            print("${guessQueue.poll()} ")
        }
    }

    private fun guess() {
        var notFound = true
        while (notFound) {
            print("Take a guess")
            when (val guess = scanner.nextInt()) {
                randomNum -> {
                    println("You got it")
                    notFound = false
                }
                in abs(randomNum - 5)..abs(randomNum + 5) -> {
                    println("ON FIRE")
                    trackGuesses(guess)
                }
                in abs(randomNum - 10)..abs(randomNum + 10) -> {
                    println("VERY HOT")
                    trackGuesses(guess)
                }
                in abs(randomNum - 20)..abs(randomNum + 20) -> {
                    println(" HOT")
                    trackGuesses(guess)
                }
                in abs(randomNum - 30)..abs(randomNum + 30) -> {
                    println("WARM")
                    trackGuesses(guess)
                }
                else -> {
                    println("Cold")
                    trackGuesses(guess)
                }
            }
        }
    }

    private fun trackGuesses(guess: Int) = if (guessQueue.size == 5) {
        guessQueue.poll()
        guessQueue.add(guess)
        numGuesses++
    } else {
        guessQueue.add(guess)
        numGuesses++
    }


    private fun randomName(): String {
        return npcNames[random.nextInt(npcNames.size)]
    }
}