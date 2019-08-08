package challenges.kotlin.jsonparser

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import okio.Okio
import java.io.File

fun main() {
    val file = File("assets/data.json")
    val source = Okio.source(file)
    val bufferSource = Okio.buffer(source)
    val string = bufferSource.readUtf8()
    val moshi = Moshi.Builder().build()
    val listType = Types.newParameterizedType(List::class.java, QuizWrapper::class.java)
    val jsonAdapter: JsonAdapter<List<Quiz>> = moshi.adapter(listType)
    val result = jsonAdapter.fromJson(string)
    print(result)
}