package com.solux.flory.presentation.gift

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.solux.flory.databinding.FragmentGiftSearchNeighborBinding
import com.solux.flory.util.Debouncer
import com.solux.flory.util.UiState
import com.solux.flory.util.base.BindingFragment
import com.solux.flory.util.fragment.stringOf
import com.solux.flory.util.fragment.toast
import com.solux.flory.util.setupToolbarClickListener
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SearchNeighborFragment : BindingFragment<FragmentGiftSearchNeighborBinding>({
    FragmentGiftSearchNeighborBinding.inflate(it)
}) {
    private val searchNeighborViewModel by viewModels<SearchNeighborViewModel>()
    private lateinit var adapter: SearchNeighborAdapter
    private val debouncer = Debouncer<String>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initAdapter()
        etSearchNeighborFilter()
        observeNeighborSearchState()
        observeNeighborFollowState()
    }

    private fun observeNeighborFollowState() {
        searchNeighborViewModel.postNeighborFollowState.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Loading -> Unit
                is UiState.Success -> toast(it.data)
                is UiState.Empty -> Unit
                is UiState.Failure -> Unit
            }
        }.launchIn(lifecycleScope)
    }

    private fun initAdapter() {
        adapter = SearchNeighborAdapter() { nickname ->
            debouncer.setDelay(nickname, 1000L) {
                searchNeighborViewModel.postNeighborFollow(nickname)
            }
        }
        adapter.submitList(emptyList())
        binding.rvSearchNeighbor.adapter = adapter
    }

    private fun observeNeighborSearchState() {
        searchNeighborViewModel.getNeighborSearchState.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Loading -> Unit
                is UiState.Success -> {
                    adapter.submitList(it.data)
                }

                is UiState.Empty -> Unit
                is UiState.Failure -> Unit
            }
        }.launchIn(lifecycleScope)
    }

    private fun etSearchNeighborFilter() {
        binding.etSearchNeighborNickname.addTextChangedListener {
            val nickname = it.toString().trim()
            if (nickname.isNotBlank()) {
                searchNeighborViewModel.getNeighborSearch(nickname)
            } else {
                adapter.submitList(emptyList())
            }
        }
    }

    private fun initToolbar() {
        with(binding.toolbarSearchNeighbor) {
            tvToolbarTitle.text = stringOf(com.solux.flory.R.string.tv_gift_search_neighbor_title)
            setupToolbarClickListener(ibToolbarIcon)
        }
    }
}