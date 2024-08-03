package com.solux.flory.presentation.record

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.FragmentRecordBinding
import com.solux.flory.presentation.record.FlowerDialogFragment.Companion.FLOWER_KEY
import com.solux.flory.util.UiState
import com.solux.flory.util.base.BindingFragment
import com.solux.flory.util.fragment.stringOf
import com.solux.flory.util.fragment.toast
import com.solux.flory.util.setupToolbarClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.time.LocalDate

@AndroidEntryPoint
class RecordFragment : BindingFragment<FragmentRecordBinding>({
    FragmentRecordBinding.inflate(it)
}) {
    private val recordViewModel by viewModels<RecordViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initToolbar()
        plantAreaClick()
        confirmBtnClick()
        observeProfileState()
        observePostDiaryState()
    }

    private fun observeProfileState() {
        recordViewModel.getProfileState.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Loading -> Unit
                is UiState.Success -> binding.tvRecordNickname.text = it.data.nickname
                is UiState.Empty -> Unit
                is UiState.Failure -> Unit
            }
        }.launchIn(lifecycleScope)
    }

    private fun observePostDiaryState() {
        recordViewModel.postDiaryState.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Loading -> Unit
                is UiState.Success -> {
                    toast(it.data)
                    findNavController().navigate(R.id.action_fragment_record_to_fragment_date)
                }

                is UiState.Empty -> Unit
                is UiState.Failure -> Unit
            }
        }.launchIn(lifecycleScope)
    }

    private fun initView() {
        binding.tvRecordDate.text =
            LocalDate.now().month.toString() + "." + LocalDate.now().dayOfMonth.toString()
    }

    private fun initToolbar() {
        with(binding.toolbarRecord) {
            tvToolbarTitle.text = stringOf(R.string.tv_record_toolbar_title)
            setupToolbarClickListener(ibToolbarIcon)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            val flower = data?.getSerializableExtra(FLOWER_KEY) as Flower
            with(binding) {
                ivRecordPlant.load(flower.imageUrl)
                recordViewModel.setFlowerSelected(true)
                tvRecordPickFlower.visibility = View.INVISIBLE
                tvRecordFlowerMeaning.text = flower.meaning
                tvRecordFlowerName.text = flower.name
            }
        }
    }

    private fun plantAreaClick() {
        binding.clRecordPlant.setOnClickListener {
            val intent = Intent(requireContext(), SelectFlowerActivity::class.java)
            startActivityForResult(intent, 0)
        }
    }

    private fun confirmBtnClick() {
        binding.btnRecordConfirm.setOnClickListener {
            with(binding) {
                if (recordViewModel.isFlowerSelected.value == true && etRecordTitle.text.isNotBlank() && etRecordContent.text.isNotBlank()) {
                    recordViewModel.postDiary(
                        tvRecordFlowerName.text.toString(),
                        etRecordTitle.text.toString(),
                        etRecordContent.text.toString()
                    )
                } else {
                    toast(stringOf(R.string.tv_record_impossible))
                }
            }
        }
    }
}