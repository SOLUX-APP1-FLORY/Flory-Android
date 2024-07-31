package com.solux.flory.presentation.gift

import android.os.Bundle
import android.view.View
import com.solux.flory.databinding.FragmentGiftSearchNeighborBinding
import com.solux.flory.util.base.BindingFragment
import com.solux.flory.util.fragment.stringOf
import com.solux.flory.util.setupToolbarClickListener

class SearchNeighborFragment : BindingFragment<FragmentGiftSearchNeighborBinding>({
    FragmentGiftSearchNeighborBinding.inflate(it)
}) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
    }

    private fun initToolbar() {
        with(binding.toolbarSearchNeighbor) {
            tvToolbarTitle.text = stringOf(com.solux.flory.R.string.tv_gift_search_neighbor_title)
            setupToolbarClickListener(ibToolbarIcon)
        }
    }
}