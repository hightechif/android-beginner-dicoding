package com.fadhil.musician

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.fadhil.musician.databinding.ActivityMusicianDetailBinding
import de.hdodenhof.circleimageview.CircleImageView

class MusicianDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMusicianDetailBinding
    private lateinit var tvMusicianName: TextView
    private lateinit var tvMusicianDescription: TextView
    private lateinit var imgMusicianPhoto: CircleImageView

    companion object {
        const val MUSICIAN_NAME = "musician_name"
        const val MUSICIAN_DESCRIPTION = "musician_description"
        const val MUSICIAN_PHOTO = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicianDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(MUSICIAN_NAME, tvMusicianName.text.toString())
        outState.putString(MUSICIAN_DESCRIPTION, tvMusicianDescription.text.toString())
        outState.putString(MUSICIAN_PHOTO, imgMusicianPhoto.resources.toString())
    }
}