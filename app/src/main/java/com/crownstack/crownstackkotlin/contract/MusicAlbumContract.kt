package com.crownstack.crownstackkotlin.contract

import com.crownstack.crownstackkotlin.model.bo.ArtistBO

class MusicAlbumContract {

    interface IMusicAlbumPresenter {
        fun getMusicListFromServer(artistName:String)
        fun onMusicListFromServerCallBack(artistList: ArrayList<ArtistBO>?)
        fun onMusicItemClick(artistList: ArtistBO)
    }

    interface IMusicAlbumView {
        fun musicListResponseFromServer(artistList: ArrayList<ArtistBO>)
    }

    interface IMusicAlbumModel {
        fun getMusicListFromServer(artistName:String)
        fun onMusicItemClick(artistList: ArtistBO)
    }

}