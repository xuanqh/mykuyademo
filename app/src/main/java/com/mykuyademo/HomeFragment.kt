package com.mykuyademo

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mykuyademo.base.BaseFragment
import com.mykuyademo.databinding.HomeFragmentBinding


class HomeFragment : BaseFragment<HomeFragmentBinding>() {

    override fun getLayoutResId(): Int {
        return R.layout.home_fragment
    }

    override fun bindingPresenter() {
        binding.presenter = HomePresenter()
    }

    override fun bindData() {
        binding.rvProductList.layoutManager =
            GridLayoutManager(context, 3)
        binding.rvNews.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        context?.let { binding.presenter?.initData(it) }
    }
}