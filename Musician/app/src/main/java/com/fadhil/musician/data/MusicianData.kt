package com.fadhil.musician.data

import com.fadhil.musician.R
import com.fadhil.musician.dao.Musician

object MusicianData {
    private val musicianNames = arrayOf("Ardhito Pramono",
        "Pamungkas",
        "Nadin Amizah",
        "Adhitia Sofyan",
        "John Mayer",
        "Bruno Mars",
        "Frank Sinatra",
        "Fiersa Besari",
        "Niki",
        "Kunto Aji")

    private val musicianDescriptions = arrayOf("Musisi yang sering menciptakan lagu pop jazz",
        "Performer yang sering tampil dengan fenomenal",
        "Musisi perempuan dengan lagu paling galau",
        "Salah seorang musisi yang sering menciptakan lagu akustik",
        "Musisi pop alternatif internasional",
        "Musisi pop yang cukup terkenal",
        "Musisi jazz sepanjang masa",
        "Musisi dengan musik-musik indie",
        "Musik Pop and RnB",
        "Terkenal dengan musik-musiknya yang menenangkan jiwa")

    private val musicianImages = intArrayOf(
        R.drawable.ardhito_pramono,
        R.drawable.pamungkas,
        R.drawable.nadin_amizah,
        R.drawable.adhitia_sofyan,
        R.drawable.john_mayer,
        R.drawable.bruno_mars,
        R.drawable.frank_sinatra,
        R.drawable.fiersa_besari,
        R.drawable.niki,
        R.drawable.kunto_aji
    )

    val listData: ArrayList<Musician>
        get() {
            val list = arrayListOf<Musician>()
            var id : Long = 1;
            for (position in musicianNames.indices) {
                val musician = Musician()
                musician.id = id
                musician.name = musicianNames[position]
                musician.description = musicianDescriptions[position]
                musician.photo = musicianImages[position]
                list.add(musician)
                id++
            }
            return list
        }
}