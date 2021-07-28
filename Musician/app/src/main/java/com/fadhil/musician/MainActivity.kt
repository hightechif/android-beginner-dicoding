package com.fadhil.musician

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fadhil.musician.adapter.ListMusicianAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var rvMusician: RecyclerView
    private var list: ArrayList<Musician> = arrayListOf()
    private var title: String = "Home"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        rvMusician = findViewById(R.id.rv_musician)
        rvMusician.setHasFixedSize(true)

        list.addAll(MusicianData.listData)
        showHomePage()
    }

    private fun showHomePage() {
        rvMusician.layoutManager = LinearLayoutManager(this)
        val listMusicianAdapter = ListMusicianAdapter(list)
        rvMusician.adapter = listMusicianAdapter

        listMusicianAdapter.setOnItemClickCallback(object : ListMusicianAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Musician) {
                showSelectedMusician(data)
            }
        })
    }

    private fun showAboutPage() {

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.home_page -> {
                title = "Mode List"
                showHomePage()
            }

            R.id.detail_page -> {
                title = "Mode Grid"
//                showDetailPage()
            }

            R.id.about_page -> {
                title = "Mode CardView"
                showAboutPage()
            }
        }
        setActionBarTitle(title)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    private fun showSelectedMusician(musician: Musician) {
        Toast.makeText(this, "Kamu memilih " + musician.name, Toast.LENGTH_SHORT).show()
    }
}