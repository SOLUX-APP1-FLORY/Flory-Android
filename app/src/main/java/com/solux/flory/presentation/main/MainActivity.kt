package com.solux.flory.presentation.main

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.solux.flory.R
import com.solux.flory.databinding.ActivityMainBinding
import com.solux.flory.presentation.date.DateFragment
import com.solux.flory.presentation.gift.GiftFragment
import com.solux.flory.presentation.home.HomeFragment
import com.solux.flory.presentation.profile.ProfileFragment
import com.solux.flory.util.base.BindingActivity

class MainActivity : BindingActivity<ActivityMainBinding>({
    ActivityMainBinding.inflate(it)
}) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initMainBottomNavigation()

    }

    private fun initMainBottomNavigation() {
        val navController = (supportFragmentManager.findFragmentById(R.id.fcv_main) as NavHostFragment).findNavController()
        binding.bnvMain.apply {
            setupWithNavController(navController)
            itemRippleColor = null
        }

        setBottomNavigationVisible(navController)
    }

    private fun setBottomNavigationVisible(navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.bnvMain.visibility =
                if (destination.id in
                    listOf(
                        R.id.fragment_home,
                        R.id.fragment_date,
                        R.id.fragment_gift,
                        R.id.fragment_profile
                    )
                ) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
        }
    }

}
