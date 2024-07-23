package com.solux.flory.presentation.auth

import android.content.Intent
import android.os.Bundle
import com.solux.flory.databinding.ActivityLoginBinding
import com.solux.flory.presentation.main.MainActivity
import com.solux.flory.util.base.BindingActivity

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
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun gotoSignup() {
        binding.tvLoginGoSignup.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}