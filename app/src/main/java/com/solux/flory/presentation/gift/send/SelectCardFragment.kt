package com.solux.flory.presentation.gift.send

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.FragmentGiftSelectCardBinding
import com.solux.flory.presentation.gift.send.BouquetDialogFragment.Companion.NEIGHBOR_KEY
import com.solux.flory.presentation.gift.send.viewModel.SendViewModel
import com.solux.flory.util.base.BindingFragment
import com.solux.flory.util.fragment.stringOf
import com.solux.flory.util.setupToolbarClickListener

class SelectCardFragment :
    BindingFragment<FragmentGiftSelectCardBinding>(FragmentGiftSelectCardBinding::inflate) {
    private val viewModel by viewModels<SendViewModel>()

    //    var selectedImageView: ImageView? = null
    lateinit var bouquetInfo: BouquetInfo
    var message: String = ""
    var neighborName: String? = null

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
            neighborName = it.getString(NEIGHBOR_KEY)
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
            binding.ivSelectCardBouquet.load(it.imageUrl)
            binding.tvSelectCardMessage.text = viewModel.message.value ?: ""
        }

        // peach로 기본 설정
        viewModel.setImageView(binding.ivSelectCardPeach)
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
        binding.ivSelectCardPeach.setOnClickListener {
            if (viewModel.selectedImageView != binding.ivSelectCardPeach) {
                viewModel.setImageView(binding.ivSelectCardPeach)
                binding.ivSelectCardImage.setImageResource(R.drawable.ic_card_peach)
                viewModel.setCardColor("peach")
            }
        }
    }

    private fun initGrayClickListener() {
        // gray
        binding.ivSelectCardGray.setOnClickListener {
            if (viewModel.selectedImageView != binding.ivSelectCardGray) {
                viewModel.setImageView(binding.ivSelectCardGray)
                binding.ivSelectCardImage.setImageResource(R.drawable.ic_card_gray)
                viewModel.setCardColor("gray")
            }
        }
    }

    private fun initBlueClickListener() {
        // blue
        binding.ivSelectCardBlue.setOnClickListener {
            if (viewModel.selectedImageView != binding.ivSelectCardBlue) {
                viewModel.setImageView(binding.ivSelectCardBlue)
                binding.ivSelectCardImage.setImageResource(R.drawable.ic_card_blue)
                viewModel.setCardColor("blue")
            }
        }
    }

    private fun initPurpleClickListener() {
        // purple
        binding.ivSelectCardPurple.setOnClickListener {
            if (viewModel.selectedImageView != binding.ivSelectCardPurple) {
                viewModel.setImageView(binding.ivSelectCardPurple)
                binding.ivSelectCardImage.setImageResource(R.drawable.ic_card_purple)
                viewModel.setCardColor("purple")
            }
        }
    }

    private fun initYellowClickListener() {
        // yellow
        binding.ivSelectCardYellow.setOnClickListener {
            if (viewModel.selectedImageView != binding.ivSelectCardYellow) {
                viewModel.setImageView(binding.ivSelectCardYellow)
                binding.ivSelectCardImage.setImageResource(R.drawable.ic_card_yellow)
                viewModel.setCardColor("yellow")
            }
        }
    }

    private fun sendBtnClick() {
        binding.btnSelectCardNext.setOnClickListener {
            val bundle = Bundle().apply {
                putSerializable(FLOWER_KEY, bouquetInfo)
                putString(NEIGHBOR_KEY, neighborName)
            }

            findNavController().navigate(
                R.id.action_fragment_select_card_to_fragment_send_complete,
                bundle
            )
        }
    }

    companion object {
        const val FLOWER_KEY = "selectedFlower"
        const val MESSAGE = "message"
    }
}