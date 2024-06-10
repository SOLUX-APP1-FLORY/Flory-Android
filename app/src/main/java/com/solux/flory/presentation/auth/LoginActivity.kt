package com.solux.flory.presentation.auth

import android.content.Intent
import android.os.Bundle
import com.solux.flory.databinding.ActivityLoginBinding
import com.solux.flory.util.base.BindingActivity

class LoginActivity : BindingActivity<ActivityLoginBinding>({
    ActivityLoginBinding.inflate(it)
}) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBtnClick()
    }

    private fun loginBtnClick() {
        binding.loginBtn.setOnClickListener {
            val intent = Intent(this@LoginActivity, UserInfoActivity::class.java)
            startActivity(intent)
        }
    }
}