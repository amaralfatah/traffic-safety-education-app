package com.eduproject.trafficsafetyeducation.core.utils

import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.DataEntity
import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.Postest

object InitialDataSource {

    fun getQuestions(): List<DataEntity> {
        return listOf(
            DataEntity(
                1,
                "Fungsi Marka jalan adalah ",
                listOf(
                    "Untuk memberi batas jalan agar jalan terlihat jelas oleh pemakai jalan Yang sedang berlalu lintas dijalan.",
                    "Untuk menambah dan mengurangi kecepatan pemakai jalan yang Berlalu lintas dijalan.",
                    "Untuk mengatur lalu lintas atau memperingatkan atau menuntun Pemakai jalan dalam berlalu lintas di jalan"
                ),
                "C",
                images = "dishub_logo"
            ),
        )

    }

    fun postestQuestions(): List<Postest> {
        return listOf(
            Postest(
                1,
                "Bagaimana pengemudi sepeda motor dapat mengetahui bahwa lampu Besarnya menyala dengan sinar jarak jauh?",
                listOf(
                    "Dari pelaku pemakai jalan yang berpapasan yang memainkan lampu jauh berganti-ganti dengan lampu pendek",
                    "Lampu petunjuk kecil berwarna biru di atas dashboard sepeda motor",
                    "Kedua petunjuk di atas benar."
                ),
                "C"
            ),
            Postest(
                2,
                "Bila hendak memboncengkan penumpang, sepeda motor harus dilengkapi dengan :",
                listOf(
                    "Tempat duduk, injakan kaki, dan pegangan untuk yang dibelakang",
                    "Injakan kaki dan pegangan untuk yang dibonceng",
                    "Tempat untuk barang yang dibonceng"
                ),
                "A"
            ),
            Postest(
                3,
                "Apa yang harus selalu Anda kenakan saat berkendara motor?",
                listOf(
                    "Helm",
                    "Topi",
                    "Sarung tangan"
                ),
                "A"
            ),
            Postest(
                4,
                "Tanda lalu lintas dengan lingkaran berwarna merah dengan garis melintang putih menunjukkan:",
                listOf(
                    "Larangan parkir",
                    "Zona bebas henti",
                    "Zona berhenti"
                ),
                "B"
            ),
            Postest(
                5,
                "Tanda lalu lintas berbentuk segitiga dengan tepi merah dan gambar sebuah mobil melaju menunjukkan:",
                listOf(
                    "Jalur khusus untuk mobil",
                    "Peringatan adanya jalan berbahaya",
                    "Tempat parkir"
                ),
                "B"
            ),
            Postest(
                6,
                "Apa yang seharusnya Anda lakukan saat lampu lalu lintas berwarna kuning?",
                listOf(
                    "Lanjutkan berkendara dengan cepat",
                    "Percepat laju kendaraan",
                    "Persiapkan untuk berhenti"
                ),
                "C"
            ),
            Postest(
                7,
                "Saat melintasi perlintasan kereta api, apa yang harus Anda lakukan jika palang pintu tertutup?",
                listOf(
                    "Berhenti dan menunggu sampai palang pintu terbuka",
                    "Melintasi perlintasan dengan kecepatan tinggi",
                    "Klakson keras agar kereta tahu Anda datang"
                ),
                "A"
            ),
            Postest(
                8,
                "Apa yang harus Anda lakukan ketika melihat marka jalan berwarna kuning ganda di tengah jalan?",
                listOf(
                    "Berkendara di atasnya",
                    "Melewati marka tersebut jika memungkinkan",
                    "Hindari melintasinya"
                ),
                "B"
            ),
            Postest(
                9,
                "Saat berkendara di malam hari, apa yang harus Anda pastikan terkait lampu kendaraan Anda?",
                listOf(
                    "Hidupkan lampu utama sepanjang waktu",
                    "Hidupkan lampu kejut malam",
                    "Matikan semua lampu untuk menghemat energi"
                ),
                "A"
            ),
            Postest(
                10,
                "Lambang pertolongan pertama di jalan umum adalah:",
                listOf(
                    "Segitiga berwarna merah",
                    "Kotak berwarna biru",
                    "Lingkaran berwarna merah"
                ),
                "B"
            ),
            Postest(
                11,
                "Bagaimana Anda seharusnya melintasi jalan raya?",
                listOf(
                    "Di mana pun Anda inginkan",
                    "Pada lintasan pejalan kaki atau zebra cross",
                    "Menyeberang tanpa memandang kendaraan lain"
                ),
                "B"
            ),
            Postest(
                12,
                "Apa yang harus Anda lakukan jika Anda melihat sebuah kecelakaan lalu lintas?",
                listOf(
                    "Langsung melanjutkan perjalanan Anda",
                    "Memanggil nomor darurat dan memberikan bantuan jika aman",
                    "Mengambil barang-barang berharga dari kendaraan yang kecelakaan"
                ),
                "B"
            ),
            Postest(
                13,
                "Apa yang harus menjadi prioritas utama saat berkendara?",
                listOf(
                    "Menggunakan ponsel",
                    "Mematuhi aturan lalu lintas",
                    "Memperlambat kendaraan"
                ),
                "B"
            ),
            Postest(
                14,
                "Tanda lalu lintas berbentuk segitiga dengan gambar pejalan kaki menunjukkan:",
                listOf(
                    "Zona parkir",
                    "Zona bebas henti",
                    "Perlintasan pejalan kaki"
                ),
                "C"
            ),
            Postest(
                15,
                "Apa yang seharusnya Anda lakukan saat Anda ingin berbelok kanan di persimpangan?",
                listOf(
                    "Selalu berbelok tanpa memperhatikan lalu lintas sekitar",
                    "Memberi tanda belok kanan dan memastikan tidak ada kendaraan atau pejalan kaki yang akan terganggu",
                    "Berbelok tanpa memberi tanda"
                ),
                "B"
            ),
            Postest(
                16,
                "Saat mengendarai sepeda motor, apa yang harus selalu Anda kenakan untuk melindungi diri?",
                listOf(
                    "Topi",
                    "Jaket berlengan panjang",
                    "Helm"
                ),
                "C"
            ),
            Postest(
                17,
                "Apa yang harus Anda lakukan jika Anda melihat tanda lalu lintas berbentuk lingkaran dengan garis merah di tengahnya?",
                listOf(
                    "Hentikan kendaraan dan beri prioritas",
                    "Lanjutkan tanpa memperhatikan",
                    "Geser ke jalur lain"
                ),
                "A"
            ),
            Postest(
                18,
                "Ketika bersepeda, di mana Anda seharusnya berkendara di jalan raya?",
                listOf(
                    "Di tengah jalan",
                    "Di trotoar",
                    "Di jalur sepeda atau pinggir jalan"
                ),
                "C"
            ),

            Postest(
                19,
                "Apa yang harus Anda lakukan jika Anda melihat tanda lalu lintas berwarna merah dengan tulisan 'BERHENTI'?",
                listOf(
                    "Lanjutkan berkendara",
                    "Berhenti sepenuhnya",
                    "Percepat laju kendaraan"
                ),
                correctAnswer = "B"
            ),
            Postest(
                20,
                "Apa fungsi dari rambu lalu lintas berbentuk lingkaran dengan angka di dalamnya?",
                listOf(
                    "Batasan kecepatan maksimum",
                    "Batasan kecepatan minimum",
                    "Batasan berat kendaraan"
                ),
                correctAnswer = "A"
            ),
            Postest(
                21,
                "Bagaimana Anda seharusnya mendekati perlintasan kereta api tanpa palang pintu?",
                listOf(
                    "Berhenti dan menunggu",
                    "Melintas perlahan tanpa memperhatikan kereta",
                    "Memberikan isyarat kepada kereta untuk berhenti"
                ),
                correctAnswer = "A"
            ),
            Postest(
                22,
                "Apa yang harus Anda lakukan ketika hujan turun saat Anda sedang berkendara?",
                listOf(
                    "Matikan lampu kendaraan",
                    "Menambah kecepatan untuk sampai tujuan lebih cepat",
                    "Mengurangi kecepatan dan meningkatkan jarak aman dengan kendaraan lain"
                ),
                correctAnswer = "C"
            ),
            Postest(
                23,
                "Bagaimana cara memperoleh SIM C di Indonesia?",
                listOf(
                    "Dengan membayar biaya pembuatan SIM C",
                    "Dengan mengikuti tes kesehatan, teori, dan praktik",
                    "Semua jawaban benar"
                ),
                correctAnswer = "B"
            ),
            Postest(
                24,
                "Berapa usia minimal untuk mendapatkan SIM C di Indonesia?",
                listOf(
                    "16 tahun",
                    "17 tahun",
                    "21 tahun"
                ),
                correctAnswer = "B"
            ),
            Postest(
                25,
                "Apakah STNK adalah surat yang membuktikan bahwa seseorang memiliki hak atas kendaraan bermotor di Indonesia?",
                listOf(
                    "Ya, STNK adalah surat yang membuktikan hak atas kendaraan bermotor",
                    "STNK adalah surat pemilikan kendaraan bermotor",
                    "STNK adalah surat keterangan kendaraan bermotor"
                ),
                correctAnswer = "A"
            ),
            Postest(
                26,
                "Apakah sepeda motor dengan transmisi manual dan kopling manual lebih baik digunakan untuk medan yang berat dibandingkan dengan sepeda motor dengan transmisi otomatis dan kopling otomatis?",
                listOf(
                    "Ya, sepeda motor dengan transmisi manual dan kopling manual lebih baik digunakan untuk medan yang berat",
                    "Kedua-duanya sama baiknya digunakan untuk medan yang berat",
                    "Tergantung pada kemampuan pengendara"
                ),
                correctAnswer = "A"
            ),
            Postest(
                27,
                "Bagian utama sepeda motor yang berfungsi sebagai pendorong adalah?",
                listOf(
                    "Roda belakang",
                    "Mesin",
                    "Stang"
                ),
                correctAnswer = "B"
            ),
            Postest(
                28,
                "Apa fungsi kopling pada sepeda motor?",
                listOf(
                    "Menghubungkan mesin dengan roda belakang",
                    "Menambah kecepatan mesin",
                    "Mengatur daya yang diterima oleh roda belakang"
                ),
                correctAnswer = "A"
            ),
            Postest(
                29,
                "Bagian sepeda motor yang berfungsi untuk memberikan informasi kecepatan mesin adalah?",
                listOf(
                    "Speedometer",
                    "Roda belakang",
                    "Kopling"
                ),
                correctAnswer = "A"
            ),
            Postest(
                30,
                "Fungsi dari sistem pendingin pada sepeda motor adalah?",
                listOf(
                    "Menjaga agar mesin tetap stabil saat mengubah gear",
                    "Menjaga mesin tetap dalam kondisi dingin",
                    "Menambah daya mesin"
                ),
                correctAnswer = "A"
            ),
            Postest(
                31,
                "Fungsi sistem pengereman pada sepeda motor adalah?",
                listOf(
                    "Menambah kecepatan mesin",
                    "Menambah stabilitas pada saat berbelok",
                    "Memperlambat atau menghentikan sepeda motor"
                ),
                correctAnswer = "C"
            ),
            Postest(
                32,
                "Bagian sepeda motor yang berfungsi untuk menjaga sepeda motor tetap berdiri:",
                listOf(
                    "Kick stand",
                    "Speedometer",
                    "Roda belakang"
                ),
                correctAnswer = "A"
            ),
            Postest(
                33,
                "Apa Saja Kelengkapan Berkendara ( Riding Gear ) ?",
                listOf(
                    "Helm, Jaket , Sepatu dan Tas",
                    "Helm, Jaket , Sarung Tangan , Celana Panjang dan Sepatu",
                    "Jaket, Helm , Sarung , Sepatu dan Kaos Kaki"
                ),
                correctAnswer = "B"
            ),
            Postest(
                34,
                "Helm SNI untuk pengendara & penumpang sepeda motor adalah Helm yang dapat melindungi kepala bagian mana?",
                listOf(
                    "Yang dapat melindungi rahang dan otak belakang",
                    "Yang dapat melindungi bagian pundak dan tangan",
                    "Yang dapat melindungi bagian mata dan hidung"
                ),
                correctAnswer = "A"
            ),
            Postest(
                35,
                "Fungsi utama dari sepatu saat berkendara sepeda motor adalah?",
                listOf(
                    "Melindungi kaki dari angin dan cuaca",
                    "Memberikan perlindungan pada kaki",
                    "Semua jawaban di atas benar"
                ),
                correctAnswer = "C"
            ),
            Postest(
                36,
                "Fungsi utama dari jaket yang berwarna terang saat berkendara sepeda motor adalah?",
                listOf(
                    "Melindungi dari angin dan cuaca",
                    "Membuat pengendara terlihat lebih menarik",
                    "Memberikan perlindungan pada badan saat terjadi kecelakaan"
                ),
                correctAnswer = "C"
            ),
            Postest(
                37,
                "Jika pengendara sepeda motor berada di jalur kiri jalan, cara berkendara yang benar adalah?",
                listOf(
                    "Berkendara dengan kecepatan tinggi dan tidak memperhatikan kendaraan lain",
                    "Berkendara dengan kecepatan rendah dan menghindari kendaraan lain",
                    "Berkendara dengan kecepatan rendah dan memperhatikan kendaraan di sebelah kiri"
                ),
                correctAnswer = "C"
            ),
            Postest(
                38,
                "Jika pengendara sepeda motor ingin berpindah jalur, cara berkendara yang benar adalah?",
                listOf(
                    "Berkendara dengan kecepatan tinggi dan berpindah jalur tanpa melihat kendaraan lain",
                    "Berkendara dengan kecepatan rendah dan berpindah jalur tanpa melihat kendaraan lain",
                    "Berkendara dengan kecepatan normal dan memperhatikan kendaraan lain saat berpindah jalur"
                ),
                correctAnswer = "C"
            ),
            Postest(
                39,
                "Jika pengendara sepeda motor melintas di jalan yang ada pejalan kaki dan hewan, cara berkendara yang benar adalah?",
                listOf(
                    "Berkendara dengan kecepatan tinggi dan tidak memperhatikan pejalan kaki dan hewan",
                    "Berkendara dengan kecepatan rendah dan tidak memperhatikan pejalan kaki dan hewan",
                    "Berkendara dengan kecepatan rendah dan memperhatikan pejalan kaki dan hewan"
                ),
                correctAnswer = "C"
            ),
            Postest(
                40,
                "Jika pengendara sepeda motor melewati jalan dengan rambu lalu lintas, cara berkendara yang benar adalah?",
                listOf(
                    "Berkendara dengan kecepatan tinggi dan tidak memperhatikan rambu lalu lintas",
                    "Berkendara dengan kecepatan rendah dan tidak memperhatikan rambu lalu lintas",
                    "Berkendara dengan kecepatan normal dan memperhatikan rambu lalu lintas"
                ),
                correctAnswer = "C"
            ),
            Postest(
                41,
                "Jika pengendara sepeda motor melewati jalan yang berbatu, cara berkendara yang benar adalah?",
                listOf(
                    "Berkendara dengan kecepatan tinggi dan tidak memperhatikan kondisi jalan berbatu",
                    "Berkendara dengan kecepatan rendah dan memperhatikan kondisi jalan berbatu",
                    "Berkendara dengan kecepatan rendah dan tidak memperhatikan kondisi jalan berbatu"
                ),
                correctAnswer = "B"
            ),
            Postest(
                42,
                "Saat melewati persimpangan, cara berkendara yang benar bagi pengendara sepeda motor adalah?",
                listOf(
                    "Berkendara dengan kecepatan normal dan menyalakan lampu sein untuk informasi pengendara lain",
                    "Berkendara dengan kecepatan tinggi dan tidak memperhatikan rambu lalu lintas",
                    "Berkendara dengan kecepatan rendah dan tidak memperhatikan rambu lalu lintas"
                ),
                correctAnswer = "A"
            ),
            Postest(
                43,
                "Pengertian umum dari istilah 'Safety Riding' adalah sebagai berikut, kecuali:",
                listOf(
                    "Keselamatan berkendara",
                    "Tata cara membeli kendaraan",
                    "Tata cara berkendara yang aman & benar"
                ),
                correctAnswer = "C"
            ),
            Postest(
                44,
                "Ada 3 (tiga) Faktor utama penyebab terjadinya kecelakaan, Faktor yang paling dominan penyebab terjadinya Kecelakaan adalah kecuali",
                listOf(
                    "Kendaraan",
                    "Lingkungan",
                    "Batu"
                ),
                correctAnswer = "C"
            ),
            Postest(
                45,
                "Tujuan umum dari Aktivitas Safety Riding adalah sebagai berikut:",
                listOf(
                    "Memberikan hadiah souvenir ke masyarakat",
                    "Salah satu sarana promosi ke masyarakat",
                    "Mendukung program pemerintah dalam mengurangi tingkat kecelakaan di jalan raya"
                ),
                correctAnswer = "C"
            ),
            Postest(
                46,
                "Salah satu aspek dasar pemilihan perlengkapan berkendara adalah sebagai berikut, kecuali :",
                listOf(
                    "Berwarna cerah (sehingga mudah terpantau oleh pengendara lain)",
                    "Model/Design Protek (model dirancang untuk dapat melindungi si pengendara )",
                    "Model/Design Nyaman (Model dirancang untuk dapat dipakai dengan nyaman)"
                ),
                correctAnswer = "A"
            ),
            Postest(
                47,
                "Berikut syarat yang harus dipenuhi oleh si pengendara saat berkendara di jalan, kecuali",
                listOf(
                    "Punya bekal pengetahuan yang cukup",
                    "Punya Nyali yang cukup",
                    "Punya bekal keterampilan yang cukup"
                ),
                correctAnswer = "B"
            ),
            Postest(
                48,
                "Mengapa tidak boleh mengendarai sepeda motor atau sepeda di bawah pengaruh alkohol atau obat-obatan terlarang?",
                listOf(
                    "Karena itu membuat Anda merasa lebih bahagia",
                    "Karena itu meningkatkan keterampilan mengemudi Anda",
                    "Karena itu dapat mengganggu kemampuan Anda mengemudi dan meningkatkan risiko kecelakaan"
                ),
                correctAnswer = "C"
            ),
            Postest(
                49,
                "Apa yang harus Anda lakukan saat menghadapi tanda lampu merah?",
                listOf(
                    "Berhenti dan tetap di tempat sampai lampu berubah menjadi hijau",
                    "Langsung melintas tanpa berhenti",
                    "Melanjutkan hanya jika tidak ada kendaraan lain di dekatnya"
                ),
                correctAnswer = "A"
            ),
            Postest(
                50,
                "Apa yang harus Anda perhatikan saat mengenakan pakaian pelindung saat berkendara di cuaca panas?",
                listOf(
                    "Memakai pakaian pendek",
                    "Memakai pakaian yang tidak sesuai ukuran",
                    "Memastikan pakaian pelindung yang sesuai dan cukup ventilasi untuk kenyamanan"
                ),
                correctAnswer = "C"
            )
        )


    }

}