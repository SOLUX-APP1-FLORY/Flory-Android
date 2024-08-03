package com.solux.flory.presentation.record

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import com.solux.flory.databinding.ActivitySelectFlowerBinding
import com.solux.flory.util.base.BindingActivity

class SelectFlowerActivity :
    BindingActivity<ActivitySelectFlowerBinding>(ActivitySelectFlowerBinding::inflate) {
    private val viewModel by viewModels<FlowerViewModel>()
    private lateinit var adapter: FlowerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAdapter()
        searchFilter()
    }

    private fun searchFilter() {
        binding.etSearch.addTextChangedListener {
            adapter.submitList(viewModel.mockFlowers.filter { flower ->
                flower.meaning.contains(it.toString(), ignoreCase = true)
            })
        }
    }

    private fun initAdapter() {
        adapter = FlowerAdapter() {
            val dialog = FlowerDialogFragment(it)
            dialog.show(supportFragmentManager, dialog.tag)
        }
        binding.rvFlowers.adapter = adapter
        adapter.submitList(viewModel.mockFlowers)
    }
}