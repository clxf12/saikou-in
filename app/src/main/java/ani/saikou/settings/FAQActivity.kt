package ani.saikou.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ani.saikou.R
import ani.saikou.databinding.ActivityFaqBinding
import ani.saikou.initActivity

class FAQActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFaqBinding

    private val faqs = listOf(
        Triple(R.drawable.ic_round_help_24,"Apa itu Saikou?\nMengapa Anda harus menggunakan Saikou?", "Saikou dibuat berdasarkan keanggunan yang sederhana namun canggih. Ini adalah satu-satunya klien Anilist, yang juga memungkinkan Anda streaming-unduh Anime & Manga. Kami berencana untuk segera menambahkan dukungan MyAnimeList.\nSaikou (最高; Sai-kō) secara harfiah berarti yang terbaik dalam bahasa Jepang. Yah, kami ingin mengatakan ini adalah aplikasi sumber terbuka terbaik untuk anime dan manga di Android, tapi hei, Cobalah sendiri & nilai! "),
        Triple(R.drawable.ic_round_auto_awesome_24,"Apa saja fitur Saikou?","Beberapa fitur Saikou yang dapat disebutkan adalah\n\n- Cara mudah dan fungsional untuk keduanya, menonton anime dan membaca manga, Bebas Iklan.\n- Aplikasi open source sepenuhnya dengan UI yang bagus & Animasi\n- Pengikisan paling efisien untuk anime dan manga dari berbagai sumber. (Peringatan Spoiler: Tidak ada tampilan web yang dirugikan)\n- Sinkronkan anime dan manga secara real-time dengan AniList. Mengkategorikan anime dan manga dengan mudah berdasarkan status Anda saat ini. (Didukung oleh AniList)\n- Temukan semua acara menggunakan daftar yang menyeluruh dan sering diperbarui dari semua anime yang sedang tren, populer, dan sedang berlangsung berdasarkan skor.\n- Lihat detail ekstensif tentang acara anime, film, dan judul manga. Ini juga menampilkan kemampuan untuk menghitung mundur ke episode berikutnya dari anime yang ditayangkan. (Didukung oleh AniList & MyAnimeList)"),
        Triple(R.drawable.ic_round_download_24,"Apa itu Artifact?","Setiap kali pengembang melakukan atau meminta fitur atau perbaikan, github secara otomatis membuat file APK untuk Anda gunakan. APK ini disebut Artefak. Artifact melalui permintaan tarik mungkin atau mungkin tidak ditambahkan ke rilis utama aplikasi. Artifact memiliki peluang lebih tinggi untuk memiliki bug dan gangguan. Untuk mengetahui apakah artefak baru tersedia, bintangi repositori saikou dan aktifkan notifikasi\n\nUntuk mengunduh Artifact:\n1) Masuk/Masuk di GitHub\n2) Buka saikou\n3) Buka tindakan\n4) Tekan aktif alur kerja yang ingin Anda unduh Artifactnya.\n5) Tekan Artifact\n6) Ekstrak file menggunakan ekstraktor zip\n7) Instal dan nikmati."),
        Triple(R.drawable.ic_round_dns_24,"Apakah Saikou tersedia untuk PC?","Saat ini tidak ada(untuk Windows dan Linux). Belum ada perkiraan kapan akan tersedia. Tetapi Anda dapat mengunduh emulator Android apa pun dan menjalankan saikou di atasnya. Untuk pengguna Windows 11, mereka dapat menggunakan Subsistem Windows untuk Android (a.k.a WSA) untuk menjalankan Saikou di Windows."),
        Triple(R.drawable.ic_baseline_screen_lock_portrait_24,"Apakah Saikou tersedia untuk iOS?","Saikou untuk iOS kini sedang dikembangkan dengan nama \"SaikouS\". Anda dapat mendownload build yang diupload oleh developer terkait dari [server discord](https://discord.gg/2T7TunuwFZ)\n\n[Tekan di sini jika Anda ingin melihat Repositori GitHub](https://github .com/5H4D0WILA/SaikouS)"),
        Triple(R.drawable.ic_anilist,"Mengapa statistik saya tidak diperbarui?","Ini karena statistik diperbarui setiap 48 jam secara otomatis (oleh anilist), Jika Anda benar-benar perlu memperbarui statistik, Anda dapat memperbarui statistik secara paksa setelah membuka [link](https:/ /anilist.co/settings/lists)"),
        Triple(R.drawable.ic_round_movie_filter_24,"Bagaimana cara mengunduh Episode?","Unduh 1DM atau ADM dari Google Play Store.\n• Masuk ke aplikasi, berikan akses penyimpanan, dan setel preferensi Anda (kecepatan unduh, jalur unduh, dll.(opsional))\n• Sekarang buka `Saikou > Pengaturan > Umum > Pengelola Unduhan` dan pilih manajer unduhan yang baru saja Anda siapkan.\n• Buka episode yang diinginkan dan tekan ikon unduhan dari server mana pun. Mungkin ada munculan untuk mengatur preferensi Anda lagi, cukup tekan \"Unduh\" dan itu akan disimpan di jalur yang diarahkan.\n\nCatatan: Unduhan langsung juga dimungkinkan tanpa pengelola tetapi tidak disarankan."),
        Triple(R.drawable.ic_round_menu_book_24,"Bagaimana cara mengunduh Bab Manga?","Belum mungkin mengunduh bab di Saikou tetapi fitur ini akan segera diterapkan."),
        Triple(R.drawable.ic_round_lock_open_24,"Bagaimana cara mengaktifkan konten NSFW?","Anda dapat mengaktifkan konten nsfw dengan mengaktifkan konten 18+ dari [link](https://anilist.co/settings/media)"),
        Triple(R.drawable.ic_round_smart_button_24,"Bagaimana cara mengimpor daftar MAL/Kitsu saya ke Anilist?","Begini caranya,\n\nEkspor:\nBuka [tautan](https://malscraper.azurewebsites.net/) ini. Kemudian berikan nama pengguna Kitsu/MAL Anda dan unduh daftar anime dan manga. (mereka akan dalam format xml)\nCatatan: Anda harus menulis nama pengguna pelacak yang Anda pilih\n\nImpor:\nSetelah mengekspor daftar anime dan manga Anda dari kitsu/MAL, sekarang buka [di sini](https://anilist.co/settings/import)\nPilih/letakkan file xml anime pada kotak di atas.\nPilih/letakkan file xml manga pada kotak di bawah."),
        Triple(R.drawable.ic_round_smart_button_24,"Bagaimana cara mengimpor daftar Anilist/Kitsu saya ke MAL?","Begini caranya,\n\nEkspor:\nBuka [tautan](https://malscraper.azurewebsites.net/) ini. Kemudian berikan nama pengguna Anilist/ID Kitsu Anda di kotak \"Nama Pengguna/ID Pengguna Kitsu\". Kemudian pilih jenis daftar dan Aktifkan 'update_on_import'. Kemudian unduh file tersebut, itu akan dalam format .xml. Pastikan untuk mengunduh daftar Anime dan Manga.\n\nImpor:\nUntuk mengimpornya di akun MAL Anda, buka [tautan](https://myanimelist.net/import.php) ini dan pilih \"MyAnimeList Import\" sebagai jenis impor. Sekarang tekan \"Pilih File\" dan pilih file xml daftar anime/manga yang diunduh. Kemudian tekan \"Impor Data\". Selamat, Anda baru saja mengimpor daftar yang dipilih ke akun MAL Anda."),
        Triple(R.drawable.ic_round_info_24,"Mengapa saya tidak dapat menemukan judul anime/manga tertentu?","Katakanlah Anda sedang mencari Castlevania di Saikou. Tapi Anilist tidak memilikinya, jadi saikou juga tidak.\nSolusi untuk masalah di atas adalah sebagai berikut-\n1) Buka anime apa pun yang tidak ada dalam daftarmu.\n2) Buka bagian tontonan.\n3) Pilih sumber mana saja dan tekan judul yang salah.\n4) Sekarang cari Castlevania (Anime yang Anda cari) dan pilih.\n5) NIKMATI!\n\nJika Anda tidak dapat menemukan anime bahkan melalui langkah-langkah ini, maka itu nasib buruk untuk Anda. Bahkan sumber itu tidak memilikinya. Coba sumber lain."),
        Triple(R.drawable.ic_round_help_24,"Bagaimana cara memperbaiki sumber yang memilih judul yang benar-benar salah?","Jika aplikasi Anda memilih judul yang salah, Anda dapat memperbaikinya dengan menekan \"salah judul?\" di atas tata letak dan memilih judul yang benar"),
        Triple(R.drawable.ic_round_art_track_24,"Bagaimana cara membaca manga berwarna?","Apakah Anda sedang mencari manga berwarna? Maaf untuk menyampaikannya kepada Anda tetapi sejumlah kecil manga memiliki versi berwarna. Yang memiliki versi berwarna juga tersedia di Saikou. Katakanlah Anda ingin membaca versi berwarna dari Chainsaw Man. Kemudian ikuti langkah-langkah di bawah ini ↓\n\n1) Pergi ke Chainsaw Man\n2) Tekan 'Baca'\n3) Pilih sumber yang berfungsi\n4) Tekan 'Salah Judul'\n5) Pilih versi berwarna chainsaw Man\n6 ) Selamat menikmati\n\nCatatan: Banyak sumber tidak menyediakan versi berwarna meskipun tersedia di suatu tempat di internet. Jadi coba sumber lain. Jika tidak ada sumber yang memilikinya, maka versi berwarna dari manga yang Anda inginkan tidak ada. Jika Anda dapat menemukannya di situs manga mana pun di internet, Anda dapat menyarankan situs tersebut melalui server discord."),
        Triple(R.drawable.ic_round_video_settings_24,"Handshake gagal? Mengapa tidak ada stempel waktu yang tidak dimuat?","Anda dapat memperbaiki masalah ini dengan mengaktifkan `Proxy` dari \n`pengaturan > anime > pengaturan pemutaran > stempel waktu > proxy`\nJika stempel waktu masih tidak dimuat tetapi handshake gagal muncul telah diperbaiki, maka episode yang Anda tonton belum memiliki stempel waktu untuk itu."),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFaqBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initActivity(this)

        binding.devsTitle2.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.devsRecyclerView.adapter = FAQAdapter(faqs, supportFragmentManager)
        binding.devsRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}
