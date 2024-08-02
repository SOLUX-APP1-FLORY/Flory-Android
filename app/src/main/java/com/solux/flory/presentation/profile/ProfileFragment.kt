package com.solux.flory.presentation.profile

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.solux.flory.R
import com.solux.flory.databinding.FragmentProfileBinding
import com.solux.flory.domain.entity.ProfileUserEntity
import com.solux.flory.presentation.auth.LoginActivity
import com.solux.flory.util.UiState
import com.solux.flory.util.base.BindingFragment
import com.solux.flory.util.fragment.stringOf
import com.solux.flory.util.setupToolbarClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class ProfileFragment : BindingFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    private val profileViewModel by viewModels<ProfileViewModel>()
    private val neighborList = mutableListOf<NeighborInfo>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initAdapter()
        profileModifyTextClick()
        neighborsTextClick()
        logoutBtnClick()
        observeProfileState()
        observeNeighborInfoState()
    }

    private fun observeNeighborInfoState() {
        profileViewModel.getNeighborInfoState.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Loading -> Unit
                is UiState.Success -> {
                    neighborList.clear()
                    neighborList.addAll(convertStringsToNeighborInfo(it.data))
                }
                is UiState.Empty -> Unit
                is UiState.Failure -> Unit
            }
        }.launchIn(lifecycleScope)
    }

    private fun convertStringsToNeighborInfo(strings: List<String>): List<NeighborInfo> {
        return strings.map { NeighborInfo(profileName = it) }
    }

    private fun observeProfileState() {
        profileViewModel.getProfileState.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Loading -> Unit
                is UiState.Success -> initUserProfile(it.data)
                is UiState.Empty -> Unit
                is UiState.Failure -> Unit
            }
        }.launchIn(lifecycleScope)
    }

    private fun initUserProfile(data: ProfileUserEntity) {
        with(binding) {
            tvProfileName.text = data.nickname
            tvProfileEmail.text = data.email
            tvProfileBirth.text = data.birthdate
            tvProfileSex.text = when (data.gender) {
                "FEMALE" -> "여성"
                "MALE" -> "남성"
                else -> "미정"
            }
        }
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
            submitList(neighborList)
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