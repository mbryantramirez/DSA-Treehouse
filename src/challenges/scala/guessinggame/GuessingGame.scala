package challenges.scala.guessinggame

import scala.collection.mutable
import scala.io.StdIn
import scala.util.Random

class GuessingGame {
  val random: Random.type = scala.util.Random
  val scanner: StdIn.type = StdIn
  val npcNames = Array("Reinhilde Cadell",
    "Itai Alžběta",
    "Klopas Rhoda",
    "Punit Onyekachi",
    "Dhaval Aoibhinn")
  var guessQueue: mutable.Queue[Int] = mutable.Queue[Int]()
  var numGuesses: Int = 0

  def run(): Unit = {
    println("Enter your name")
    val name = scanner.readLine()
    val npcName = randomName()
    println(s"Player 1: $name vs Player 2: $npcName")
    val randomNum = random.nextInt(99) + 1
    guess(randomNum)
    printResults()
  }

  def guess(randomNum: Int): Unit = {
    var notFound = true
    while (notFound) {
      println("Take a guess")
      val guess: Int = scanner.readInt()
      guess match {
        case `randomNum` =>
          println("You got it")
          notFound = false
        case x if (randomNum - 5).abs to (randomNum + 5).abs contains x =>
          println("ON FIRE")
          trackGuesses(x)
        case x if (randomNum - 10).abs to (randomNum + 10).abs contains x =>
          println("VERY HOT")
          trackGuesses(x)
        case x if (randomNum - 20).abs to (randomNum + 20).abs contains x =>
          println("HOT")
          trackGuesses(x)
        case x if (randomNum - 30).abs to (randomNum + 30).abs contains x =>
          println("WARM")
          trackGuesses(x)
        case _ =>
          println("COLD")
          trackGuesses(guess)
      }
    }
  }

  def printResults(): Unit = {
    println(s"Number of Guesses: $numGuesses")
    println("Last 5 guesses")
    while (guessQueue.nonEmpty) {
      print(s"${guessQueue.dequeue()} ")
    }
  }

  def trackGuesses(guess: Int): Unit = if (guessQueue.size == 5) {
    guessQueue.dequeue()
    guessQueue.enqueue(guess)
    numGuesses += 1
  } else {
    guessQueue.enqueue(guess)
    numGuesses += 1
  }

  def randomName(): String = {
    npcNames(random.nextInt(npcNames.length))
  }
}
