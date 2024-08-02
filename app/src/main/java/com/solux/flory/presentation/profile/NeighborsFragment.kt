package com.solux.flory.presentation.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.solux.flory.R
import com.solux.flory.databinding.FragmentNeighborsBinding
import com.solux.flory.util.UiState
import com.solux.flory.util.base.BindingFragment
import com.solux.flory.util.fragment.stringOf
import com.solux.flory.util.setupToolbarClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class NeighborsFragment :
    BindingFragment<FragmentNeighborsBinding>(FragmentNeighborsBinding::inflate) {
    private val neighborsViewModel by activityViewModels<NeighborsViewModel>()
    private val neighborList = mutableListOf<NeighborInfo>()
    private lateinit var adapter: NeighborAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        confirmBtnClick()
        observeNeighborInfoState()
    }

    private fun observeNeighborInfoState() {
        neighborsViewModel.getNeighborInfoState.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Loading -> Unit
                is UiState.Success -> {
                    neighborList.clear()
                    neighborList.addAll(convertStringsToNeighborInfo(it.data))
                    initAdapter(neighborList)
                }

                is UiState.Empty -> Unit
                is UiState.Failure -> Unit
            }
        }.launchIn(lifecycleScope)
    }

    private fun convertStringsToNeighborInfo(strings: List<String>): List<NeighborInfo> {
        return strings.map { NeighborInfo(profileName = it) }
    }

    private fun initToolbar() {
        with(binding.toolbarNeighbors) {
            tvToolbarTitle.text = stringOf(R.string.tv_neighbors_toolbar_title)
            setupToolbarClickListener(ibToolbarIcon)
        }
    }

    private fun initAdapter(neighborList: List<NeighborInfo>) {
        adapter = NeighborAdapter() {
            val dialog = NeighborDialogFragment(it)
            dialog.show(parentFragmentManager, dialog.tag)
        }
        binding.rvNeighbors.adapter = adapter
        adapter.submitList(neighborList)
    }

    private fun confirmBtnClick() {
        binding.btnNeighborsConfirm.setOnClickListener {
            findNavController().navigate(
                R.id.action_fragment_neighbors_to_fragment_profile
            )
        }
    }
}