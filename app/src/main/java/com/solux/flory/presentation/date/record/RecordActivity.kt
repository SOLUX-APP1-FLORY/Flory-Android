package com.solux.flory.presentation.date.record

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
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
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            val flower = data?.getSerializableExtra("flower") as Flower
            with(binding) {
                ivRecordPlant.load(flower.imageUrl)
                tvRecordFlowerMeaning.text = flower.meaning
                tvRecordFlowerName.text = flower.name
            }
        }
    }

    private fun plantAreaClick() {
        binding.clRecordPlant.setOnClickListener {
            val intent = Intent(this@RecordActivity, SelectFlowerActivity::class.java)
            startActivityForResult(intent, 0)
        }
    }

    private fun confirmBtnClick() {
        binding.btnRecordConfirm.setOnClickListener {
            finish()
        }
    }
}