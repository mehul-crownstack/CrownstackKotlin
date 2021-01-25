package com.crownstack.crownstackkotlin.contract.model

import androidx.navigation.fragment.findNavController
import com.crownstack.crownstackkotlin.contract.MusicAlbumContract
import com.crownstack.crownstackkotlin.fragments.BaseFragment
import com.crownstack.crownstackkotlin.fragments.HomeFragmentDirections
import com.crownstack.crownstackkotlin.model.bo.ArtistBO
import com.crownstack.crownstackkotlin.network.RetrofitApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MusicAlbumModelImpl(
    private var mMusicAlbumPresenter: MusicAlbumContract.IMusicAlbumPresenter,
    private val mCurrentFragment: BaseFragment
) : MusicAlbumContract.IMusicAlbumModel {

    override fun getMusicListFromServer(artistName: String) {
        CoroutineScope(IO).launch {
            fetchMusicListServerCall(artistName)
        }
    }

    private suspend fun fetchMusicListServerCall(artistName: String) {
        val musicListResponse = RetrofitApi().getServerCallObject().getMusicList(artistName)
        musicListResponse.let {
            if (musicListResponse.isSuccessful) {
                val responseBody = musicListResponse.body()
                responseBody?.run {
                    mMusicAlbumPresenter.onMusicListFromServerCallBack(this.mArtistList)
                }
            }
        }
    }

    override fun onMusicItemClick(artistList: ArtistBO) {
        val action = HomeFragmentDirections.actionHomeFragmentToSongDetailFragment(artistList)
        mCurrentFragment.findNavController().navigate(action)
    }
}