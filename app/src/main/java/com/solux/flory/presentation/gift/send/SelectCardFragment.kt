package com.solux.flory.presentation.gift.send

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.FragmentGiftSelectCardBinding
import com.solux.flory.presentation.gift.send.viewModel.SendViewModel
import com.solux.flory.util.base.BindingFragment
import com.solux.flory.util.fragment.stringOf
import com.solux.flory.util.setupToolbarClickListener

class SelectCardFragment : BindingFragment<FragmentGiftSelectCardBinding>(FragmentGiftSelectCardBinding::inflate) {
    private val viewModel by viewModels<SendViewModel>()

//    var selectedImageView: ImageView? = null
    lateinit var bouquetInfo: BouquetInfo
    var message: String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            message = it.getString(MESSAGE, "")
            bouquetInfo = it.getSerializable(FLOWER_KEY) as? BouquetInfo
                ?: BouquetInfo(
                    imageUrl = "",
                    meaning = "",
                    name = ""
                )
        } ?: run {
            throw IllegalStateException("Arguments are required")
        }

        viewModel.setMessage(message)
        viewModel.setBouquetInfo(bouquetInfo)

        initView()
        initToolbar()
        selectColor()
        sendBtnClick()
    }

    private fun initView() {
        bouquetInfo?.let {
            binding.ivBouquet.load(it.imageUrl)
            binding.tvCardMessage.text = viewModel.message.value ?: ""
        }

        // peach로 기본 설정
        viewModel.setImageView(binding.ivSelectPeach)
    }

    private fun initToolbar() {
        with(binding.toolbarSelectCard) {
            tvToolbarTitle.text = stringOf(R.string.tv_gift_toolbar_title)
            setupToolbarClickListener(ibToolbar2LeftIcon)
        }
    }


    private fun selectColor() {
        initPeachClickListener()
        initGrayClickListener()
        initBlueClickListener()
        initPurpleClickListener()
        initYellowClickListener()
    }

    private fun initPeachClickListener() {
        // peach
        binding.ivSelectPeach.setOnClickListener {
            if(viewModel.selectedImageView != binding.ivSelectPeach) {
                viewModel.setImageView(binding.ivSelectPeach)
                binding.ivCard.setImageResource(R.drawable.ic_card_peach)
                viewModel.setCardColor("peach")
            }
        }
    }

    private fun initGrayClickListener() {
        // gray
        binding.ivSelectGray.setOnClickListener {
            if(viewModel.selectedImageView != binding.ivSelectGray) {
                viewModel.setImageView(binding.ivSelectGray)
                binding.ivCard.setImageResource(R.drawable.ic_card_gray)
                viewModel.setCardColor("gray")
            }
        }
    }

    private fun initBlueClickListener() {
        // blue
        binding.ivSelectBlue.setOnClickListener {
            if(viewModel.selectedImageView != binding.ivSelectBlue) {
                viewModel.setImageView(binding.ivSelectBlue)
                binding.ivCard.setImageResource(R.drawable.ic_card_blue)
                viewModel.setCardColor("blue")
            }
        }
    }

    private fun initPurpleClickListener() {
        // purple
        binding.ivSelectPurple.setOnClickListener {
            if(viewModel.selectedImageView != binding.ivSelectPurple) {
                viewModel.setImageView(binding.ivSelectPurple)
                binding.ivCard.setImageResource(R.drawable.ic_card_purple)
                viewModel.setCardColor("purple")
            }
        }
    }

    private fun initYellowClickListener() {
        // yellow
        binding.ivSelectYellow.setOnClickListener {
            if(viewModel.selectedImageView != binding.ivSelectYellow) {
                viewModel.setImageView(binding.ivSelectYellow)
                binding.ivCard.setImageResource(R.drawable.ic_card_yellow)
                viewModel.setCardColor("yellow")
            }
        }
    }

    private fun sendBtnClick() {
        binding.btnSelectCardNext.setOnClickListener {
            val bundle = Bundle().apply {
                putSerializable(FLOWER_KEY, bouquetInfo)
            }

            findNavController().navigate(R.id.action_fragment_select_card_to_fragment_send_complete, bundle)
        }
    }

    companion object {
        const val FLOWER_KEY = "selectedFlower"
        const val MESSAGE = "message"
    }
}