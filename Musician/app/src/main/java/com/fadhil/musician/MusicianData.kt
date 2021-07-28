package com.fadhil.musician

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

    private val musicianDetails = arrayOf("Salah seorang musisi ....",
        "Salah seorang musisi ....",
        "Salah seorang musisi ....",
        "Salah seorang musisi ....",
        "Salah seorang musisi ....",
        "Salah seorang musisi ....",
        "Salah seorang musisi ....",
        "Salah seorang musisi ....",
        "Salah seorang musisi ....",
        "Salah seorang musisi ....")

    private val musicianImages = intArrayOf(R.drawable.ardhito_pramono,
        R.drawable.pamungkas,
        R.drawable.nadin_amizah,
        R.drawable.adhitia_sofyan,
        R.drawable.john_mayer,
        R.drawable.bruno_mars,
        R.drawable.frank_sinatra,
        R.drawable.fiersa_besari,
        R.drawable.niki,
        R.drawable.kunto_aji)

    val listData: ArrayList<Musician>
        get() {
            val list = arrayListOf<Musician>()
            for (position in musicianNames.indices) {
                val musician = Musician()
                musician.name = musicianNames[position]
                musician.detail = musicianDetails[position]
                musician.photo = musicianImages[position]
                list.add(musician)
            }
            return list
        }
}