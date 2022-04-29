package com.example.fragmentandbindingdata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//создаем класс, который наследуется от ViewModel
open class DataModel: ViewModel() {
    //инициализиуем константу message от LiveData, которая будет создана единожды из-за lazy
    val messageForActivity:MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
    val messageForFragment1:MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
    val messageForFragment2:MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
}