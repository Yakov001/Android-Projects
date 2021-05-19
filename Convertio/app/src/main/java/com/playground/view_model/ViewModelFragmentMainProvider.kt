package com.playground.view_model

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFragmentMainProvider(application: Application) : ViewModelProvider.Factory {
    private var mApplication = application
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelFragmentMain(mApplication) as T
    }
}