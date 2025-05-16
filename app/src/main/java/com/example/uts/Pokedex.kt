package com.example.uts

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uts.databinding.ActivityPokedexBinding

class Pokedex : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var floraAdapter: MyAdapter
    private lateinit var listImage: ArrayList<ItemData>
    private lateinit var binding: ActivityPokedexBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pokedex)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityPokedexBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = findViewById(R.id._imageRecyclerView)
        listImage = ArrayList()

        // Menambahkan data lengkap termasuk deskripsi
        listImage.add(
            ItemData(
                R.drawable.anggrek,
                "BUNGA ANGGREK", "Anggrek adalah salah satu keluarga tumbuhan berbunga terbesar dan paling beragam di dunia. Mereka dikenal dengan bunganya yang indah, unik, dan seringkali memiliki aroma yang memikat. Anggrek dapat ditemukan di hampir semua habitat di dunia, kecuali di gurun yang ekstrem dan daerah kutub. Di Papua, termasuk Jayapura, terdapat keanekaragaman anggrek yang sangat tinggi, baik anggrek epifit (menempel pada tumbuhan lain), terestrial (hidup di tanah), maupun litofit (hidup di bebatuan)."
                + "Adaptasi yang Luar Biasa: Anggrek telah mengembangkan berbagai mekanisme adaptasi untuk bertahan hidup di lingkungan yang berbeda. Anggrek epifit memiliki akar udara yang mampu menyerap air dan nutrisi dari udara dan permukaan tumbuhan inang. Beberapa anggrek memiliki pseudobulb untuk menyimpan air dan makanan.")
        )

        listImage.add(
            ItemData(
                R.drawable.buahmerah,
                "BUAH MERAH",
                "Buah merah adalah tanaman endemik Papua yang tumbuh di dataran rendah hingga ketinggian sedang. Tanaman ini termasuk dalam genus Pandanus dan memiliki ciri khas buahnya yang berwarna merah menyala saat matang. Buah merah memiliki bentuk lonjong dan ukuran yang bervariasi, tergantung pada varietasnya. Di Papua, buah merah merupakan sumber makanan penting dan juga memiliki nilai budaya serta khasiat obat tradisional."
                        + "Warna Merah yang Intens: Warna merah cerah buah ini disebabkan oleh kandungan karotenoid yang sangat tinggi, terutama beta-karoten dan alfa-karoten. Warna ini menjadi ciri khas dan daya tarik visual buah merah."
                        + "Kandungan Nutrisi yang Kaya: Buah merah dikenal kaya akan berbagai nutrisi penting, termasuk karotenoid (sebagai antioksidan dan prekursor vitamin A), tokoferol (vitamin E), asam oleat (asam lemak tak jenuh tunggal), dan berbagai mineral."
            )
        )
        listImage.add(
            ItemData(
                R.drawable.matoa,
                "BUAH MATOA", "Matoa adalah tanaman buah asli Indonesia bagian timur, termasuk Papua. Pohon matoa berukuran sedang hingga besar dengan daun majemuk dan buah berbentuk bulat lonjong dengan kulit berwarna hijau, kuning, atau merah keunguan saat matang. Daging buah matoa berwarna putih atau kekuningan, berair, dan memiliki rasa manis yang khas, seringkali merupakan perpaduan antara rambutan, lengkeng, dan kelapa."
            )
        )

        listImage.add(
            ItemData(
                R.drawable.cenderawasih,
                "BURUNG CENDERAWASIH", "Cenderawasih terkenal di seluruh dunia karena keindahan bulu-bulunya yang luar biasa dan ritual perkawinan yang spektakuler. Burung jantan mengembangkan ornamen bulu yang rumit dan berwarna-warni, seperti bulu ekor yang panjang menjuntai, sayap yang melengkung indah, atau hiasan kepala yang unik. Mereka melakukan tarian yang rumit dan pameran vokal untuk menarik perhatian betina. Setiap spesies cenderawasih memiliki kombinasi warna, bentuk bulu, dan gerakan tarian yang khas, menjadikannya simbol keindahan alam Papua yang tak tertandingi. Beberapa spesies bahkan memiliki suara yang sangat unik dan merdu."
            )
        )
        listImage.add(
            ItemData(
                R.drawable.mambruk,
                "BURUNG MAMBRUK", " Burung mambruk, yang juga dikenal sebagai merpati mahkota, adalah kelompok merpati terbesar di dunia dan memiliki penampilan yang sangat anggun. Ciri khas utama mereka adalah jambul besar dan indah di atas kepala yang menyerupai mahkota. Jambul ini terdiri dari bulu-bulu halus yang mengembang seperti kipas. Selain jambulnya, mambruk juga memiliki warna bulu yang menarik, biasanya perpaduan antara biru keabu-abuan, merah marun, dan putih. Mereka memiliki perilaku yang tenang dan sering ditemukan berjalan di lantai hutan dalam kelompok kecil. Suara panggilan mereka juga lembut dan khas."
            )
        )
        listImage.add(
            ItemData(
                R.drawable.kasuari,
                "BURUNG KASUARI", "Kasuari adalah burung besar yang tidak bisa terbang dan merupakan salah satu burung terberat di dunia. Mereka memiliki penampilan yang unik dengan bulu hitam yang keras menyerupai rambut, leher dan pial berwarna cerah (merah, biru, kuning), serta tanduk keras (casque) di atas kepala yang fungsinya belum sepenuhnya dipahami (kemungkinan untuk perlindungan, komunikasi suara, atau menarik perhatian). Kaki kasuari sangat kuat dengan cakar yang tajam, yang digunakan untuk pertahanan diri. Mereka adalah pemakan buah-buahan yang penting dalam penyebaran biji di hutan Papua. Suara mereka berupa dengungan rendah yang dalam."
            )
        )

        listImage.add(
            ItemData(
                R.drawable.kakatuaraja,
                "BURUNG KAKATUA RAJA", "Kakatua raja adalah spesies kakatua terbesar dan paling mencolok. Ciri khas utamanya adalah jambul besar berwarna oranye atau merah menyala yang dapat ditegakkan secara dramatis. Mereka memiliki bulu berwarna hitam atau abu-abu gelap yang kontras dengan warna jambulnya. Selain jambulnya yang megah, kakatua raja juga memiliki paruh yang sangat kuat dan besar, yang digunakan untuk memecahkan biji-bijian keras dan buah-buahan. Suara panggilan mereka juga unik, berupa pekikan yang keras dan serak. Mereka cenderung hidup soliter atau berpasangan dan mendiami hutan-hutan lebat di Papua."
            )
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        floraAdapter = MyAdapter(listImage) { selectedFlora ->
            val intent = Intent(this, Desc::class.java).apply {
                putExtra("Image", selectedFlora)
            }
            startActivity(intent)
        }

        recyclerView.adapter = floraAdapter

    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        startActivity(intent)
        finish()
    }


}