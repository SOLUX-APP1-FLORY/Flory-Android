package com.solux.flory.presentation.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.fragment.findNavController
import com.solux.flory.R
import com.solux.flory.databinding.FragmentProfileModifyBinding
import com.solux.flory.util.UiState
import com.solux.flory.util.base.BindingFragment
import com.solux.flory.util.fragment.stringOf
import com.solux.flory.util.fragment.toast
import com.solux.flory.util.setupToolbarClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class ProfileModifyFragment : BindingFragment<FragmentProfileModifyBinding>({
    FragmentProfileModifyBinding.inflate(it)
}) {
    private val profileModifyViewModel by viewModels<ProfileModifyViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        maleSelected()
        femaleSelected()
        modifyBtnClick()
        observePatchProfileModifyState()
    }

    private fun observePatchProfileModifyState() {
        profileModifyViewModel.patchProfileModifyState.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Loading -> Unit
                is UiState.Success -> {
                    toast(stringOf(R.string.tv_profile_modify_complete))
                    findNavController().navigate(
                        R.id.action_fragment_profile_modify_to_fragment_profile
                    )
                }

                is UiState.Empty -> Unit
                is UiState.Failure -> Unit

            }
        }
    }

    private fun initToolbar() {
        with(binding.toolbarProfileModify) {
            tvToolbarTitle.text = stringOf(R.string.tv_profile_modify_toolbar_title)
            setupToolbarClickListener(ibToolbarIcon)
        }
    }

    private fun modifyBtnClick() {
        binding.btnProfileModify.setOnClickListener {
            with(binding) {
                if (etModifyNickname.text.isNotBlank() && etModifyBirthdate.text.isNotBlank() && (clModifySexMale.isSelected || clModifySexFemale.isSelected)) {
                    profileModifyViewModel.patchProfileModify(
                        etModifyNickname.text.toString(),
                        if (clModifySexMale.isSelected) "MALE" else "FEMALE",
                        etModifyBirthdate.text.toString()
                    )
                } else {
                    toast(stringOf(R.string.tv_profile_modify_error))
                }
            }
        }
    }

    private fun femaleSelected() {
        with(binding) {
            clModifySexFemale.setOnClickListener {
                clModifySexMale.isSelected = false
                clModifySexFemale.isSelected = true
                ivModifyFemaleCheck.visibility = View.VISIBLE
                ivModifyMaleCheck.visibility = View.INVISIBLE
            }
        }
    }

    private fun maleSelected() {
        with(binding) {
            clModifySexMale.setOnClickListener {
                clModifySexMale.isSelected = true
                clModifySexFemale.isSelected = false
                ivModifyMaleCheck.visibility = View.VISIBLE
                ivModifyFemaleCheck.visibility = View.INVISIBLE
            }
        }
    }

}