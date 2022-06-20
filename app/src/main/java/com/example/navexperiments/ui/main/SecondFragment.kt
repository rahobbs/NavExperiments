package com.example.navexperiments.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navexperiments.R

class SecondFragment : Fragment() {
    private val safeArgs: SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.second_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.myButton)

        button.setOnClickListener {
            val action = SecondFragmentDirections.newSecondFragment("coming from second")
            Log.d("SecondFragment", "click ${action.arguments.get("myArg")}")
            findNavController().navigate(action)
        }

        val text = view.findViewById<TextView>(R.id.message)
        text.text = safeArgs.myArg

    }
}