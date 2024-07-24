package com.solux.flory.util

import android.app.Activity
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.setupToolbarClickListener(button: ImageButton) {
    button.setOnClickListener {
        findNavController().popBackStack()
    }
}

fun Activity.setupToolbarClickListener(button: ImageButton) {
    button.setOnClickListener {
        finish()
    }
}