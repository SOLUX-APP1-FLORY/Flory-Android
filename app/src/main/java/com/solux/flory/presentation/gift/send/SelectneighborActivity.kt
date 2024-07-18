package com.solux.flory.presentation.gift.send

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.solux.flory.databinding.ActivityGiftSelectNeighborBinding
import com.solux.flory.presentation.profile.NeighborInfo
import com.solux.flory.presentation.profile.ProfileViewModel
import com.solux.flory.util.base.BindingActivity

class SelectneighborActivity : BindingActivity<ActivityGiftSelectNeighborBinding>(ActivityGiftSelectNeighborBinding::inflate){
    private lateinit var adapter: SelectneighborAdapter
    private val viewModel by viewModels<ProfileViewModel>()
    private var selectedNeighbor: NeighborInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initAdapter()
        confimBtnClick()
        impossibleBtnClick()
    }

    private fun initAdapter() {
        adapter = SelectneighborAdapter { _ -> }
        binding.rvGiftSendNeighbor.adapter = adapter
        adapter.submitList(viewModel.mockNeighbors)

    }

    private fun confimBtnClick() {
        binding.btnSelectNeighborConfirm.setOnClickListener {
            selectedNeighbor = adapter.getSelectedNeighbor()
            selectedNeighbor?.let { neighbor ->
                val intent = Intent(this@SelectneighborActivity, SelectBouquetActivity::class.java)
                intent.putExtra("selectedNeighbor", neighbor)
                startActivity(intent)
            } ?: run {
                Toast.makeText(this, "선택된 이웃이 없습니다", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun impossibleBtnClick(){
        binding.ivSelectNeighborImpossible.setOnClickListener{
            finish()
        }
    }
}