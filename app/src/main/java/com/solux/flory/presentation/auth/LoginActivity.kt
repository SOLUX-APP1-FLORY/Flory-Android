package com.solux.flory.presentation.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.solux.flory.R
import com.solux.flory.databinding.ActivityLoginBinding
import com.solux.flory.presentation.main.MainActivity
import com.solux.flory.util.UiState
import com.solux.flory.util.base.BindingActivity
import com.solux.flory.util.context.stringOf
import com.solux.flory.util.context.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class LoginActivity : BindingActivity<ActivityLoginBinding>({
    ActivityLoginBinding.inflate(it)
}) {
    private val loginViewModel by viewModels<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBtnClick()
        gotoSignup()
        observePostLoginState()
    }

    private fun observePostLoginState() {
        loginViewModel.postLoginState.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Loading -> Unit
                is UiState.Success -> {
                    loginViewModel.saveUserAccessToken(it.data)
                    loginViewModel.saveCheckLogin(true)
                    Intent(this@LoginActivity, MainActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(this)
                    }
                }

                is UiState.Empty -> Unit
                is UiState.Failure -> Log.e("LoginActivity", it.msg)
            }
        }.launchIn(lifecycleScope)
    }

    private fun loginBtnClick() {
        binding.btnLogin.setOnClickListener {
            with(binding) {
                if (etLoginId.text.isNotBlank() && etLoginPw.text.isNotBlank()) {
                    loginViewModel.postLogin(etLoginId.text.toString(), etLoginPw.text.toString())
                } else {
                    toast(stringOf(R.string.tv_login_impossible))
                }
            }
        }
    }

    private fun gotoSignup() {
        binding.tvLoginGoSignup.setOnClickListener {
            Intent(this, SignUpActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}