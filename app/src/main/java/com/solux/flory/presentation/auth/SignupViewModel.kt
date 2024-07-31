package com.solux.flory.presentation.auth

import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignupViewModel: ViewModel() {

    var _id = MutableLiveData<String>()
    val id: LiveData<String> get() = _id

    var _pw = MutableLiveData<String>()
    val pw: LiveData<String> get() = _pw

    var _email = MutableLiveData<String>()
    val email: LiveData<String> get() = _email

    var _nickname = MutableLiveData<String>()
    val nickname: LiveData<String> get() = _nickname

    var _gender = MutableLiveData<String>("male")
    val gender: LiveData<String> get() = _gender


    fun setGender(gender: String) {
        _gender.value = gender
    }

    fun clearText(editText: EditText) {
        editText.setText("")
    }
}