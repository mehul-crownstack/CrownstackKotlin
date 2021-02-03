package com.crownstack.crownstackkotlin.contract

import android.widget.ImageView

class SongDetailContract {

    interface SongDetailPresenter {
        fun onSongImageClick(imageStr: String?, imageView: ImageView)
    }

    interface SongDetailModel {
        fun onSongImageClick(imageStr: String?, imageView: ImageView)
    }
}