package com.solux.flory.presentation.date.record

import android.content.Intent
import android.os.Bundle
import com.solux.flory.databinding.ActivityRecordBinding
import com.solux.flory.util.base.BindingActivity

class RecordActivity : BindingActivity<ActivityRecordBinding>({
    ActivityRecordBinding.inflate(it)
}) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        plantAreaClick()
        confirmBtnClick()
    }

    private fun plantAreaClick() {
        binding.clRecordPlant.setOnClickListener {
            val intent = Intent(this@RecordActivity, SelectFlowerActivity::class.java)
            startActivity(intent)
        }
    }

    private fun confirmBtnClick() {
        binding.btnRecordConfirm.setOnClickListener {
            finish()
        }
    }
}