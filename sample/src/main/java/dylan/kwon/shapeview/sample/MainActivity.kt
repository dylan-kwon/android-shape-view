package dylan.kwon.shapeview.sample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import dylan.kwon.shapeview.sample.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.second.setOnClickListener {
            Toast.makeText(this, "Click!!", Toast.LENGTH_SHORT).show()
        }
    }

}
