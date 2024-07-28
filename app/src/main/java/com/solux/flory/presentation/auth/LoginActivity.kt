package com.solux.flory.presentation.auth

import android.content.Intent
import android.os.Bundle
import com.solux.flory.databinding.ActivityLoginBinding
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

    private fun navigateToUserInfoActivity() {
        Intent(this@LoginActivity, UserInfoActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(this)
        }
    }

    private fun loginBtnClick() {
        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun gotoSignup() {
        binding.tvLoginGoSignup.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        binding.loginBtn.setOnClickListener {
            navigateToUserInfoActivity() // 추후 삭제 예정
        }
    }
}