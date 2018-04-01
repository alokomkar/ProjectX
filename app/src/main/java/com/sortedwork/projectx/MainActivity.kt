package com.sortedwork.projectx

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sortedwork.projectx.base.NavigationView

class MainActivity : AppCompatActivity(), NavigationView {

    override fun navigateToSplash() {
        navigateToAuth()
    }

    override fun navigateToAuth() {
        navigateToOnBoarding()
    }

    override fun navigateToOnBoarding() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigateToSplash()
    }
}
