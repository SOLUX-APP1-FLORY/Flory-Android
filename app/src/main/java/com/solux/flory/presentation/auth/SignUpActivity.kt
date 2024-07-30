package com.solux.flory.presentation.auth

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.viewModels
import com.solux.flory.R
import com.solux.flory.databinding.ActivitySignUpBinding
import com.solux.flory.util.base.BindingActivity
import com.solux.flory.util.context.stringOf
import com.solux.flory.util.setupToolbarClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : BindingActivity<ActivitySignUpBinding>({
    ActivitySignUpBinding.inflate(it)
}) {

    private val viewModel: SignupViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbar()
        gotoUserInfo()
        checkId()
        checkPW()
    }

    private fun initToolbar() {
        with(binding.toolbarSignup) {
            tvToolbarTitle.text = stringOf(R.string.tv_signup_toolbar_title)
            setupToolbarClickListener(ibToolbarIcon)
        }
    }

    private fun gotoUserInfo() {
        binding.btnSignupGotoUserInfo.setOnClickListener {
            Intent(this, UserInfoActivity::class.java).apply {
                putExtra(ID, binding.etSignupId.text.toString())
                putExtra(PASSWORD, binding.etSignupPw.text.toString())
                putExtra(EMAIL, getEmail())
            }.also {
                startActivity(it)
            }
        }
    }

    private fun getEmail(): String {
        val emailBefore = binding.etSignupEmail.text.toString()
        val emailAfter = binding.etSignupEmailAfter.text.toString()

        val email = "$emailBefore@$emailAfter"
        return email
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
        const val ID = "id"
        const val PASSWORD = "password"
        const val EMAIL = "email"
    }
}