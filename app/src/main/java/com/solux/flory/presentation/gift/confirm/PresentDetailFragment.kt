package com.solux.flory.presentation.gift.confirm

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.FragmentGiftDetailBinding
import com.solux.flory.domain.entity.BouquetDetailEntity
import com.solux.flory.util.UiState
import com.solux.flory.util.base.BindingFragment
import com.solux.flory.util.setupToolbarClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

@AndroidEntryPoint
class PresentDetailFragment :
    BindingFragment<FragmentGiftDetailBinding>(FragmentGiftDetailBinding::inflate) {
    private val presentViewModel by viewModels<PresentViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val giftId = arguments?.getInt(GIFTCONFIRM_KEY) ?: 0
        presentViewModel.getBouquetDetail(giftId)

        initToolbar()
        confirmBtnClick()
        observeGetBouquetDetailState()
    }

    private fun observeGetBouquetDetailState() {
        presentViewModel.getBouquetDetailState.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Loading -> Unit
                is UiState.Success -> {
                    updateView(it.data)
                }

                is UiState.Empty -> Unit
                is UiState.Failure -> Unit
            }
        }.launchIn(lifecycleScope)
    }

    private fun updateView(presentInfo: BouquetDetailEntity) {
        presentInfo?.let {
            binding.ivGiftDetailImage.load(it.bouquetImageUrl)
            binding.tvGiftDetailText.text = it.content
            binding.tvGiftDetailSender.text = it.sender
            binding.tvGiftDetailCreatedat.text = formatDateTime(it.createdAt)
        }
    }

    private fun initToolbar() {
        with(binding.toolbarGiftDetail) {
            setupToolbarClickListener(ibToolbarIcon)
            mdProfileDivider.visibility = View.GONE
        }
    }

    private fun confirmBtnClick() {
        binding.btnGiftDetailConfirm.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_gift_detail_to_fragment_gift_confirm)
        }
    }


    companion object {
        const val GIFTCONFIRM_KEY = "presentInfo"
    }

    private fun formatDateTime(dateTimeStr: String): String {
        // Convert microseconds to milliseconds by trimming last 3 digits
        val adjustedDateTimeStr = if (dateTimeStr.length > 23) {
            dateTimeStr.substring(0, 23) // Trim microseconds to milliseconds
        } else {
            dateTimeStr
        }

        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")
        val outputFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")

        return try {
            val dateTime = LocalDateTime.parse(adjustedDateTimeStr, formatter)
            dateTime.format(outputFormatter)
        } catch (e: DateTimeParseException) {
            // Log the exception message for debugging
            e.printStackTrace()
            "Invalid date format"
        }
    }
}
