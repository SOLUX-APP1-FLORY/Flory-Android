package com.solux.flory.presentation.profile

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.solux.flory.R
import com.solux.flory.databinding.FragmentProfileBinding
import com.solux.flory.presentation.auth.LoginActivity
import com.solux.flory.util.base.BindingFragment
import com.solux.flory.util.fragment.stringOf
import com.solux.flory.util.setupToolbarClickListener

class ProfileFragment : BindingFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    private val profileViewModel by viewModels<ProfileViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initAdapter()
        profileModifyTextClick()
        neighborsTextClick()
        logoutBtnClick()
    }

    private fun initToolbar() {
        with(binding.toolbarProfile) {
            tvToolbarTitle.text = stringOf(R.string.tv_profile_toolbar_title)
            setupToolbarClickListener(ibToolbarIcon)
        }
    }

    private fun initAdapter() {
        ProfileAdapter().apply {
            binding.rvProfileNeighbors.adapter = this
            submitList(profileViewModel.mockNeighbors)
        }
    }

    private fun profileModifyTextClick() {
        binding.tvProfileModification.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_profile_to_fragment_profile_modify)
        }
    }

    private fun neighborsTextClick() {
        binding.tvProfileNeighbors.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_profile_to_fragment_neighbors)
        }
    }

    private fun logoutBtnClick() {
        binding.btnProfileLogout.setOnClickListener {
            profileViewModel.saveCheckLogin(false)

            Intent(requireContext(), LoginActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(this)
            }
        }
    }
}