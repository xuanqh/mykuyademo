package com.mykuyademo.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.mykuyademo.R
import com.mykuyademo.enums.MainTab
import com.mykuyademo.utils.extension.getParentActivity
import java.lang.Exception


@BindingAdapter("tabSelected", "tabID")
fun mainTabSelected(
    img: ImageView,
    tabSelected: MutableLiveData<MainTab>,
    tabID: MutableLiveData<MainTab>,
) {
    val parentActivity: AppCompatActivity? = img.getParentActivity()

    if (parentActivity != null) {
        tabSelected.observe(parentActivity, Observer {
            when (tabID.value) {
                MainTab.HOME -> {
                    if (tabID.value == tabSelected.value) {
                        img.setImageResource(R.drawable.ic_menu_home_active)
                    } else {
                        img.setImageResource(R.drawable.ic_menu_home)
                    }
                }
                MainTab.MY_JOB -> {
                    if (tabID.value == tabSelected.value) {
                        img.setImageResource(R.drawable.ic_menu_myjob_active)
                    } else {
                        img.setImageResource(R.drawable.ic_menu_myjob)
                    }
                }
                MainTab.SUPPORT -> {
                    if (tabID.value == tabSelected.value) {
                        img.setImageResource(R.drawable.ic_menu_support_active)
                    } else {
                        img.setImageResource(R.drawable.ic_menu_support)
                    }
                }
                MainTab.NEWS -> {
                    if (tabID.value == tabSelected.value) {
                        img.setImageResource(R.drawable.ic_menu_inbox_active)
                    } else {
                        img.setImageResource(R.drawable.ic_menu_inbox)
                    }
                }
                else -> {
                    if (tabID.value == tabSelected.value) {
                        img.setImageResource(R.drawable.ic_menu_account_active)
                    } else {
                        img.setImageResource(R.drawable.ic_menu_account)
                    }
                }
            }


        })
    }
}
@BindingAdapter("tabTextSelected", "tabTextID")
fun mainTabSelectedText(
    tv: TextView,
    tabTextSelected: MutableLiveData<MainTab>,
    tabTextID: MutableLiveData<MainTab>,
) {
    val parentActivity: AppCompatActivity? = tv.getParentActivity()

    if (parentActivity != null) {
        tabTextSelected.observe(parentActivity, Observer {
            if (tabTextID.value == tabTextSelected.value) {
                tv.setTextColor(ContextCompat.getColor(tv.context, R.color.tab_selected_color))
            } else {
                tv.setTextColor(ContextCompat.getColor(tv.context, R.color.tab_color))
            }
        })
    }
}

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}