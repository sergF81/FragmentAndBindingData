package com.example.fragmentandbindingdata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.fragmentandbindingdata.databinding.Fragment1Binding
import com.example.fragmentandbindingdata.databinding.Fragment2Binding


class Fragment2 : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: Fragment2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = Fragment2Binding.inflate(inflater)
        return binding.root
    }
    //функция для добавления слушателей нажатия на кнопки
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFragment1.observe(activity as LifecycleOwner,{
            binding.tvMessage2.text = it
        })
        //обработка нажатия кнопки buttonSentToFragment1
        binding.buttonSentToFragment1.setOnClickListener() {
            //меняем содержимое dataMode.message
            dataModel.messageForFragment1.value = "Hello from fragment 2"
        }
        //обработка нажатия кнопки buttonSentToActivity
        binding.buttonSentToActivity.setOnClickListener() {
            //меняем содержимое dataMode.message
            dataModel.messageForActivity.value = "Hello activity from fragment 2"
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = Fragment2()
    }
}