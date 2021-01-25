package com.crownstack.crownstackkotlin.contract.presenter

import android.util.Log
import com.crownstack.crownstackkotlin.constants.Constants
import com.crownstack.crownstackkotlin.contract.MusicAlbumContract
import com.crownstack.crownstackkotlin.contract.model.MusicAlbumModelImpl
import com.crownstack.crownstackkotlin.fragments.BaseFragment
import com.crownstack.crownstackkotlin.model.bo.ArtistBO

class MusicAlbumPresenterImpl(
    private val mMusicAlbumView: MusicAlbumContract.IMusicAlbumView,
    private val mCurrentFragment: BaseFragment
) : MusicAlbumContract.IMusicAlbumPresenter {

    private var mMusicAlbumModel: MusicAlbumContract.IMusicAlbumModel = MusicAlbumModelImpl(this, mCurrentFragment)

    override fun getMusicListFromServer(artistName: String) {
        Log.d(Constants.TAG, "Presenter :: mMusicAlbumPresenter.getMusicListFromServer() CALLED")
        mMusicAlbumModel.getMusicListFromServer(artistName)
    }

    override fun onMusicListFromServerCallBack(artistList: ArrayList<ArtistBO>?) {
        Log.d(Constants.TAG, "Presenter :: mMusicAlbumPresenter.onMusicListFromServerCallBack() CALLED")
        artistList?.let { mMusicAlbumView.musicListResponseFromServer(artistList) }
    }

    override fun onMusicItemClick(artistList: ArtistBO) {
        mMusicAlbumModel.onMusicItemClick(artistList)
    }
}