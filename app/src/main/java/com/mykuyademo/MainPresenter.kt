package com.mykuyademo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mykuyademo.enums.MainTab

class MainPresenter {
    val tabIndex=  MutableLiveData(MainTab.HOME)
    val tabHome = MutableLiveData(MainTab.HOME)
    val tabMyJob = MutableLiveData(MainTab.MY_JOB)
    val tabSupport = MutableLiveData(MainTab.SUPPORT)
    val tabNews = MutableLiveData(MainTab.NEWS)
    val tabAccount = MutableLiveData(MainTab.ACCOUNT)

    fun onHomeTab(tab: MainTab){
        tabIndex.value = tab
        Log.d("MainPresenter", "Tab: "+tab.name)
    }
}