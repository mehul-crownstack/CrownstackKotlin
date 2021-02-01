package com.crownstack.crownstackkotlin.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.crownstack.crownstackkotlin.R
import com.crownstack.crownstackkotlin.constants.Constants

class SplashFragment : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mNavController = findNavController()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mContentView = inflater.inflate(R.layout.fragment_splash, container, false)
        Handler(Looper.getMainLooper()).postDelayed({
            val action = SplashFragmentDirections.actionSplashFragmentToHomeFragment()
            mNavController.navigate(action)
            mActivity.hideToolbarView(true)
        }, Constants.SPLASH_TIMER)
        mActivity.hideToolbarView(false)
        return mContentView
    }

}