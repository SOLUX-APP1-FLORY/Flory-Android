package com.solux.flory.presentation.profile

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.solux.flory.R
import com.solux.flory.databinding.ActivityNeighborsBinding
import com.solux.flory.presentation.gift.send.BouquetAdapter
import com.solux.flory.presentation.gift.send.BouquetDialogFragment
import com.solux.flory.presentation.gift.send.BouquetViewModel
import com.solux.flory.util.base.BindingActivity

class NeighborsActivity : BindingActivity<ActivityNeighborsBinding>(ActivityNeighborsBinding::inflate) {
    private val viewModel by viewModels<ProfileViewModel>()
    private lateinit var adapter: NeighborAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initAdapter()
        leftArrowClick()
        confirmBtnClick()
    }

    private fun initAdapter() {
        adapter = NeighborAdapter(){
            val dialog = NeighborDialogFragment(it)
            dialog.show(supportFragmentManager, dialog.tag)
        }
        binding.rvNeighborslist.adapter = adapter
        adapter.submitList(viewModel.mockNeighbors)
    }

    private fun leftArrowClick() {
        binding.ivNeighborlistLeftArrow.setOnClickListener {
            finish()
        }
    }

    private fun confirmBtnClick() {
        binding.btnNeighborlist.setOnClickListener {
            finish()
        }
    }
}