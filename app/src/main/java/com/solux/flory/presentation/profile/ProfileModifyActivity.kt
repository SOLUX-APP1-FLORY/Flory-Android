package com.solux.flory.presentation.profile

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.solux.flory.R
import com.solux.flory.databinding.ActivityProfileModifyBinding

class ProfileModifyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileModifyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileModifyBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        with(binding){
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