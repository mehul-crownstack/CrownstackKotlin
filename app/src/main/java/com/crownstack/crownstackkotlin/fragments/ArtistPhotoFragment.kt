package com.crownstack.crownstackkotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.transition.TransitionInflater
import com.crownstack.crownstackkotlin.R
import com.crownstack.crownstackkotlin.constants.Constants.Companion.IMAGE_STRING
import com.crownstack.crownstackkotlin.constants.setImageIntoImageView
import kotlinx.android.synthetic.main.fragment_artist_photo.*

class ArtistPhotoFragment : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            sharedElementEnterTransition =
                TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mContentView = inflater.inflate(R.layout.fragment_artist_photo, container, false)
        return mContentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setImageIntoImageView(arguments?.getString(IMAGE_STRING), mActivity, artistPhotoImageView)
    }

}