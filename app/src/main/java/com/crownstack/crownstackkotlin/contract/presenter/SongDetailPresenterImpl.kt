package com.crownstack.crownstackkotlin.contract.presenter

import android.widget.ImageView
import com.crownstack.crownstackkotlin.contract.SongDetailContract
import com.crownstack.crownstackkotlin.contract.model.SongDetailModelImpl
import com.crownstack.crownstackkotlin.fragments.BaseFragment

class SongDetailPresenterImpl(
    private val mCurrentFragment: BaseFragment
) : SongDetailContract.SongDetailPresenter {

    private val mSongDetailModel = SongDetailModelImpl(mCurrentFragment)

    override fun onSongImageClick(imageStr: String?, imageView: ImageView) {
        mSongDetailModel.onSongImageClick(imageStr,imageView)
    }


}