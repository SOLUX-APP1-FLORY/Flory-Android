package com.solux.flory.presentation.gift.send

import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.FragmentGiftDialogBinding
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
            val bundle = Bundle().apply {
                putSerializable(FLOWER_KEY, bouquetInfo)
            }

            findNavController().navigate(R.id.action_fragment_select_bouquet_to_fragment_write_message, bundle)
        }
    }

    private fun cancelBtnClick() {
        binding.btnCancel.setOnClickListener {
            dismiss()
        }
    }

    companion object {
        const val FLOWER_KEY = "selectedFlower"
    }
}