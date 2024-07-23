package com.solux.flory.presentation.record

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.FragmentRecordBinding
import com.solux.flory.util.base.BindingFragment
import com.solux.flory.util.fragment.stringOf
import com.solux.flory.util.setupToolbarClickListener

class RecordFragment : BindingFragment<FragmentRecordBinding>({
    FragmentRecordBinding.inflate(it)
}) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        plantAreaClick()
        confirmBtnClick()
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
            val flower = data?.getSerializableExtra("flower") as Flower
            with(binding) {
                ivRecordPlant.load(flower.imageUrl)
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
            findNavController().navigate(R.id.action_fragment_record_to_fragment_date)
        }
    }
}