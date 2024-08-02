package com.solux.flory.presentation.auth

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.solux.flory.R
import com.solux.flory.databinding.ActivitySignUpBinding
import com.solux.flory.util.UiState
import com.solux.flory.util.base.BindingActivity
import com.solux.flory.util.context.stringOf
import com.solux.flory.util.context.toast
import com.solux.flory.util.setupToolbarClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@AndroidEntryPoint
class SignUpActivity : BindingActivity<ActivitySignUpBinding>({
    ActivitySignUpBinding.inflate(it)
}) {

    private val signupViewModel by viewModels<SignupViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbar()
        gotoUserInfo()
        checkId()
        checkPW()
        observePostSignUpState()
    }

    private fun observePostSignUpState() {
        signupViewModel.postSignUpState.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Loading -> Unit
                is UiState.Success -> {
                    Intent(this, UserInfoActivity::class.java).apply {
                        // 유저 아이디 보내기
                        Timber.d("userId: ${it.data.toString()}")
                        putExtra(ID_KEY, it.data.toString())
                        startActivity(this)
                        finish()
                    }
                }

                is UiState.Empty -> Unit
                is UiState.Failure -> Unit
            }
        }.launchIn(lifecycleScope)
    }

    private fun initToolbar() {
        with(binding.toolbarSignup) {
            tvToolbarTitle.text = stringOf(R.string.tv_signup_toolbar_title)
            setupToolbarClickListener(ibToolbarIcon)
        }
    }

    private fun gotoUserInfo() {
        binding.btnSignupGotoUserInfo.setOnClickListener {
            with(binding) {
                if (etSignupId.text.isNotBlank() && tvIdPossible.visibility == View.VISIBLE && tvPwPossible.visibility == View.VISIBLE && getEmail().isNotBlank()) {
                    signupViewModel.postSignUp(
                        etSignupId.text.toString(),
                        etSignupPw.text.toString(),
                        getEmail()
                    )
                } else {
                    toast(stringOf(R.string.tv_signup_notice))
                }
            }
        }
    }

    private fun getEmail(): String {
        val emailBefore = binding.etSignupEmail.text.toString()
        val emailAfter = binding.etSignupEmailAfter.text.toString()
        return "$emailBefore@$emailAfter"
    }

    private fun checkId() {
        binding.etSignupId.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.btnSignupCheckId.isEnabled = s?.length!! <= 20
            }

            override fun afterTextChanged(s: Editable?) {}
        })
        btnSignupCheckIdClickListener()
    }

    private fun btnSignupCheckIdClickListener() {
        binding.btnSignupCheckId.setOnClickListener {
            if (true) {  // 사용가능한 아이디
                binding.tvIdPossible.visibility = View.VISIBLE
                binding.tvIdImpossible.visibility = View.GONE
                binding.btnSignupCheckId.isEnabled = false
            } else {  // 사용 불가능한 아이디
                binding.tvIdPossible.visibility = View.GONE
                binding.tvIdImpossible.visibility = View.VISIBLE
                binding.btnSignupCheckId.isEnabled = false
            }
        }
    }

    private fun checkPW() {
        binding.etSignupPwCheck.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val pw = binding.etSignupPw.text.toString()
                val pwConfirm = binding.etSignupPwCheck.text.toString()

                if (pw == pwConfirm) {
                    binding.tvPwPossible.visibility = View.VISIBLE
                    binding.tvPwImpossible.visibility = View.GONE
                } else {
                    binding.tvPwPossible.visibility = View.GONE
                    binding.tvPwImpossible.visibility = View.VISIBLE
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    companion object {
        const val ID_KEY = "userId"
    }
}