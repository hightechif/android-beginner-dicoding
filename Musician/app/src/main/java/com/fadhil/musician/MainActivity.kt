package com.fadhil.musician

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.fadhil.musician.adapter.MusicianAdapter
import com.fadhil.musician.data.MusicianData
import com.fadhil.musician.databinding.ActivityMainBinding
import com.fadhil.musician.model.Musician

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var title: String = "Home"

    companion object {
        private var musicianList: ArrayList<Musician> = arrayListOf()
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setActionBarTitle(title)
        binding.rvMusician.setHasFixedSize(true)

        musicianList.addAll(MusicianData.listData)
        showMusicianList()
    }

    private fun showMusicianList() {
        binding.rvMusician.layoutManager = LinearLayoutManager(this)
        val listMusicianAdapter = MusicianAdapter(musicianList)
        binding.rvMusician.adapter = listMusicianAdapter

        listMusicianAdapter.setOnItemClickCallback(object : MusicianAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Musician) {
                showMusicianDetailPage(data)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.overflow_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.aboutPage -> {
                showAboutPage()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showAboutPage() {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }

    private fun showMusicianDetailPage(musician: Musician) {
        Toast.makeText(this, "Kamu memilih " + musician.name, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MusicianDetailActivity::class.java)
        intent.putExtra("MUSICIAN_NAME", musician.name)
        intent.putExtra("MUSICIAN_DESCRIPTION", musician.description)
        intent.putExtra("MUSICIAN_PHOTO", musician.photo)
        startActivity(intent)
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("musicianList", binding.rvMusician.toString())
    }
}