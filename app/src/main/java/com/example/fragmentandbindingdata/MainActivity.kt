package com.example.fragmentandbindingdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.fragmentandbindingdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    //инициализация конcтанты dataModel наследуемой от класса DataModel(необходимо для создания Обсервера)
    private val dataModel:DataModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //инициализация и подключение фрагмента
        openFrag(Fragment1.newInstance(), R.id.placeHolder1)
        openFrag(Fragment2.newInstance(), R.id.placeHolder2)
        //запуск Обсервера для все активити (this) на изменение значения message
//        dataModel.message.observe(this){
//            //обновляем UI в активити
//            binding.textView.text = it
//
//        }
    }

    //функция описания открытия фрагмента
    private fun openFrag(f: Fragment, idHolder: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
}