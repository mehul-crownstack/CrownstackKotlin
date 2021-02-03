package com.crownstack.crownstackkotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.crownstack.crownstackkotlin.R
import com.crownstack.crownstackkotlin.constants.getDateFormatFromUtcTimeFormat
import com.crownstack.crownstackkotlin.constants.getSongDuration
import com.crownstack.crownstackkotlin.constants.setImageIntoImageView
import com.crownstack.crownstackkotlin.contract.presenter.SongDetailPresenterImpl
import kotlinx.android.synthetic.main.fragment_song_detail.*

class SongDetailFragment : BaseFragment(), View.OnClickListener {

    private val mSongDetailPresenter = SongDetailPresenterImpl(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mContentView = inflater.inflate(R.layout.fragment_song_detail, container, false)
        return mContentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val artistBO = SongDetailFragmentArgs.fromBundle(requireArguments()).artistBO
        songCoverImageView.setOnClickListener(this)
        artistBO.run {
            setImageIntoImageView(artworkUrl100, mActivity, songCoverImageView)
            trackNameTextView.text = trackName
            collectionNameTextView.text = collectionName
            trackIdTextView.text = trackId.toString()
            genreNameTextView.text = primaryGenreName
            releaseDateTextView.text = getDateFormatFromUtcTimeFormat(releaseDate)
            songDurationTextView.text = getSongDuration(trackTimeMillis)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            songCoverImageView.id -> {
                val artistBO = SongDetailFragmentArgs.fromBundle(requireArguments()).artistBO
                mSongDetailPresenter.onSongImageClick(artistBO.artworkUrl100, songCoverImageView)
            }
        }
    }
}