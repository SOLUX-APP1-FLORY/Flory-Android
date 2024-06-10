package com.solux.flory.presentation.profile

import android.os.Bundle
import android.widget.Toast
import com.solux.flory.databinding.ActivityProfileModifyBinding
import com.solux.flory.util.base.BindingActivity

class ProfileModifyActivity : BindingActivity<ActivityProfileModifyBinding>({
    ActivityProfileModifyBinding.inflate(it)
}) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        leftArrowClick()
        maleSelected()
        femaleSelected()
        modifyBtnClick()
    }

    private fun modifyBtnClick() {
        binding.btnProfileModify.setOnClickListener {
            Toast.makeText(this, "회원 정보 수정 완료", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun femaleSelected() {
        with(binding) {
            clModifySexFemale.setOnClickListener {
                clModifySexMale.isSelected = false
                clModifySexFemale.isSelected = true
            }
        }
    }

    private fun maleSelected() {
        with(binding) {
            clModifySexMale.setOnClickListener {
                clModifySexMale.isSelected = true
                clModifySexFemale.isSelected = false
            }
        }
    }

    private fun leftArrowClick() {
        binding.ivModifyLeftArrow.setOnClickListener {
            finish()
        }
    }
}