package com.fadhil.musician

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fadhil.musician.databinding.ActivityMusicianDetailBinding


class MusicianDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMusicianDetailBinding

    companion object {
        const val MUSICIAN_NAME = "musician_name"
        const val MUSICIAN_DESCRIPTION = "musician_description"
        const val MUSICIAN_PHOTO = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicianDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras
        val name = bundle?.getString("MUSICIAN_NAME")
        val description = bundle?.getString("MUSICIAN_DESCRIPTION")
        val photoId = bundle?.getInt("MUSICIAN_PHOTO")

        binding.tvMusicianName.text = name
        binding.tvMusicianDescription.text = description
        binding.imgMusicianPhoto.setImageResource(photoId ?: 0)

        binding.btnSetShare.setOnClickListener {
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            sharingIntent.putExtra(Intent.EXTRA_TEXT, "$name: $description")
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "$name")
            startActivity(Intent.createChooser(sharingIntent, "Share musician"))
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(MUSICIAN_NAME, binding.tvMusicianName.text.toString())
        outState.putString(MUSICIAN_DESCRIPTION, binding.tvMusicianDescription.text.toString())
        outState.putString(MUSICIAN_PHOTO, binding.imgMusicianPhoto.resources.toString())
    }
}