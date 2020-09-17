package com.mykuyademo

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.mykuyademo.network.RetrofitService
import com.mykuyademo.utils.ProgressDialogUtils
import kotlinx.coroutines.*

class HomePresenter: ViewModel(){
    val productAdapter= ProductAdapter()
    val newsAdapter= NewsAdapter()
    fun initData(context: Context){
        ProgressDialogUtils.instance?.showProgressDialog(context)
        val servicesApi= RetrofitService.newInstance().servicesApi
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val resultProduct = servicesApi.getProductListAsync(
                )
                val resultNews = servicesApi.getNews(
                )

                withContext(Dispatchers.Main) {
                    ProgressDialogUtils.instance?.closeProgressDialog()
                    productAdapter.updateData(resultProduct)
                    newsAdapter.updateData(resultNews)

                }
            } catch (e: Exception) {
                e.printStackTrace()
                withContext(Dispatchers.Main) {
                    //handle error in here
                    ProgressDialogUtils.instance?.closeProgressDialog()
                }
            }

        }
    }

    fun openExpend(view: View){
        productAdapter.updateExpandList()
        if(productAdapter.isExpandList){
            (view as ImageView).setImageResource(R.drawable.ic_up)
        }else{
            (view as ImageView).setImageResource(R.drawable.ic_down)
        }
    }
    fun openMap(view: View){
        view.findNavController().navigate(R.id.action_homeFragment_to_mapFragment)
    }
}