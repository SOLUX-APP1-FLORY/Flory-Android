package com.solux.flory.presentation.main

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.solux.flory.R
import com.solux.flory.databinding.ActivityMainBinding
import com.solux.flory.util.base.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>({
    ActivityMainBinding.inflate(it)
}) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initMainBottomNavigation()

    }

    private fun initMainBottomNavigation() {
        val navController =
            (supportFragmentManager.findFragmentById(R.id.fcv_main) as NavHostFragment).findNavController()
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
