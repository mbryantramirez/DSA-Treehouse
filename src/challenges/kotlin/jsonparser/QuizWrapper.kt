package challenges.kotlin.jsonparser

import com.squareup.moshi.Json

data class QuizWrapper(
        @Json(name = "quiz")
        val quiz: Quiz
)

data class Quiz(
        @Json(name = "sport")
        val sport: Sport,
        @Json(name = "maths")
        val maths: Maths
)

data class Sport(
        @Json(name = "q1")
        val q1: Q1)

data class Maths(
        @Json(name = "q1")
        val q1: Q1,
        @Json(name = "q2")
        val q2: Q2)

data class Q2(
        @Json(name = "question")
        val question: String,
        @Json(name = "options")
        val options: Array<String>,
        @Json(name = "answer")
        val answer: String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Q2

        if (question != other.question) return false
        if (!options.contentEquals(other.options)) return false
        if (answer != other.answer) return false

        return true
    }

    override fun hashCode(): Int {
        var result = question.hashCode()
        result = 31 * result + options.contentHashCode()
        result = 31 * result + answer.hashCode()
        return result
    }
}


data class Q1(
        @Json(name = "question")
        val question: String,
        @Json(name = "options")
        val options: Array<String>,
        @Json(name = "answer")
        val answer: String) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Q1

        if (question != other.question) return false
        if (!options.contentEquals(other.options)) return false
        if (answer != other.answer) return false

        return true
    }

    override fun hashCode(): Int {
        var result = question.hashCode()
        result = 31 * result + options.contentHashCode()
        result = 31 * result + answer.hashCode()
        return result
    }
}

