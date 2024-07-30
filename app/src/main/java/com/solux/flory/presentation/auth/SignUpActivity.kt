package com.solux.flory.presentation.auth

import android.R
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.viewModels
import com.solux.flory.databinding.ActivitySignUpBinding
import com.solux.flory.util.base.BindingActivity
import com.solux.flory.util.context.stringOf
import com.solux.flory.util.setupToolbarClickListener


class SignUpActivity : BindingActivity<ActivitySignUpBinding>({
    ActivitySignUpBinding.inflate(it)
}) {

    private val viewModel: SignupViewModel by viewModels()

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbar()
        gotoUserInfo()
        checkId()
        checkPW()
    }

    private fun initToolbar() {
        with(binding.toolbarSignUp) {
            tvToolbarTitle.text = stringOf(com.solux.flory.R.string.tv_sign_up_toolbar_title)
            setupToolbarClickListener(ibToolbarIcon)
        }
    }

    private fun gotoUserInfo() {
        binding.btnSignUpGotoUserInfo.setOnClickListener {
            Intent(this, UserInfoActivity::class.java).apply {
                putExtra(ID, binding.etSignUpId.text.toString())
                putExtra(PASSWORD, binding.etSignUpPw.text.toString())
                putExtra(EMAIL, getEmail())
            }.also {
                startActivity(it)
            }
        }
    }

    private fun getEmail(): String {
        val emailBefore = binding.etSignUpEmail.text.toString()
        val emailAfter = binding.etSignUpEmailAfter.text.toString()

        val email = "$emailBefore@$emailAfter"
        return email
    }

    private fun checkId() {
        binding.btnSignUpCheckId.setOnClickListener {
            if(true) {  // 사용가능한 아이디
                binding.tvSignUpIdImpossible.visibility = View.VISIBLE
                binding.tvSignUpIdPossible.visibility = View.GONE
            } else {  // 사용 불가능한 아이디
                binding.tvSignUpIdPossible.visibility = View.GONE
                binding.tvSignUpIdImpossible.visibility = View.VISIBLE
            }
        }
    }

    private fun checkPW() {
        binding.etSignUpPwCheck.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val pw = binding.etSignUpPw.text.toString()
                val pwConfirm = binding.etSignUpPwCheck.text.toString()

                if(pw == pwConfirm) {
                    binding.tvSignUpPwPossible.visibility = View.VISIBLE
                    binding.tvSignUpPwImpossible.visibility = View.GONE
                } else {
                    binding.tvSignUpPwPossible.visibility = View.GONE
                    binding.tvSignUpPwImpossible.visibility = View.VISIBLE
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
    }

    companion object {
        const val ID = "id"
        const val PASSWORD = "password"
        const val EMAIL = "email"
    }
}