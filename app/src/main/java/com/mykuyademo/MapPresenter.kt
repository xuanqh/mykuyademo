package com.mykuyademo

import android.view.View
import androidx.navigation.findNavController

class MapPresenter{
    fun confirmClick(view: View){
        view.findNavController().popBackStack()
    }

    fun backScreen(view: View){
        view.findNavController().popBackStack()
    }
}