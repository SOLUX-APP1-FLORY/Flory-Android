package com.solux.flory.presentation.gift.send

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.FragmentGiftSendCompleteBinding
import com.solux.flory.presentation.gift.send.BouquetDialogFragment.Companion.NEIGHBOR_KEY
import com.solux.flory.util.base.BindingFragment

class SendCompleteFragment :
    BindingFragment<FragmentGiftSendCompleteBinding>(FragmentGiftSendCompleteBinding::inflate) {
    private lateinit var bouquetInfo: BouquetInfo
    private var neighborName: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 데이터 받기
        arguments?.let {
            bouquetInfo = it.getSerializable(FLOWER_KEY) as? BouquetInfo ?: BouquetInfo(
                imageUrl = "",
                meaning = "",
                name = ""
            )
            neighborName = it.getString(NEIGHBOR_KEY, "User")
        }

        // 데이터 설정
        binding.ivBouquet.load(bouquetInfo.imageUrl)
        binding.tvCompleteMessage.text = getString(R.string.send_complete, neighborName)
        gotoMain()

    }

    private fun gotoMain() {
        binding.btnSendCompleteGoNext.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_send_complete_to_fragment_home)
        }
    }

    companion object {
        const val FLOWER_KEY = "selectedFlower"
    }
}