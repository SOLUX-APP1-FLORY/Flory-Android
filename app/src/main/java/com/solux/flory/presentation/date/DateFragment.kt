package com.solux.flory.presentation.date

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import com.solux.flory.databinding.FragmentDateBinding
import com.solux.flory.presentation.date.record.ModifyActivity
import com.solux.flory.presentation.date.record.RecordActivity
import com.solux.flory.util.base.BindingFragment

class DateFragment : BindingFragment<FragmentDateBinding>(FragmentDateBinding::inflate) {
    private val viewModel by activityViewModels<DateViewModel>()
    private lateinit var adapter: DateAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        observeDateYear()
        observeDateMonth()
        leftArrowClick()
        rightArrowClick()
        addFabClick()
    }

    private fun initAdapter() {
        adapter = DateAdapter() {
            val intent = Intent(requireContext(), ModifyActivity::class.java)
            intent.putExtra("date", it)
            startActivity(intent)
        }
        binding.rvDate.adapter = adapter
        viewModel.dateList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun observeDateYear() {
        viewModel.year.observe(viewLifecycleOwner) {
            binding.tvDateYear.text = it
        }
    }

    private fun observeDateMonth() {
        viewModel.month.observe(viewLifecycleOwner) {
            binding.tvDateMonth.text = it
        }
    }

    private fun leftArrowClick() {
        binding.ivDateLeftArrow.setOnClickListener {
            viewModel.moveToPreviousMonth()
        }
    }

    private fun rightArrowClick() {
        binding.ivDateRightArrow.setOnClickListener {
            viewModel.moveToNextMonth()
        }
    }

    private fun addFabClick() {
        binding.fabDateAdd.setOnClickListener {
            val intent = Intent(requireContext(), RecordActivity::class.java)
            startActivity(intent)
        }
    }

}