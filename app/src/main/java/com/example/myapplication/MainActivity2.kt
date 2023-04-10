package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.replace
import com.example.myapplication.databinding.ActivityMain2Binding



class MainActivity2 : AppCompatActivity(), Fragment2.SendMessage {
    var result = Bundle()
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        var str = intent.getStringExtra("data")

        val f1 = Fragment1()
        val f2 = Fragment2()

        binding.textView.text = str
        val bundle = Bundle()
        bundle.putString("message", str)
        f1.arguments = bundle
        binding.btn1.setOnClickListener {
            replaceFragment(f1)
        }

        binding.btn2.setOnClickListener {
            replaceFragment(f2)
        }

        binding.textView.text = str
        binding.btn.setOnClickListener {
            supportFragmentManager.apply {
                for (fragment in fragments) {
                    beginTransaction().remove(fragment).commit()
                }
                popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
            binding.textView.text = result.getString("fragment2")
        }
    }

    private fun replaceFragment(fragment: Fragment) {
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
//        fragmentTransaction.commit()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }

    override fun sendData(message: String?) {
        TODO("Not yet implemented")
    }
}