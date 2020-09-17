package com.mykuyademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mykuyademo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainPresenter: MainPresenter
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainPresenter = MainPresenter()
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainBinding.presenter = mainPresenter
    }
}