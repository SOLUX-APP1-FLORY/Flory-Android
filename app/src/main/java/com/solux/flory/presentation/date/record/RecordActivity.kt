package com.solux.flory.presentation.date.record

import android.content.Intent
import android.os.Bundle
import coil.load
import com.solux.flory.databinding.ActivityRecordBinding
import com.solux.flory.presentation.main.MainActivity
import com.solux.flory.util.base.BindingActivity

class RecordActivity : BindingActivity<ActivityRecordBinding>({
    ActivityRecordBinding.inflate(it)
}) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        plantAreaClick()
        confirmBtnClick()
        val flower = intent.getSerializableExtra("flower") as? Flower
        flower?.let {
            binding.ivRecordPlant.load(it.imageUrl)
            binding.tvRecordFlowerMeaning.text = it.meaning
            binding.tvRecordFlowerName.text = it.name
        }
    }

    private fun plantAreaClick() {
        binding.clRecordPlant.setOnClickListener {
            val intent = Intent(this@RecordActivity, SelectFlowerActivity::class.java)
            startActivity(intent)
        }
    }

    private fun confirmBtnClick() {
        binding.btnRecordConfirm.setOnClickListener {
            val intent = Intent(this@RecordActivity, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}