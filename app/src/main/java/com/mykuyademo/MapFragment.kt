package com.mykuyademo

import com.mykuyademo.base.BaseFragment
import com.mykuyademo.databinding.MapFragmentBinding

class MapFragment : BaseFragment<MapFragmentBinding>() {

    companion object {
        fun newInstance() = MapFragment()
    }

    override fun getLayoutResId(): Int {
        return R.layout.map_fragment
    }

    override fun bindingPresenter() {
        binding.presenter = MapPresenter()
    }

    override fun bindData() {
    }

}