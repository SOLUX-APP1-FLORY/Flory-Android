package com.solux.flory.presentation.date.record

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.FragmentFlowerDialogBinding
import com.solux.flory.util.base.BindingDialogFragment

class FlowerDialogFragment(
    private val flower: Flower
) : BindingDialogFragment<FragmentFlowerDialogBinding>(FragmentFlowerDialogBinding::inflate) {

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
        binding.ivFlower.load(flower.imageUrl)
        binding.tvFlowerMeaning.text = flower.meaning
        binding.tvFlowerName.text = flower.name
    }

    private fun confirmBtnClick() {
        binding.btnConfirm.setOnClickListener {
            dismiss()
            val intent = Intent()
            intent.putExtra("flower", flower)
            activity?.setResult(Activity.RESULT_OK, intent)
            activity?.finish()
        }
    }

    private fun cancelBtnClick() {
        binding.btnCancel.setOnClickListener {
            dismiss()
        }
    }
}