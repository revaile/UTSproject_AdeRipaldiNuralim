package lat.pam.utsproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_food)


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2) // Menggunakan GridLayoutManager untuk dua kolom

        // Menyiapkan data makanan
        foodList = listOf(
            Food("Batagor", "Batagor asli enak dari Bandung", R.drawable.batagor),
            Food("Black Salad", "Salad segar yang dibuat secara langsung", R.drawable.black_salad),
            Food("Cappucino", "Kopi cappucino asli yang dibuat dari Kopi Arabica", R.drawable.cappuchino),
            Food("Chese Cake", "Kopi cappucino asli yang dibuat dari Kopi Arabica", R.drawable.cheesecake) ,
            Food("Cireng", "Kopi cappucino asli yang dibuat dari Kopi Arabica", R.drawable.cireng),
            Food("Donut", "Kopi cappucino asli yang dibuat dari Kopi Arabica", R.drawable.donut) ,
            Food("Kopi Hitam", "Kopi cappucino asli yang dibuat dari Kopi Arabica", R.drawable.kopi_hitam),
            Food("Mie Goreng", "Kopi cappucino asli yang dibuat dari Kopi Arabica", R.drawable.mie_goreng),
            Food("Nasi Goreng", "Kopi cappucino asli yang dibuat dari Kopi Arabica", R.drawable.nasigoreng),
            Food("Sparkling Tea", "Kopi cappucino asli yang dibuat dari Kopi Arabica", R.drawable.sparkling_tea),


            )

        adapter = FoodAdapter(foodList)
        recyclerView.adapter = adapter


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}