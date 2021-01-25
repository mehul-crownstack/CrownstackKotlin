package com.crownstack.crownstackkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.crownstack.crownstackkotlin.constants.getDateFormatFromUtcTimeFormat
import com.crownstack.crownstackkotlin.listeners.IMusicItemClickListener
import com.crownstack.crownstackkotlin.model.bo.ArtistBO

class ArtistSongAdapter(
    private val mContext: Context?,
    private val mMusicItemClickListener: IMusicItemClickListener) :
    RecyclerView.Adapter<ArtistSongAdapter.ArtistSongViewHolder>() {

    private var mArtistList: ArrayList<ArtistBO>? = null

    fun setArtistList(list: ArrayList<ArtistBO>) {
        this.mArtistList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistSongViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.artist_song_item, parent, false)
        return ArtistSongViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mArtistList?.size ?: 0
    }

    override fun onBindViewHolder(holder: ArtistSongViewHolder, position: Int) {
        val artist = mArtistList?.get(position)
        artist?.run {
            holder.artistNameTextView.text = artistName
            holder.artistSongTextView.text = trackName
            holder.artistDateTextView.text = getDateFormatFromUtcTimeFormat(releaseDate)
            mContext?.run {
                Glide.with(mContext).load(artist.artworkUrl30)
                    .placeholder(ContextCompat.getDrawable(mContext, R.drawable.default_image))
                    .into(holder.artistSongImageView)
            }
            holder.songLayout.setOnClickListener { mMusicItemClickListener.onMusicItemClicked(artist) }
        }

    }

    class ArtistSongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val artistSongImageView: ImageView = itemView.findViewById(R.id.artistSongImageView)
        val artistSongTextView: TextView = itemView.findViewById(R.id.artistSongTextView)
        val artistNameTextView: TextView = itemView.findViewById(R.id.artistNameTextView)
        val artistDateTextView: TextView = itemView.findViewById(R.id.artistDateTextView)
        val songLayout: View = itemView.findViewById(R.id.songLayout)

    }

}
