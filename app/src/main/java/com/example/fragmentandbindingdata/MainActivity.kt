package com.example.fragmentandbindingdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentandbindingdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //инициализация и подключение фрагмента
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.placeHolder1,Fragment1.newInstance())
            .commit()
    }
}