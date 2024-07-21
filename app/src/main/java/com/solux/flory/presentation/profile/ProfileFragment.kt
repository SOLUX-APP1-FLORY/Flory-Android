package com.solux.flory.presentation.profile

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.solux.flory.databinding.FragmentProfileBinding
import com.solux.flory.util.base.BindingFragment

class ProfileFragment : BindingFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    private val viewModel by activityViewModels<ProfileViewModel>()
    private lateinit var adapter: ProfileAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        profileModifyTextClick()
        neighborsTextClick()
        logoutBtnClick()
    }

    private fun initAdapter() {
        adapter = ProfileAdapter()
        binding.rvProfileNeighbors.adapter = adapter
        adapter.submitList(viewModel.mockNeighbors)
    }

    private fun profileModifyTextClick() {
        binding.tvProfileModification.setOnClickListener {
            val intent = Intent(requireContext(), ProfileModifyActivity::class.java)
            startActivity(intent)
        }
    }

    private fun neighborsTextClick() {
        binding.tvProfileNeighbors.setOnClickListener {
            val intent = Intent(requireContext(), NeighborsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun logoutBtnClick() {
        binding.btnProfileLogout.setOnClickListener {
            // 커스텀 다이얼로그 띄우기
        }
    }
}