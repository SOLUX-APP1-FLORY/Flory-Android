package com.solux.flory.presentation.profile

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.fragment.findNavController
import coil.load
import coil.transform.CircleCropTransformation
import com.solux.flory.R
import com.solux.flory.databinding.FragmentFollowCancelDialogBinding
import com.solux.flory.util.UiState
import com.solux.flory.util.base.BindingDialogFragment
import com.solux.flory.util.fragment.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class NeighborDialogFragment(
    private val neighborInfo: NeighborInfo
) : BindingDialogFragment<FragmentFollowCancelDialogBinding>(FragmentFollowCancelDialogBinding::inflate) {
    private val neighborViewModel by activityViewModels<NeighborsViewModel>()

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
        observeNeighborUnfollowState()
    }

    private fun observeNeighborUnfollowState() {
        neighborViewModel.patchNeighborUnfollowState.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Loading -> Unit
                is UiState.Success -> {
                    toast(it.data)
                    dismiss()
                    findNavController().navigate(R.id.action_fragment_neighbors_to_fragment_profile)
                }

                is UiState.Empty -> Unit
                is UiState.Failure -> Unit
            }
        }
    }

    private fun initView() {
        with(binding){
            tvNeighborNickname.text = neighborInfo.profileName
            tvNeighborNicknameInfo.text = neighborInfo.profileName
        }
    }

    private fun confirmBtnClick() {
        binding.btnFollowCancleYes.setOnClickListener {
            neighborViewModel.patchNeighborUnfollow(neighborInfo.profileName)
        }
    }

    private fun cancelBtnClick() {
        binding.btnFollowCancleNo.setOnClickListener {
            dismiss()
        }
    }
}