package com.solux.flory.presentation.auth

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.solux.flory.R
import com.solux.flory.databinding.ActivityUserInfoBinding

class UserInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserInfoBinding
    var gender = "male"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_info)

        binding.nicknameCheckBtn.setOnClickListener {
            val nickname = binding.inputNickname.text

            if (nickname.isEmpty()) {
                Toast.makeText(this, "닉네임을 입력해주세요", Toast.LENGTH_SHORT).show()
            } else {
                //사용가능한 닉네임의 경우
                binding.nickCheckOk.visibility = View.VISIBLE
                binding.nicknamePossible.visibility = View.VISIBLE

                //사용불가능한 닉네임의 경우
//                binding.nicknameImpossible.visibility = View.VISIBLE
            }

        }

        binding.genderMale.setOnClickListener {
            if(gender != "male") {
                gender = "male"

                binding.genderImage.setImageResource(R.drawable.user_male)
                binding.genderMaleChecked.visibility = View.VISIBLE
                binding.genderFemaleChecked.visibility = View.GONE

                binding.genderMale.setBackgroundResource(R.drawable.shape_peach_left_radius7_peach1_stroke)
                binding.genderFemale.setBackgroundResource(R.drawable.shape_transparent_right_radius7_peach1_stroke)

            }
        }
        binding.genderFemale.setOnClickListener {
            if(gender != "female") {
                gender = "female"

                binding.genderImage.setImageResource(R.drawable.user_female)
                binding.genderMaleChecked.visibility = View.GONE
                binding.genderFemaleChecked.visibility = View.VISIBLE


                binding.genderMale.setBackgroundResource(R.drawable.shape_transparent_left_radius7_peach1_stroke)
                binding.genderFemale.setBackgroundResource(R.drawable.shape_peach_right_radius7_peach1_stroke)
            }
        }
    }
}