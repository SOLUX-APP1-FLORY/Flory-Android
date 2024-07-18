package com.solux.flory.presentation.gift.confirm

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.solux.flory.databinding.ActivityGiftConfirmBinding
import com.solux.flory.util.base.BindingActivity

class ConfirmActivity : BindingActivity<ActivityGiftConfirmBinding>(ActivityGiftConfirmBinding::inflate){
    private val viewModel by viewModels<PresentViewModel>()
    private lateinit var adapter: PresentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAdapter()
        impossibleBtnClick()
    }

    private fun initAdapter() {
        adapter = PresentAdapter{
            Intent(this, PresentDetailActivity::class.java).apply{
                putExtra("presentInfo", it)
                startActivity(this)
            }
        }
        binding.rvPresents.adapter = adapter
        adapter.submitList(viewModel.mockPresent)
    }

    private fun impossibleBtnClick(){
        binding.ivGiftconfirmImpossible.setOnClickListener{
            finish()
        }
    }
}