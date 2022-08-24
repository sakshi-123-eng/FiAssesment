package com.sakshi.fiassesment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



class MainViewModel : ViewModel() {
    val panNumLiveData = MutableLiveData<String>()
    val day = MutableLiveData<String>()
    val month = MutableLiveData<String>()
    val year = MutableLiveData<String>()
    val showToast = MutableLiveData<Boolean>()
    val dismissActivity = MutableLiveData<Boolean>()

    val regexPan = "[A-Z]{5}[0-9]{4}[A-Z]{1}"
    val regexDay = "(3[01]|[12][0-9]|0[1-9])"
    val regexMonth = "^(1[0-2]|0[1-9])"
    val regexYear = "^(19[0-9]{2}|200[0-4])"

    fun showToast() {
        if (day.value != null && day.value!!.matches(Regex(regexDay)) && panNumLiveData.value != null && panNumLiveData.value!!.matches(
                Regex(regexPan)
            ) && month.value != null && month.value!!.matches(Regex(regexMonth)) && year.value != null && year.value!!.matches(
                Regex(regexYear)
            )
        ) {
            showToast.value = true
        } else showToast.value = true
    }


    fun dismiss() {
        dismissActivity.value = true
    }

}