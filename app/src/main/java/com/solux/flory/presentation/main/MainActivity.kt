package com.solux.flory.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.solux.flory.R
import com.solux.flory.databinding.ActivityMainBinding
import com.solux.flory.presentation.date.DateFragment
import com.solux.flory.presentation.gift.GiftFragment
import com.solux.flory.presentation.home.HomeFragment
import com.solux.flory.presentation.profile.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val currentFragment = supportFragmentManager.findFragmentById(binding.fcvMain.id)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(binding.fcvMain.id, HomeFragment())
                .commit()
        }

        clickBottomNavigation()
    }

    private fun clickBottomNavigation() {
        binding.bnvMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.menu_date -> {
                    replaceFragment(DateFragment())
                    true
                }

                R.id.menu_gift -> {
                    replaceFragment(GiftFragment())
                    true
                }

                R.id.menu_profile -> {
                    replaceFragment(ProfileFragment())
                    true
                }

                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fcvMain.id, fragment)
            .commit()
    }
}