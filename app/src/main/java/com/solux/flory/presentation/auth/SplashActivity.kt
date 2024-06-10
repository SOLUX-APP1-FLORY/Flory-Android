package com.solux.flory.presentation.auth

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.solux.flory.R
import com.solux.flory.databinding.ActivitySplashBinding
import com.solux.flory.util.base.BindingActivity

class SplashActivity : BindingActivity<ActivitySplashBinding>({
    ActivitySplashBinding.inflate(it)
}) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler().postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()  //스플래시 화면은 끝나도록
        }, 2000)
    }
}