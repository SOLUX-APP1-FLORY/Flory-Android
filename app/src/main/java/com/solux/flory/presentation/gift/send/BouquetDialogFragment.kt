package com.solux.flory.presentation.gift.send

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.FragmentGiftBinding
import com.solux.flory.databinding.FragmentGiftDialogBinding
import com.solux.flory.presentation.date.record.RecordActivity
import com.solux.flory.util.base.BindingDialogFragment

class BouquetDialogFragment(
    private val bouquet: Bouquet
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
        binding.ivBouquet.load(bouquet.imageUrl)
        binding.tvBouquetMeaning.text = bouquet.meaning
        binding.tvBouquetName.text = bouquet.name
    }

    private fun confirmBtnClick() {
        binding.btnConfirm.setOnClickListener {
            dismiss()
            val intent = Intent(requireContext(), RecordActivity::class.java)
            intent.putExtra("bouquet", bouquet)
            startActivity(intent)
        }
    }

    private fun cancelBtnClick() {
        binding.btnCancel.setOnClickListener {
            dismiss()
        }
    }
}