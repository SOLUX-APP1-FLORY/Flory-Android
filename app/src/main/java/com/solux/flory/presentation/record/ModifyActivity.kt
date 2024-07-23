package com.solux.flory.presentation.record

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.ActivityModifyBinding
import com.solux.flory.presentation.date.DateInfo
import com.solux.flory.util.base.BindingActivity
import com.solux.flory.util.context.stringOf
import com.solux.flory.util.context.toast
import com.solux.flory.util.setupToolbarClickListener

class ModifyActivity : BindingActivity<ActivityModifyBinding>(ActivityModifyBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbar()
        initView()
        modifyFlowerAreaClick()
        confirmBtnClick()
        cancelBtnClick()
    }

    private fun initToolbar() {
        with(binding.toolbarModify) {
            tvToolbarTitle.text = stringOf(R.string.tv_modify_toolbar_title)
            setupToolbarClickListener(ibToolbarIcon)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            val flower = data?.getSerializableExtra("flower") as Flower
            with(binding) {
                ivModifyFlowerAvatar.load(flower.imageUrl)
                tvModifyFlowerMeaning.text = flower.meaning
                tvModifyFlowerName.text = flower.name
            }
        }
    }

    private fun confirmBtnClick() {
        binding.btnModifyConfirm.setOnClickListener {
            toast("수정되었습니다.")
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
            startActivityForResult(intent, 0)
        }
    }

    private fun initView() {
        val date = intent.getSerializableExtra("date") as DateInfo
        binding.tvModifyDate.text = "2024. ${date.month}. ${date.dayOfWeek}"
    }
}
