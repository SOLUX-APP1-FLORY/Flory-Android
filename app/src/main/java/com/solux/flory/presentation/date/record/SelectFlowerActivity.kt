package com.solux.flory.presentation.date.record

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil.setContentView
import com.solux.flory.R
import com.solux.flory.databinding.ActivitySelectFlowerBinding
import com.solux.flory.util.base.BindingActivity

class SelectFlowerActivity : BindingActivity<ActivitySelectFlowerBinding>(ActivitySelectFlowerBinding::inflate) {
    private val viewModel by viewModels<FlowerViewModel>()
    private lateinit var adapter: FlowerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        adapter = FlowerAdapter()
        binding.rvFlowers.adapter = adapter
        adapter.submitList(viewModel.mockFlowers)
    }
}