package com.crownstack.crownstackkotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.crownstack.crownstackkotlin.ArtistSongAdapter
import com.crownstack.crownstackkotlin.R
import com.crownstack.crownstackkotlin.constants.Constants
import com.crownstack.crownstackkotlin.contract.MusicAlbumContract
import com.crownstack.crownstackkotlin.contract.presenter.MusicAlbumPresenterImpl
import com.crownstack.crownstackkotlin.listeners.IMusicItemClickListener
import com.crownstack.crownstackkotlin.model.bo.ArtistBO
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment(), MusicAlbumContract.IMusicAlbumView, IMusicItemClickListener {

    private val mMusicAlbumPresenter = MusicAlbumPresenterImpl(this, this)
    private lateinit var mArtistAdapter: ArtistSongAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mContentView = inflater.inflate(R.layout.fragment_home, container, false)
        return mContentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mArtistAdapter = ArtistSongAdapter(context, this)
        musicListRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
            adapter = mArtistAdapter
        }
        showProgressDialog(context)
        mMusicAlbumPresenter.getMusicListFromServer(Constants.MICHAEL_JACKSON)
    }

    override fun musicListResponseFromServer(artistList: ArrayList<ArtistBO>) {
        stopProgress()
        activity?.runOnUiThread { mArtistAdapter.setArtistList(artistList) }
    }

    override fun onMusicItemClicked(artist: ArtistBO) {
        mMusicAlbumPresenter.onMusicItemClick(artist)
    }
}