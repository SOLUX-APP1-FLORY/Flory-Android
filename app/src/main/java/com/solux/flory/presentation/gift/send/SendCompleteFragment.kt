package com.solux.flory.presentation.gift.send

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.FragmentGiftSendCompleteBinding
import com.solux.flory.util.base.BindingFragment

class SendCompleteFragment : BindingFragment<FragmentGiftSendCompleteBinding>(FragmentGiftSendCompleteBinding::inflate) {
    lateinit var bouquetInfo: BouquetInfo
    lateinit var userName: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 데이터 받기
        arguments?.let {
            bouquetInfo = it.getSerializable(FLOWER_KEY) as? BouquetInfo ?: BouquetInfo(
                imageUrl = "",
                meaning = "",
                name = ""
            )
            userName = it.getString(USER_NAME_KEY, "User")
        }

        // 데이터 설정
        binding.ivBouquet.load(bouquetInfo.imageUrl)
        binding.tvCompleteMessage.text = getString(R.string.send_complete, userName)
        gotoMain()

    }

    private fun gotoMain() {
        binding.btnGoNext.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_send_complete_to_fragment_home)
        }
    }

    companion object {
        const val FLOWER_KEY = "selectedFlower"
        const val USER_NAME_KEY = "userName"
    }
}