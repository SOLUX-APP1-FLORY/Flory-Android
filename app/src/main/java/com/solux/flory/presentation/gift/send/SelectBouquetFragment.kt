package com.solux.flory.presentation.gift.send

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import coil.load
import coil.transform.CircleCropTransformation
import com.solux.flory.R
import com.solux.flory.databinding.FragmentGiftSelectBouquetBinding
import com.solux.flory.presentation.gift.send.BouquetDialogFragment.Companion.NEIGHBOR_KEY
import com.solux.flory.presentation.gift.send.adapter.BouquetAdapter
import com.solux.flory.presentation.gift.send.viewModel.BouquetViewModel
import com.solux.flory.presentation.profile.NeighborInfo
import com.solux.flory.util.base.BindingFragment
import com.solux.flory.util.fragment.stringOf
import com.solux.flory.util.setupToolbarClickListener

class SelectBouquetFragment :
    BindingFragment<FragmentGiftSelectBouquetBinding>(FragmentGiftSelectBouquetBinding::inflate) {
    private var neighborInfo: NeighborInfo? = null

    private val viewModel by viewModels<BouquetViewModel>()
    private lateinit var adapter: BouquetAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            neighborInfo = it.getSerializable(NEIGHBOR_KEY) as? NeighborInfo
        }
        initView()
        initAdapter()
        initToolbar()
    }

    private fun initView() {
        neighborInfo?.let {
            binding.ivGiftImage.load(it.profileImage) {
                transformations(CircleCropTransformation())
            }
            binding.tvSelectBouquetNeighborName.text = it.profileName
        }
    }

    private fun initAdapter() {
        adapter = BouquetAdapter {
            val dialog = neighborInfo?.let { it1 -> BouquetDialogFragment(it, it1.profileName) }
            dialog?.show(parentFragmentManager, dialog.tag)
        }
        binding.rvBouquets.adapter = adapter
        adapter.submitList(viewModel.mockBouquet)
    }

    private fun initToolbar() {
        with(binding.toolbarSelectBouquet) {
            tvToolbarTitle.text = stringOf(R.string.tv_gift_toolbar_title)
            setupToolbarClickListener(ibToolbar2LeftIcon)
        }
    }
}