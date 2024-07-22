package com.solux.flory.presentation.profile

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.solux.flory.R
import com.solux.flory.databinding.FragmentProfileBinding
import com.solux.flory.presentation.auth.LoginActivity
import com.solux.flory.util.base.BindingFragment

class ProfileFragment : BindingFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    private val viewModel by activityViewModels<ProfileViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        profileModifyTextClick()
        neighborsTextClick()
        logoutBtnClick()
    }

    private fun initAdapter() {
        ProfileAdapter().apply {
            binding.rvProfileNeighbors.adapter = this
            submitList(viewModel.mockNeighbors)
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
            Intent(requireContext(), LoginActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(this)
            }
        }
    }
}