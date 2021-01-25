package com.crownstack.crownstackkotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.crownstack.crownstackkotlin.R
import com.crownstack.crownstackkotlin.constants.getDateFormatFromUtcTimeFormat
import com.crownstack.crownstackkotlin.constants.getSongDuration
import kotlinx.android.synthetic.main.fragment_song_detail.*

class SongDetailFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mContentView = inflater.inflate(R.layout.fragment_song_detail, container, false)
        return mContentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val artistBO = SongDetailFragmentArgs.fromBundle(requireArguments()).artistBO
        artistBO.run {
            Glide.with(this@SongDetailFragment).load(artworkUrl100).placeholder(
                context?.let {
                    ContextCompat.getDrawable(
                        it,
                        R.drawable.default_image
                    )
                }
            ).into(songCoverImageView)
            trackNameTextView.text = trackName
            collectionNameTextView.text = collectionName
            trackIdTextView.text = trackId.toString()
            genreNameTextView.text = primaryGenreName
            releaseDateTextView.text = getDateFormatFromUtcTimeFormat(releaseDate)
            songDurationTextView.text = getSongDuration(trackTimeMillis)
        }
    }
}