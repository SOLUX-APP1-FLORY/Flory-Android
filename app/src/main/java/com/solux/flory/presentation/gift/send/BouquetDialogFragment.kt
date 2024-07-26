package com.solux.flory.presentation.gift.send

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.FragmentGiftDialogBinding
import com.solux.flory.presentation.date.record.RecordActivity
import com.solux.flory.util.base.BindingDialogFragment

class BouquetDialogFragment(
    private val bouquetInfo: BouquetInfo
) : BindingDialogFragment<FragmentGiftDialogBinding>(FragmentGiftDialogBinding::inflate) {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext(), R.style.CustomDialogTheme)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        confirmBtnClick()
        cancelBtnClick()
    }

    private fun initView() {
        binding.ivBouquet.load(bouquetInfo.imageUrl)
        binding.tvBouquetMeaning.text = bouquetInfo.meaning
        binding.tvBouquetName.text = bouquetInfo.name
    }

    private fun confirmBtnClick() {
        binding.btnConfirm.setOnClickListener {
            dismiss()

            // 선물페이지4로 이동
            val intent = Intent(requireContext(), WriteMessageActivity::class.java)
            intent.putExtra("FLOWER_KEY", bouquetInfo)
            startActivity(intent)
        }
    }

    private fun cancelBtnClick() {
        binding.btnCancel.setOnClickListener {
            dismiss()
        }
    }
}