package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        // Ambil nilai dari Intent
        val foodDescription = intent.getStringExtra("FOOD_NAME")
        val foodImageResId = intent.getIntExtra("FOOD_IMAGE", 0)

        // Set nilai ke TextView dan ImageView
        findViewById<TextView>(R.id.etFoodName).text = foodDescription
        findViewById<ImageView>(R.id.foodImage).setImageResource(foodImageResId)

        // Ambil input dari EditText
        val etServings = findViewById<EditText>(R.id.etServings)
        val etName = findViewById<EditText>(R.id.etName)
        val etNotes = findViewById<EditText>(R.id.etNotes)

        findViewById<Button>(R.id.btnOrder).setOnClickListener {
            val intent = Intent(this, ConfirmationActivity::class.java).apply {
                putExtra("FOOD_NAME", foodDescription)
                putExtra("SERVINGS", etServings.text.toString())
                putExtra("ORDERING_NAME", etName.text.toString())
                putExtra("NOTES", etNotes.text.toString())
            }
            startActivity(intent)
        }
    }
}
