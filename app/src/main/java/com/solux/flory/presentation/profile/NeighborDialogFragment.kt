package com.solux.flory.presentation.profile

import android.app.Dialog
import android.os.Bundle
import android.view.View
import coil.load
import coil.transform.CircleCropTransformation
import com.solux.flory.R
import com.solux.flory.databinding.FragmentFollowCancelDialogBinding
import com.solux.flory.util.base.BindingDialogFragment

class NeighborDialogFragment(
    private val neighborInfo: NeighborInfo
) : BindingDialogFragment<FragmentFollowCancelDialogBinding>(FragmentFollowCancelDialogBinding::inflate) {

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
        with(binding){
            ivNeighborImage.load(neighborInfo.profileImage) {
                transformations(CircleCropTransformation())
            }
            tvNeighborNickname.text = neighborInfo.profileName
            tvNeighborNicknameInfo.text = neighborInfo.profileName
        }
    }

    private fun confirmBtnClick() {
        binding.btnFollowCancleYes.setOnClickListener {
            dismiss()
            //팔로우 끊기 기능 구현
        }
    }

    private fun cancelBtnClick() {
        binding.btnFollowCancleNo.setOnClickListener {
            dismiss()
        }
    }
}