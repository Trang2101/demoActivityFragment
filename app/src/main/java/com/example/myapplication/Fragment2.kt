package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class Fragment2 : Fragment() {
    private var sendMessage: SendMessage? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SendMessage) {
            sendMessage = context
        } else {
            throw RuntimeException("$context must implement SendMessage")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_2, container, false)
        val editText = view.findViewById<View>(R.id.editText) as EditText
        val btn = view.findViewById<View>(R.id.sendText) as Button

        btn.setOnClickListener{
            val fragment1 = Fragment1()
            val bundle = Bundle()
            (activity as MainActivity2).result = bundle
            bundle.putString("fragment2", editText.text.toString())
            fragment1.arguments = bundle
            replaceFragment(fragment1)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    interface SendMessage {
        fun sendData(message: String?)
    }
    private fun replaceFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }
}