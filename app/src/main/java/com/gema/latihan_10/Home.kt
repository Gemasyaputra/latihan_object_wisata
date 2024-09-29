package com.gema.latihan_10

import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.gema.latihan_10.adapter.AdapterJepun

class Home : AppCompatActivity() {

    private val imagelist = arrayOf(
        R.drawable.ges1,
        R.drawable.ges2,
        R.drawable.ges3,
        R.drawable.ges4
    )

    private val titlelist = arrayOf(
        "Tokyo",
        "Osaka",
        "Kyoto",
        "Hiroshima"
    )

    private val locationlist = arrayOf(
        "Lokasi : Osaka,Jepang", "Lokasi : Kyoto,Jepang", "Lokasi : Yamagata,Jepang", "Lokasi : Nara,Jepang" )

    private val tgllist = arrayOf(
        "Tgl : 20 - September - 2024",
        "Tgl : 1 - Agustus - 2024",
        "Tgl : 12 - Maret - 2024",
        "Tgl : 17 - Juni - 2024"
    )
    private val des = arrayOf(
        "Originally, the temple was created to teach and spread Buddhism when Buddhism wasn’t a thing in Japan yet. The teachings didn’t belong to any particular sect. Then there was a period when it became a temple for the Tiantai school (天台宗). But then in 1946, it became the main temple for an independent sect of Buddhism called “Washu” (和宗) which hopes to transcend the wall of “sects” in Buddhism and welcome anyone.",
        "Byodo-in in Uji, Kyoto Prefecture was built in 998. The Phoenix Hall features 1,000 year-old Buddhist statues and other national treasures. The image of the Phoenix Hall can be seen on the Japanese 10 yen coin.",
        "Yama-dera is a mountain temple in Yamagata Prefecture built in 860. Visitors must hike up nearly 1,000 stone steps in order to reach the temple grounds. The trek takes approximately 30 minutes and can be quite strenuous. Once at the top, the temple offers fantastic views of the valley.",
        "Todai-ji in Nara was built in 752 and is the largest wooden structure in the world. Inside is the largest Buddha statue in Japan, measuring 15 meters tall and consisting of 437 tons of bronze and 130 kg of gold."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val gridView = findViewById<GridView>(R.id.gridView)
        val adapter = AdapterJepun(this, imagelist, titlelist, locationlist)
        gridView.adapter = adapter

        gridView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, DetailJepunActivity::class.java)
            intent.putExtra("image", imagelist[position])
            intent.putExtra("title", titlelist[position])
            intent.putExtra("location", locationlist[position])
            intent.putExtra("tgl", tgllist[position])
            intent.putExtra("des", des[position])
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}