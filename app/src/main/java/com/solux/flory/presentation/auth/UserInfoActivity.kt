package com.solux.flory.presentation.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.solux.flory.R
import com.solux.flory.databinding.ActivityUserInfoBinding
import com.solux.flory.presentation.auth.SignUpActivity.Companion.ID_KEY
import com.solux.flory.util.UiState
import com.solux.flory.util.base.BindingActivity
import com.solux.flory.util.context.stringOf
import com.solux.flory.util.context.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
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
        observePatchUserInfo()
    }

    private fun observePatchUserInfo() {
        viewModel.patchUserInfoState.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Loading -> Unit
                is UiState.Success -> {
                    Intent(this, LoginActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(this)
                        finish()
                    }
                }
                is UiState.Empty -> Unit
                is UiState.Failure -> Unit
            }
        }.launchIn(lifecycleScope)
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
                val nickname = etUserInfoNickname.text

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
        binding.btnInfoConfirm.setOnClickListener {
            val userId = intent.getStringExtra(ID_KEY)?.toInt()
            userId?.let {
                if (binding.etUserInfoNickname.text.isNotBlank() && viewModel.gender.value != null) {
                    viewModel.patchUserInfo(
                        userId,
                        binding.etUserInfoNickname.text.toString(),
                        viewModel.gender.value!!
                    )
                } else {
                    toast(stringOf(R.string.tv_user_info_error))
                }
            }

        }
    }

}