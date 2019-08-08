package challenges.java.guessinggame;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import okio.BufferedSource;
import okio.Okio;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;

public class JSONParser {

    public static void main(String[] args) throws IOException {
        File file = new File("assets/data.json");
        BufferedSource bufferedSource = Okio.buffer(Okio.source(file));
        String jsonString = bufferedSource.readUtf8();
        Moshi moshi = new Moshi.Builder().build();
        ParameterizedType types = Types.newParameterizedType(List.class, QuizWrapper.class);
        JsonAdapter<List<QuizWrapper>> quizWrapperJsonAdapter = moshi.adapter(types);
        List<QuizWrapper> result = quizWrapperJsonAdapter.fromJson(jsonString);
        assert result != null;
        System.out.println(result.get(0).quiz.maths.q2.answer);
    }
}
