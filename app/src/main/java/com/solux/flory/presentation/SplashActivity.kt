package com.solux.flory.presentation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.solux.flory.databinding.ActivitySplashBinding
import com.solux.flory.presentation.auth.LoginActivity
import com.solux.flory.presentation.auth.LoginViewModel
import com.solux.flory.presentation.main.MainActivity
import com.solux.flory.util.base.BindingActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class SplashActivity : BindingActivity<ActivitySplashBinding>({
    ActivitySplashBinding.inflate(it)
}) {
    private val loginViewModel by viewModels<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        initSplash()
    }

    private fun initSplash() {
        Handler().postDelayed({
            runBlocking {
                when {
                    (loginViewModel.getUserAccessToken().toString().isNotBlank() &&
                    loginViewModel.getCheckLogin().first()) ->
                        navigateTo<MainActivity>()
                    else -> navigateTo<LoginActivity>()
                }
                finish()
            }
        }, 2000)
    }

    private inline fun <reified T : Activity> navigateTo() {
        Intent(this@SplashActivity, T::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(this)
        }
    }
}