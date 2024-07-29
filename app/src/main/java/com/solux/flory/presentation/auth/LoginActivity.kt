package com.solux.flory.presentation.auth

import android.content.Intent
import android.os.Bundle
import com.solux.flory.databinding.ActivityLoginBinding
import com.solux.flory.presentation.main.MainActivity
import com.solux.flory.util.base.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BindingActivity<ActivityLoginBinding>({
    ActivityLoginBinding.inflate(it)
}) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBtnClick()
        gotoSignup()
    }

    private fun loginBtnClick() {
        binding.btnLogin.setOnClickListener {
            Intent(this, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(this)
            }
        }
    }

    private fun gotoSignup() {
        binding.tvLoginGoSignup.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}