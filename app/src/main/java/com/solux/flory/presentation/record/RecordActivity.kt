package com.solux.flory.presentation.record

import android.content.Intent
import android.os.Bundle
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.ActivityRecordBinding
import com.solux.flory.util.base.BindingActivity
import com.solux.flory.util.context.stringOf
import com.solux.flory.util.setupToolbarClickListener

class RecordActivity : BindingActivity<ActivityRecordBinding>({
    ActivityRecordBinding.inflate(it)
}) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbar()
        plantAreaClick()
        confirmBtnClick()
        leftArrowBtnClick()
    }

    private fun initToolbar() {
        with(binding.toolbarRecord) {
            tvToolbarTitle.text = stringOf(R.string.tv_record_toolbar_title)
            setupToolbarClickListener(ibToolbarIcon)
        }
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

    private fun leftArrowBtnClick() {
        binding.toolbarRecord.ibToolbarIcon.setOnClickListener {
            finish()
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