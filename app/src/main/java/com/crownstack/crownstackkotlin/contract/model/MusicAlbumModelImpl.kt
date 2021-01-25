package com.crownstack.crownstackkotlin.contract.model

import androidx.navigation.fragment.findNavController
import com.crownstack.crownstackkotlin.contract.MusicAlbumContract
import com.crownstack.crownstackkotlin.fragments.BaseFragment
import com.crownstack.crownstackkotlin.fragments.HomeFragmentDirections
import com.crownstack.crownstackkotlin.model.bo.ArtistBO
import com.crownstack.crownstackkotlin.network.RetrofitApi

class MusicAlbumModelImpl(
    private var mMusicAlbumPresenter: MusicAlbumContract.IMusicAlbumPresenter,
    private val mCurrentFragment: BaseFragment
) : MusicAlbumContract.IMusicAlbumModel {

    override fun getMusicListFromServer(artistName: String) {
        Thread(Runnable {
            val musicListCall = RetrofitApi().getServerCallObject().getMusicList(artistName)
            val execute = musicListCall.execute()
            execute.let {
                if (execute.isSuccessful) {
                    val responseBody = execute.body()
                    responseBody?.run {
                        mMusicAlbumPresenter.onMusicListFromServerCallBack(this.mArtistList)
                    }
                }
            }
        }).start()
    }

    override fun onMusicItemClick(artistList: ArtistBO) {
        val action = HomeFragmentDirections.actionHomeFragmentToSongDetailFragment(artistList)
        mCurrentFragment.findNavController().navigate(action)
    }
}