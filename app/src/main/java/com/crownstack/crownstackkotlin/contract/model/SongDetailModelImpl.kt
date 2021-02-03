package com.crownstack.crownstackkotlin.contract.model

import android.os.Bundle
import android.widget.ImageView
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.crownstack.crownstackkotlin.R
import com.crownstack.crownstackkotlin.constants.Constants.Companion.IMAGE_STRING
import com.crownstack.crownstackkotlin.contract.SongDetailContract
import com.crownstack.crownstackkotlin.fragments.BaseFragment

class SongDetailModelImpl(
    private val mCurrentFragment: BaseFragment
) : SongDetailContract.SongDetailModel {

    override fun onSongImageClick(imageStr: String?, imageView: ImageView) {
        val extras = FragmentNavigatorExtras(imageView to "transitionName")
        val bundle = Bundle()
        bundle.putString(IMAGE_STRING, imageStr)
        mCurrentFragment.findNavController().navigate(R.id.artistPhotoFragment, bundle, null, extras)
    }

}