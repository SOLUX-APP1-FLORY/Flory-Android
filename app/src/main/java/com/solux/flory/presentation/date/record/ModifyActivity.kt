package com.solux.flory.presentation.date.record

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.solux.flory.databinding.ActivityModifyBinding
import com.solux.flory.presentation.date.DateInfo
import com.solux.flory.util.base.BindingActivity

class ModifyActivity : BindingActivity<ActivityModifyBinding>(ActivityModifyBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        modifyFlowerAreaClick()
        confirmBtnClick()
        cancelBtnClick()
    }

    private fun confirmBtnClick() {
        binding.btnModifyConfirm.setOnClickListener {
            Toast.makeText(this, "수정되었습니다.", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun cancelBtnClick() {
        binding.btnModifyCancel.setOnClickListener {
            finish()
        }
    }

    private fun modifyFlowerAreaClick() {
        binding.clModifyFlowerImage.setOnClickListener {
            val intent = Intent(this, SelectFlowerActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initView() {
        val date = intent.getSerializableExtra("date") as DateInfo
        binding.tvModifyDate.text = "2024. ${date.month}. ${date.dayOfWeek}"
    }
}