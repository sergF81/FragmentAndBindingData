package com.example.fragmentandbindingdata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.fragmentandbindingdata.databinding.Fragment1Binding


class Fragment1 : Fragment() {
    //инициализация конcтанты dataModel наследуемой от класса DataModel(необходимо для создания Обсервера) во фрагменте от Activity
    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: Fragment1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = Fragment1Binding.inflate(inflater)
        return binding.root
    }

    //функция для добавления слушателей нажатия на кнопки
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFragment1.observe(activity as LifecycleOwner,{
            binding.tvMessage.text = it
        })
        //обработка нажатия кнопки buttonSentToFragment2
        binding.buttonSentToFragment2.setOnClickListener() {
            //меняем содержимое dataMode.message
            dataModel.messageForFragment2.value = "Hello from fragment 1"
        }
        //обработка нажатия кнопки buttonSentToActivity
        binding.buttonSentToActivity.setOnClickListener() {
            //меняем содержимое dataMode.message
            dataModel.messageForActivity.value = "Hello activity from fragment 1"
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = Fragment1()

    }
}