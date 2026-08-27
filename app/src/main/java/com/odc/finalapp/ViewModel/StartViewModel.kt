package com.odc.finalapp.ViewModel

import androidx.lifecycle.ViewModel
import com.odc.finalapp.Model.StartModel

class StartViewModel: ViewModel() {
    private val ml = StartModel()
    fun getMessage(): String {
        return ml.msg
    }
}