package com.mykuyademo.utils

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.view.ContextThemeWrapper
import com.mykuyademo.R


class ProgressDialogUtils {
    private var progressDialog: AlertDialog? = null

    fun showProgressDialog(activityContext: Context) {
        if (progressDialog != null && progressDialog!!.isShowing) {
            return
        }

        val builder = AlertDialog.Builder(ContextThemeWrapper(activityContext, R.style.Theme_Progress_Dialog))
        builder.setCancelable(true) // if you want user to wait for some process to finish,
        val inflater = (activityContext as Activity).layoutInflater
        val dialogView = inflater.inflate(R.layout.layout_loading_dialog, null)
//        dialogView.setBackgroundColor(Color.TRANSPARENT)
        builder.setView(dialogView)
        progressDialog = builder.create()

        progressDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        progressDialog!!.window!!.setBackgroundDrawableResource(R.color.transparentColor)
//        progressDialog!!.window!!?.decorView?.setBackgroundColor(Color.TRANSPARENT)

        progressDialog!!.show()
    }

    fun closeProgressDialog() {
        try {
            if (progressDialog != null) {
                if(progressDialog!!.isShowing)
                {
                    progressDialog?.dismiss()
                    progressDialog = null
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    companion object {
        private var util: ProgressDialogUtils? = null

        val instance: ProgressDialogUtils?
            get() {

                if (util == null) {
                    util = ProgressDialogUtils()
                }
                return util
            }
    }
}
