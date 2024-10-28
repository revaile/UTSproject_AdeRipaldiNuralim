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
            Food("Batagor", "Batagor asli khas Bandung, gurih dan renyah dengan saus kacang lezat", R.drawable.batagor),
            Food("Black Salad", "Salad segar dan sehat, kombinasi sayuran hijau dan buah-buahan premium", R.drawable.black_salad),
            Food("Cappuccino", "Kopi Cappuccino autentik dari biji kopi Arabica terbaik, dengan aroma khas", R.drawable.cappuchino),
            Food("Cheese Cake", "Kue keju lembut dengan topping krim yang menggoda selera", R.drawable.cheesecake),
            Food("Cireng", "Cireng khas Bandung, renyah di luar dan kenyal di dalam, cocok untuk camilan", R.drawable.cireng),
            Food("Donut", "Donat manis dengan berbagai pilihan topping lezat dan menggiurkan", R.drawable.donut),
            Food("Kopi Hitam", "Kopi hitam pekat dengan rasa yang kuat, dibuat dari biji kopi pilihan", R.drawable.kopi_hitam),
            Food("Mie Goreng", "Mie goreng dengan bumbu khas dan rempah-rempah yang kaya, mantap dinikmati kapan saja", R.drawable.mie_goreng),
            Food("Nasi Goreng", "Nasi goreng spesial dengan campuran sayuran dan daging, favorit semua orang", R.drawable.nasigoreng),
            Food("Sparkling Tea", "Teh bersoda yang segar dan unik, perpaduan rasa teh dengan sentuhan sparkling", R.drawable.sparkling_tea)
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