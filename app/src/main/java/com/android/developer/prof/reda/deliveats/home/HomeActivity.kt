package com.android.developer.prof.reda.deliveats.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.android.developer.prof.reda.deliveats.R
import com.android.developer.prof.reda.deliveats.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)

        val navController by lazy {
            val navHostFragment =supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
            navHostFragment.navController
        }

        binding.navBar.setupWithNavController(navController)
    }
}