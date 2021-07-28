package com.fadhil.musician

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import de.hdodenhof.circleimageview.CircleImageView

class MusicianActivity : AppCompatActivity() {

    private lateinit var tvMusicianName: TextView
    private lateinit var tvMusicianDescription: TextView
    private lateinit var imgMusicianPhoto: CircleImageView

    companion object {
        const val MUSICIAN_NAME = "musician_name"
        const val MUSICIAN_DESCRIPTION = "musician_description"
        const val MUSICIAN_PHOTO = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_page)

        tvMusicianName = findViewById(R.id.tv_musician_name)
        tvMusicianDescription = findViewById(R.id.tv_musician_description)
        imgMusicianPhoto = findViewById(R.id.img_musician_photo)

        val bundle: Bundle? = intent.extras
        val name = bundle?.getString("MUSICIAN_NAME")
        val description = bundle?.getString("MUSICIAN_DESCRIPTION")
        val photoId = bundle?.getInt("MUSICIAN_PHOTO")

        tvMusicianName.text = name
        tvMusicianDescription.text = description
        imgMusicianPhoto.setImageResource(photoId?:0)

    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putString(MUSICIAN_NAME, tvMusicianName.text.toString())
//        outState.putString(MUSICIAN_DESCRIPTION, tvMusicianDescription.text.toString())
//        outState.putString(MUSICIAN_PHOTO, imgMusicianPhoto.resources.toString())
//    }
}