package com.solux.flory.presentation.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.solux.flory.R
import com.solux.flory.databinding.ActivityUserInfoBinding
import com.solux.flory.presentation.main.MainActivity
import com.solux.flory.util.base.BindingActivity

class UserInfoActivity : BindingActivity<ActivityUserInfoBinding>({
    ActivityUserInfoBinding.inflate(it)
}) {

    private val viewModel: SignupViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nicknameCheckBtnClick()
        genderMaleBtnClick()
        genderFemaleBtnClick()
        infoConfirmBtnClick()
        getSignupInfo()
    }

    private fun genderFemaleBtnClick() {
        with(binding) {
            genderFemale.setOnClickListener {
                if (viewModel.gender.value != "female") {
                    viewModel.setGender("female")
                    genderImage.setImageResource(R.drawable.user_female)
                    genderMaleChecked.visibility = View.GONE
                    genderFemaleChecked.visibility = View.VISIBLE
                    genderMale.setBackgroundResource(R.drawable.shape_transparent_left_radius7_peach1_stroke)
                    genderFemale.setBackgroundResource(R.drawable.shape_peach_right_radius7_peach1_stroke)
                }
            }
        }
    }

    private fun genderMaleBtnClick() {
        with(binding) {
            genderMale.setOnClickListener {
                if (viewModel.gender.value != "male") {
                    viewModel.setGender("male")
                    genderImage.setImageResource(R.drawable.user_male)
                    genderMaleChecked.visibility = View.VISIBLE
                    genderFemaleChecked.visibility = View.GONE
                    genderMale.setBackgroundResource(R.drawable.shape_peach_left_radius7_peach1_stroke)
                    genderFemale.setBackgroundResource(R.drawable.shape_transparent_right_radius7_peach1_stroke)
                }
            }
        }
    }

    private fun nicknameCheckBtnClick() {
        with(binding) {
            nicknameCheckBtn.setOnClickListener {
                val nickname = inputNickname.text

                if (nickname.isEmpty()) {
                    Toast.makeText(this@UserInfoActivity, "닉네임을 입력해주세요", Toast.LENGTH_SHORT).show()
                } else {
                    //사용가능한 닉네임의 경우
                    nickCheckOk.visibility = View.VISIBLE
                    nicknamePossible.visibility = View.VISIBLE

                    //사용불가능한 닉네임의 경우
                    // nicknameImpossible.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun infoConfirmBtnClick() {
        binding.clInfoConfirm.setOnClickListener {
            viewModel._nickname.value = binding.inputNickname.text.toString()

            Intent(this, LoginActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(this)
            }
        }
    }

    private fun getSignupInfo() {
        viewModel._id.value = intent.getStringExtra(ID)
        viewModel._pw.value = intent.getStringExtra(PASSWORD)
        viewModel._email.value = intent.getStringExtra(EMAIL)
    }

    companion object {
        const val ID = "id"
        const val PASSWORD = "password"
        const val EMAIL = "email"
    }
}