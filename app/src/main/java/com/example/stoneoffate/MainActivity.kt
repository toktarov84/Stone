package com.example.stoneoffate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.Toast
import com.example.stoneoffate.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var list = listOf(
        "Коня потерял хлопец!",
        "Жизнь свою отдал болезный...",
        "А вот это верный путь!"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = list.shuffled()

        binding.apply {
            val popupMenu = PopupMenu(applicationContext, textView)
            popupMenu.inflate(R.menu.popup_menu)
            popupMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.menuBack -> {
                        Toast.makeText(baseContext, "Молодец, нечего тебе здесь делать!", Toast.LENGTH_LONG).show()
                        finish()
                    }
                    R.id.menuForward -> Toast.makeText(baseContext, list[0], Toast.LENGTH_SHORT).show()
                    R.id.menuLeft -> Toast.makeText(baseContext, list[1], Toast.LENGTH_SHORT).show()
                    R.id.menuRight -> Toast.makeText(baseContext, list[2], Toast.LENGTH_SHORT).show()
                }
                false
            }
            imageView.setOnClickListener {
                popupMenu.show()
            }
        }
    }
}