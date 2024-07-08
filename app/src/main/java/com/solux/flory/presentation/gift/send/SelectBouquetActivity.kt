package com.solux.flory.presentation.gift.send

import android.os.Bundle
import androidx.activity.viewModels
import com.solux.flory.databinding.ActivityGiftSelectbouquetBinding
import com.solux.flory.util.base.BindingActivity

class SelectBouquetActivity : BindingActivity<ActivityGiftSelectbouquetBinding>(ActivityGiftSelectbouquetBinding::inflate){
    private val viewModel by viewModels<BouquetViewModel>()
    private lateinit var adapter: BouquetAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAdapter()
        impossibleBtnClick()
    }

    private fun initAdapter() {
        adapter = BouquetAdapter(){
            val dialog = BouquetDialogFragment(it)
            dialog.show(supportFragmentManager, dialog.tag)
        }
        binding.rvBouquets.adapter = adapter
        adapter.submitList(viewModel.mockBouquet)
    }

    private fun impossibleBtnClick(){
        binding.ivSelectbouquetImpossible.setOnClickListener{
            finish()
        }
    }
}