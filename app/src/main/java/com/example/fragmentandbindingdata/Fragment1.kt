package com.example.fragmentandbindingdata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentandbindingdata.databinding.Fragment1Binding


class Fragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = Fragment1Binding.inflate(inflater)
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() = Fragment1()

    }
}