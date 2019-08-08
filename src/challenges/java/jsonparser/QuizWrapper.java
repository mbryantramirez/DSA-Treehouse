package challenges.java.jsonparser;

import com.squareup.moshi.Json;

import java.util.List;

public class QuizWrapper {
    @Json(name = "quiz")
    Quiz quiz;

    static class Quiz {
        @Json(name = "sport")
        Sport sport;
        @Json(name = "maths")
        Maths maths;

        static class Sport {
            @Json(name = "q1")
            Q1 q1;
        }

        static class Maths {
            @Json(name = "q2")
            Q2 q2;
        }

        static class Q1 {
            @Json(name = "question")
            String question;
            @Json(name = "options")
            List<String> options;
            @Json(name = "answer")
            String answer;
        }

        static class Q2 {
            @Json(name = "question")
            String question;
            @Json(name = "options")
            List<String> options;
            @Json(name = "answer")
            String answer;
        }
    }
}

