package com.solux.flory.presentation.gift.send

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.FragmentGiftSelectCardBinding
import com.solux.flory.presentation.gift.send.BouquetDialogFragment.Companion.NEIGHBOR_KEY
import com.solux.flory.presentation.gift.send.viewModel.SendViewModel
import com.solux.flory.util.UiState
import com.solux.flory.util.base.BindingFragment
import com.solux.flory.util.fragment.stringOf
import com.solux.flory.util.setupToolbarClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class SelectCardFragment :
    BindingFragment<FragmentGiftSelectCardBinding>(FragmentGiftSelectCardBinding::inflate) {
    private val sendViewModel by viewModels<SendViewModel>()

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

        sendViewModel.setMessage(message)
        sendViewModel.setBouquetInfo(bouquetInfo)

        initView()
        initToolbar()
        selectColor()
        sendBtnClick()
        observeLetterState()
    }

    private fun observeLetterState() {
        sendViewModel.postLetterState.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Loading -> Unit
                is UiState.Success -> {
                    val bundle = Bundle().apply {
                        putSerializable(FLOWER_KEY, bouquetInfo)
                        putString(NEIGHBOR_KEY, neighborName)
                    }
                    findNavController().navigate(
                        R.id.action_fragment_select_card_to_fragment_send_complete,
                        bundle
                    )
                }

                is UiState.Empty -> Unit
                is UiState.Failure -> Log.e("SelectCardFragment", it.msg)
            }
        }.launchIn(lifecycleScope)
    }

    private fun initView() {
        bouquetInfo?.let {
            binding.ivSelectCardBouquet.load(it.imageUrl)
            binding.tvSelectCardMessage.text = sendViewModel.message.value ?: ""
        }

        // peach로 기본 설정
        sendViewModel.setImageView(binding.ivSelectCardPeach)
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
            if (sendViewModel.selectedImageView != binding.ivSelectCardPeach) {
                sendViewModel.setImageView(binding.ivSelectCardPeach)
                binding.ivSelectCardImage.setImageResource(R.drawable.ic_card_peach)
                sendViewModel.setCardColor("peach")
            }
        }
    }

    private fun initGrayClickListener() {
        // gray
        binding.ivSelectCardGray.setOnClickListener {
            if (sendViewModel.selectedImageView != binding.ivSelectCardGray) {
                sendViewModel.setImageView(binding.ivSelectCardGray)
                binding.ivSelectCardImage.setImageResource(R.drawable.ic_card_gray)
                sendViewModel.setCardColor("gray")
            }
        }
    }

    private fun initBlueClickListener() {
        // blue
        binding.ivSelectCardBlue.setOnClickListener {
            if (sendViewModel.selectedImageView != binding.ivSelectCardBlue) {
                sendViewModel.setImageView(binding.ivSelectCardBlue)
                binding.ivSelectCardImage.setImageResource(R.drawable.ic_card_blue)
                sendViewModel.setCardColor("blue")
            }
        }
    }

    private fun initPurpleClickListener() {
        // purple
        binding.ivSelectCardPurple.setOnClickListener {
            if (sendViewModel.selectedImageView != binding.ivSelectCardPurple) {
                sendViewModel.setImageView(binding.ivSelectCardPurple)
                binding.ivSelectCardImage.setImageResource(R.drawable.ic_card_purple)
                sendViewModel.setCardColor("purple")
            }
        }
    }

    private fun initYellowClickListener() {
        // yellow
        binding.ivSelectCardYellow.setOnClickListener {
            if (sendViewModel.selectedImageView != binding.ivSelectCardYellow) {
                sendViewModel.setImageView(binding.ivSelectCardYellow)
                binding.ivSelectCardImage.setImageResource(R.drawable.ic_card_yellow)
                sendViewModel.setCardColor("yellow")
            }
        }
    }

    private fun sendBtnClick() {
        binding.btnSelectCardNext.setOnClickListener {
            neighborName?.let { it1 -> sendViewModel.postLetter(bouquetInfo.name, it1, message) }
        }
    }

    companion object {
        const val FLOWER_KEY = "selectedFlower"
        const val MESSAGE = "message"
    }
}