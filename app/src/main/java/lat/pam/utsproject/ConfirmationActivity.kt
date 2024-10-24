package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // Ambil data dari Intent
        val foodName = intent.getStringExtra("FOOD_NAME")
        val servings = intent.getStringExtra("SERVINGS")
        val orderingName = intent.getStringExtra("ORDERING_NAME")
        val notes = intent.getStringExtra("NOTES")

        // Set data ke TextView
        findViewById<TextView>(R.id.foodNameText).text = "Food Name: $foodName"
        findViewById<TextView>(R.id.servingsText).text = "Number of Servings: $servings"
        findViewById<TextView>(R.id.orderingNameText).text = "Ordering Name: $orderingName"
        findViewById<TextView>(R.id.notesText).text = "Additional Notes: $notes"

        // Event klik untuk tombol "Back to Menu"
        findViewById<Button>(R.id.backtoMenu).setOnClickListener {
            val intent = Intent(this, ListFoodActivity::class.java)
            startActivity(intent)
            finish() // Menutup ConfirmationActivity agar tidak kembali ke halaman ini
        }
    }
}