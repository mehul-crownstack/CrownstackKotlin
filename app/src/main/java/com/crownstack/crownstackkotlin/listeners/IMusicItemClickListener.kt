package com.crownstack.crownstackkotlin.listeners

import com.crownstack.crownstackkotlin.model.bo.ArtistBO

interface IMusicItemClickListener {
    fun onMusicItemClicked(artist: ArtistBO)
}