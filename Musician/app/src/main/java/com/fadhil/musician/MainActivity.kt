package com.fadhil.musician

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fadhil.musician.adapter.ListMusicianAdapter
import com.fadhil.musician.data.MusicianData
import com.fadhil.musician.dto.Musician

class MainActivity : AppCompatActivity() {

    private lateinit var rvMusician: RecyclerView

    companion object {
        private var musicianList: ArrayList<Musician> = arrayListOf()
    }

    private var title: String = "Home"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        rvMusician = findViewById(R.id.rv_musician)
        rvMusician.setHasFixedSize(true)

        musicianList.addAll(MusicianData.listData)
        showHomePage()
    }

    private fun showHomePage() {
        rvMusician.layoutManager = LinearLayoutManager(this)
        val listMusicianAdapter = ListMusicianAdapter(musicianList)
        rvMusician.adapter = listMusicianAdapter

        listMusicianAdapter.setOnItemClickCallback(object : ListMusicianAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Musician) {
                showMusicianDetailPage(data)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.home_page -> {
                title = "Home"
                showHomePage()
            }

            R.id.about_page -> {
                title = "About"
                showAboutPage()
            }
        }
        setActionBarTitle(title)
    }

    private fun showMusicianDetailPage(musician: Musician) {
        Toast.makeText(this, "Kamu memilih " + musician.name, Toast.LENGTH_SHORT).show()
        val intent = Intent(this@MainActivity, MusicianActivity::class.java)
        intent.putExtra("MUSICIAN_NAME", musician.name)
        intent.putExtra("MUSICIAN_DESCRIPTION", musician.description)
        intent.putExtra("MUSICIAN_PHOTO", musician.photo)
        startActivity(intent)
    }

    private fun showAboutPage() {
        setContentView(R.layout.about_page)
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putString(MainActivity.musicianList, rvMusician)
//    }
}