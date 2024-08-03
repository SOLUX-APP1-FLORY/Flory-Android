package com.solux.flory.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.solux.flory.R
import com.solux.flory.databinding.FragmentHomeBinding
import com.solux.flory.util.UiState
import com.solux.flory.util.base.BindingFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : BindingFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeGetDiaryCount()
        observeRangeValue()
        observeProfileState()
    }

    override fun onResume() {
        super.onResume()
        homeViewModel.getDiaryCount()
        homeViewModel.getProfile()
    }

    private fun observeProfileState() {
        homeViewModel.getProfileState.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Loading -> Unit
                is UiState.Success -> {
                    val gender = it.data.gender
                    val rangeValue = homeViewModel.rangeValue.value ?: 0
                    binding.tvHomeUserNickname.text = it.data.nickname
                    updateUserIconForGenderAndRange(gender, rangeValue)
                }
                is UiState.Empty -> Unit
                is UiState.Failure -> Unit
            }
        }.launchIn(lifecycleScope)
    }

    private fun observeGetDiaryCount() {
        homeViewModel.getDiaryCountState.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Loading -> Unit
                is UiState.Success -> {
                    Timber.d("flower count ${it.data}")
                    setViewModelData(it.data)
                }
                is UiState.Empty -> Unit
                is UiState.Failure -> Unit
            }
        }.launchIn(lifecycleScope)
    }

    private fun setViewModelData(data: Int) {
        homeViewModel.setRangeValue(data)
    }

    private fun observeRangeValue() {
        homeViewModel.rangeValue.observe(viewLifecycleOwner) { rangeValue ->
            updateBackgroundForRange(rangeValue)
            homeViewModel.getProfileState.value?.let {
                if (it is UiState.Success) {
                    updateUserIconForGenderAndRange(it.data.gender, rangeValue)
                }
            }
        }
    }

    private fun updateBackgroundForRange(value: Int) {
        val backgroundResource = getBackgroundResourceForRange(value)
        binding.clHomeFragment.setBackgroundResource(backgroundResource)
    }

    private fun updateUserIconForGenderAndRange(gender: String, value: Int) {
        val userIconResource = getUserIconResourceForGenderAndRange(gender, value)
        binding.ivHomeUserIcon.setImageResource(userIconResource)
    }

    private fun getBackgroundResourceForRange(value: Int): Int {
        return when {
            value <= 5 -> R.drawable.background_home1
            value <= 11 -> R.drawable.background_home2
            value <= 17 -> R.drawable.background_home3
            value <= 23 -> R.drawable.background_home4
            else -> R.drawable.background_home5
        }
    }

    private fun getUserIconResourceForGenderAndRange(gender: String, value: Int): Int {
        return when (gender) {
            "FEMALE" -> when {
                value <= 11 -> R.drawable.ic_home_user_female1
                value <= 17 -> R.drawable.ic_home_user_female2
                else -> R.drawable.ic_home_user_female3
            }
            "MALE" -> when {
                value <= 11 -> R.drawable.ic_home_user_male1
                value <= 17 -> R.drawable.ic_home_user_male2
                else -> R.drawable.ic_home_user_male3
            }
            else -> R.drawable.ic_home_user_female1
        }
    }
}
