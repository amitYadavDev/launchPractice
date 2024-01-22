package amitapps.media.flowandchannelpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            val value = apiService()
            Log.d("MainActivity__value", "$value")

            message()

            Log.d("MainActivity__value", "in main activity")
        }
    }

    private suspend fun message() {
        Log.d("MainActivity__message", "  yes")
        delay(1000)
    }

    private suspend fun apiService(): Any {
        delay(10000)
        return 5
    }
}