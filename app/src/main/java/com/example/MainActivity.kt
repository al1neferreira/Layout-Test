package com.example

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.layout_test.R
import com.example.layout_test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        onView()

    }

    private fun onView() {
        colorButton(true)
    }

    private fun colorButton(isColored: Boolean) {
        var botao = binding.btnButton
        if (isColored) {
            botao.setBackgroundColor(
                resources.getColor(
                    R.color.purple_500,
                    null
                )
            )
        } else {
            botao.setBackgroundColor(
                resources.getColor(
                    R.color.black,
                    null
                )
            )
        }
    }
}

