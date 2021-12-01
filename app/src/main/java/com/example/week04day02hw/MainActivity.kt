package com.example.week04day02hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    private var buttonFrag1:Button?= null
    private var buttonFrag2:Button?= null
    private var frameLayout:FrameLayout?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectViews()

        buttonFrag1?.setOnClickListener {
            openFragment(FirstFragment(),"FIRST_FRAGMENT")
        }
        buttonFrag2?.setOnClickListener {
            openFragment(SecondFragment(),"SECOND_FRAGMENT")
        }
    }

    private fun connectViews(){
        buttonFrag1 = findViewById(R.id.btnOpenFrag1)
        buttonFrag2 = findViewById(R.id.btnOpenFrag2)
        frameLayout = findViewById(R.id.fContainer)
    }
    private fun openFragment(fragment: Fragment,tag:String){
        val fragmentTransaction:FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fContainer,fragment,tag)
        fragmentTransaction.addToBackStack(tag)//optional
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)//optional
        fragmentTransaction.commit()
    }

}