package com.eduproject.trafficsafetyeducation.core.utils

import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.DataEntity
import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.Postest

object InitialDataSource {

//    fun getQuestions(): List<DataEntity> {
//        val listResultItem = ArrayList<DataEntity>()
//
//
//            for (i in 1..8){
//                val resultb = DataEntity(
//                    i,
//                    "Pertanyaan ${i} (jawaban A)",
//                    listOf("pilih ini ${i}", "ini ${i}", "ini${i}", "atau ini${i}"),
//                    "A"
//                )
//                listResultItem.add(resultb)
//
//            }
//        return listResultItem
//
//    }

    fun getQuestions(): List<DataEntity> {
        return listOf(
            DataEntity(
                1,
                "Fungsi Marka jalan adalah :",
                listOf(
                    "Untuk memberi batas jalan agar jalan terlihat jelas oleh pemakai jalan Yang sedang berlalu lintas dijalan.",
                    "Untuk menambah dan mengurangi kecepatan pemakai jalan yang Berlalu lintas dijalan.",
                    "Untuk mengatur lalu lintas atau memperingatkan atau menuntun Pemakai jalan dalam berlalu lintas di jalan"
                ),
                "C"
            ),
            DataEntity(
                2,
                "Yang bukan merupakan Marka Lambang adalah :",
                listOf(
                    "Segi tiga",
                    "Gambar",
                    "Panas"
                ),
                "C"
            ),
            DataEntity(
                3,
                ". Rambu dengan warna dasar kuning dengan lambang atau tulisan Berwarna hitam merupakan :",
                listOf(
                    "Rambu petunjuk",
                    "Rambu peringatan",
                    "Rambu perintah"
                ),
                "A"
            ),
            DataEntity(
                4,
                "Garis ganda yang terdiri dari garis utuh dan garis putus-putus termasuk :",
                listOf(
                    "Marka membujur",
                    "Marka melintang",
                    "Marka serong"
                ),
                "A"
            ),
            DataEntity(
                5,
                "Dalam suatu persimpangan jalan terdapat alat pemberi isyarat lalu lintas,Polisi lalu lintas dan polisi pamong praja. Isyarat lalu lintas yang manakah Yang harus diikuti oleh para pemakai jalan?",
                listOf(
                    "Alat Pemberi Isyarat lalu lintas",
                    "Polisi lalu lintas",
                    "Polisi pamong praja"
                ),
                "B"
            ),
            DataEntity(
                6,
                "Apa arti rambu berikut ?",
                listOf(
                    "Lajur atau bagian jalan yang wajib dilewati adalah sebelah kiri rambu ini",
                    "Satu satunya arah yang boleh ditempuh ialah ke kiri",
                    "Dilarang berjalan lurus kedepan"
                ),
                "B",
                images = "img_6"
            ),
            DataEntity(
                7,
                "Apa arti rambu berikut ?",
                listOf(
                    "Penyempitan kanan jalan",
                    "Perbaikan jalan",
                    "Jalan satu jurusan"
                ),
                "A",
                images = "img_7"
            ),
            DataEntity(
                8,
                "Anda berjalan dengan kecepatan kurang lebih 30 km per jam mendekati persimpangan yang diatur oleh lampu lalu lintas. Ketika lampu berubah dari warna hijau ke kuning, apa yang anda lakukan.",
                listOf(
                    "Berhenti",
                    "Jalan terus",
                    "Bersiap-siap berhenti karena belum melewati garis berhenti"
                ),
                "C"
            ),
            DataEntity(
                9,
                "Apabila anda ingin berpindah jalur dengan aman, maka anda harus",
                listOf(
                    "Memberikan isyarat secara jelas dan tepat waktunya dengan menggunakan petunjuk arah",
                    "Yakin bahwa tidak membahayakan pemakai jalan lain",
                    "Kedua jawaban diatas benar"
                ),
                "C"
            ),
            DataEntity(
                10,
                "Pengemudi diharuskan memberikan isyarat dengan petunjuk arah yang berkedip pada waktu",
                listOf(
                    "Akan berjalan atau akan mengubah arah ke kanan",
                    "Akan berjalan atau akan berhenti",
                    "Akan merubah arah ke kiri atau ke kanan."
                ),
                "C"
            ),
            DataEntity(
                11,
                "Teknik mengemudikan sepeda motor yang baik pada saat gerakan membelok adalah :",
                listOf(
                    "Menambah kecepatan pada jarak pendek sebelum mencapai tikungan",
                    "Memiringkan sepeda motor kearah pusat tikungan dan tetap dalam posisi tegak",
                    "Memiringkan sepeda motor dan pengemudi kearah pusat tikungan yang sesuai dengan kecepatan dan ketajaman tikungan"
                ),
                "C"
            ),
            DataEntity(
                12,
                "Apa kegunaan bahu jalan",
                listOf(
                    "Untuk pejalan Kaki",
                    "Untuk berhenti dan parkir",
                    "Untuk berhenti dalam keadaan darurat"
                ),
                "B"
            ),
            DataEntity(
                13,
                "Apa kegunaan helm ?",
                listOf(
                    "Untuk melindungi pandangan pengendara, melindungi pengendara dari Panas dan hujan",
                    "Untuk melindungi kepala dari benturan atau gesekan yang mengakibatkan luka di kepala",
                    "Untuk menambah penampilan pengendara dan merupakan kelengkapan bagi sepeda motor"
                ),
                "B"
            ),
            DataEntity(
                14,
                "Kendaraan yang digerakkan oleh peralatan teknik yang berada Pada kendaraan itu, disebut :",
                listOf(
                    "Sepeda motor",
                    "Kendaraan bermotor",
                    "Motor besar"
                ),
                "B"
            ),
            DataEntity(
                15,
                "Surat Izin Mengemudi golongan C digunakankan untuk :",
                listOf(
                    "Mengemudikan sepeda motor yang dirancang mampu mencapai kecepatan lebih dari 40 km per jam",
                    "Mengemudikan sepeda motor yang dirancang mampu mencapai kecepatan Tidak lebih dari 40 Km per jam",
                    "Pilihan a dan b salah"
                ),
                "A"
            ),
            DataEntity(
                16,
                "Menghadapi lampu kuning yang berkedip-kedip, maka tindakan yang benar, adalah:",
                listOf(
                    "Berjalan terus, kendaraan lain yang harus hati hati.",
                    "Setidak tidaknya berhenti dan beri jalan.",
                    "Mendekati dengan hati hati,mengurangi kecepatan jika perlu berhenti dan beri jalan."
                ),
                "C"
            ),
            DataEntity(
                17,
                "Dilarang mendahului kendaraan lain yang sedang berjalan walaupun tidak ada rambu rambu yang melarangnya pada :",
                listOf(
                    "Jalan yang menurun",
                    "Jalan yang berlubang lubang",
                    "Jalan tikungan"
                ),
                "C"
            ),
            DataEntity(
                18,
                "Pengemudi dilarang berhenti :",
                listOf(
                    "Pada belokan, persimpangan dan jembatan",
                    "Tanpa terpaksa pada belokan, persimpangan, dan jembatan, pada jalan-jalan yang ada rambu larangan parkir",
                    "Tanpa terpaksa, berhenti pada jalan belokan, persimpangan, dan jembatan, pada jalan-jalan yang ada rambu larangan berhenti"
                ),
                "C"
            ),
            DataEntity(
                19,
                "Dilarang parkir kendaraan :",
                listOf(
                    "Di belokan/ persimpangan jalan milik perkebunan yang tidak ada tanda larangan berhenti.",
                    "Pada jalan yang naik/turun.",
                    "Dibelokan, persimpangan persimpangan jalan, jembatan dan tempat lain yang ada rambu larangan parkir."
                ),
                "C"
            ),
            DataEntity(
                20,
                "Pada suatu ruas jalan ada 2 (dua) macam marka jalan berupa tanda garis membujur berwarna putih yang satu utuh dan yang disebelahnya lagi putus-putus, tanda garis mana yang harus dipatuhi oleh pengemudi :",
                listOf(
                    "Yang terdekat",
                    "Yang terjauh",
                    "Kedua-duanya"
                ),
                "A"
            ),
            DataEntity(
                21,
                "SIM apakah Yang perlu dimiliki, bila anda akan mengemudikan sepeda motor 300 CC dengan kereta samping",
                listOf(
                    "SIM A",
                    "SIM C",
                    "SIM D"
                ),
                "B"
            ),
            DataEntity(
                22,
                "Anda diwajibkan menggunakan pesawat penunjuk apabila :",
                listOf(
                    "Hendak berpapasan",
                    "Hendak mundur",
                    "Hendak beralih kejalur lain dijalan yang terbagi atas beberapa lajur"
                ),
                "C"
            ),
            DataEntity(
                23,
                "Pengemudi kendaraan bermotor yang terbukti beberapa kali melakukan pelanggaran lalu lintas atau pengemudi kendaraan bermotor yang terlibat sebagai tersangka dalam kasus kecelakaan lalu lintas dengan korban luka berat atau meninggal dunia, maka Polri berwenang untuk :",
                listOf(
                    "Membatalkan SIMnya",
                    "Melakukan uji ulang",
                    "Mencabut SIM nya"
                ),
                "B"
            ),
            DataEntity(
                24,
                "Apabila petugas mengatur lalu lintas dengan semprita, tiupan panjang satu kali, berarti :",
                listOf(
                    "Jalan",
                    "Berhenti",
                    "Meminta perhatian pemakai jalan"
                ),
                "B"
            ),
            DataEntity(
                25,
                "Tanda kendaraan bermotor dianggap sah apabila :",
                listOf(
                    "Dibuat sendiri oleh pemilik kendaraan bermotor, asalkan sesuai dengan persyaratan undang undang.",
                    "Dibuat sendiri sambil menunggu pelat nomor asli dari Polri.",
                    "Diperoleh dari Polisi Lalu Lintas yang mengeluarkan STNK dan Pelat Nomor."
                ),
                "C"
            ),
            DataEntity(
                26,
                "Apa yang anda harus lakukan bila anda melihat pejalan kaki Menunggu untuk menyebrang di tempat Zebra cross?",
                listOf(
                    "Lewati Tempat Penyebrangan secepat mungkin",
                    "Dekati tempat panyebrangan pejalan kaki dengan kecepatan yang sedemikian rupa, sehingga bila perlu dapat dihentikan",
                    "Jangan berhenti anda berhak melintas lebih dulu"
                ),
                "B"
            ),
            DataEntity(
                27,
                "Bagaimana seharusnya sikap yang terpuji dari setiap pangemudi?",
                listOf(
                    "Memperlihatkan kepandaian dan Kelihaian mengemudi kepada pemakai jalan lain",
                    "Sedemikian rupa sehingga selalu mengalah dan berjalan dipinggir jalan",
                    "Sedemikian rupa sehingga keselamatan dan keamanan lalu lintas selalu diutamakan"
                ),
                "C"
            ),
            DataEntity(
                28,
                "STNK selalu terkait dengan :",
                listOf(
                    "Seorang dan kendaraan bermotor",
                    "Orang tertentu dan daerah tempat kendaraan itu menetap",
                    "Kendaraan bermotor, orang tertentu, dan daerah tempat kendaraan itu menetap"
                ),
                "C"
            ),
            DataEntity(
                29,
                "Helmisasi perlu dilakukan untuk mencegah cedera pada bagian kepala bila mengalami suatu kecelakaan, ketentuan yang harus diikuti adalah sbb :",
                listOf(
                    "Pengemudi saja yang harus memakai Helm",
                    "Pengemudi dan pembonceng harus memakai Helm",
                    "Pengemudi sepeda motor yang kurang dari 100 CC tidak diharuskan memakai helm"
                ),
                "B"
            ),
            DataEntity(
                30,
                "Perubahan yang tidak boleh dilakukan pada sepada motor yang dapat Menyebabkan STNK tidak sah lagi, adalah :",
                listOf(
                    "Memasang dan mengganti mesin dengan kemampuan yang lebih besar",
                    "Mengganti kaca spion dan tempat duduk",
                    "Mengadakan perubahan pada sistem pembuangan (modifikasi knalpot)"
                ),
                "A"
            ),
            DataEntity(
                31,
                "Kendaraan apa yang berbahaya untuk didahului dan harus didahului hanya pada Jarak yang memadai untuk mendahului :",
                listOf(
                    "Kendaraan roda 2",
                    "Kendaraan roda 3",
                    "Kendaraan roda 4"
                ),
                "A"
            ),
            DataEntity(
                32,
                "Sebagai pengemudi motor maka :",
                listOf(
                    "Untuk mencapai tujuan yang lebih cepat diperbolehkan zig zag diantara mobil, asalkan tidak terjadi kecelakaan.",
                    "Hanya boleh mendahului dari sebelah kanan apabila tidak ada rintangan lalu lintas lain dan dapat dilakukan dengan aman.",
                    "Diperbolehkan mendahului kendaraan lain dari kiri atau kanan."
                ),
                "B"
            ),
            DataEntity(
                33,
                "Perbuatan pertama apa yang anda lakukan sebagai pengemudi, Apabila terjadi tabrakan?",
                listOf(
                    "Segera hentikan kendaraan, biarpun ditengah jalan. Yang penting adalah menunjukkan bekas-bekas rem kepada petugas polisi bahwa anda berada pada jalur yang benar sesuai peraturan.",
                    "Segera menghentikan kendaraan dan mendatangi pengemudi kendaraan lawan tabrakan, untuk meminta pertanggung- jawaban kerugian yang anda derita.",
                    "Segera menghentikan kendaraan, dan melaporkan kejadian kecelakaan tersebut kepada pos polisi terdekat."
                ),
                "C"
            ),
            DataEntity(
                34,
                "Apabila anda mendengar suara sirine yang kemungkinan dari pemadam Pemadam kebakaran, Polisi atau konvoi kendaraan. Anda diharuskan :",
                listOf(
                    "Menambah kecepatan",
                    "menepi dan berhenti sampai konvoi lewat dan jalan aman",
                    "Akhiri kecepatan minimum yang diwajibkan"
                ),
                "B"
            ),
            DataEntity(
                35,
                "Apa arti rambu berikut ?",
                listOf(
                    "Daerah berbahaya",
                    "Akhir dari semua larangan setempat terhadap kendaraan bergerak",
                    "Beri kesempatan kepada kendaraan bermotor"
                ),
                "B",
                images = "img_35"
            ),
            DataEntity(
                36,
                "Apa arti Rambu berikut ?",
                listOf(
                    "Kecepatan minimum yang diwajibkan",
                    "Kecepatan tidak boleh melebihi 30 km per jam",
                    "Akhir kecepatan minimum yang diwajibkan"
                ),
                "B",
                images = "img_36"
            ),
            DataEntity(
                37,
                "Apa arti rambu berikut ?",
                listOf(
                    "Silang datar berpintu",
                    "Silang datar dengan dua atau lebih jalur rel",
                    "Silang datar dengan satu jalur rel"
                ),
                "C",
                images = "img_37"
            ),
            DataEntity(
                38,
                "Apa arti rambu berikut ?",
                listOf(
                    "Wajib mengikuti arah ke kanan",
                    "Lajur bagian jalan yang wajib diikuti",
                    "Wajib mengikuti arah yang ditunjuk"
                ),
                "A",
                images = "img_38"
            ),
            DataEntity(
                39,
                "Apa arti rambu berikut? ",
                listOf(
                    "Rambu petunjuk tempat berbalik arah",
                    "Tikungan tajam kekanan",
                    "Wajib mengikuti arah yang ditentukan"
                ),
                "A",
                images = "img_39"
            ),
            DataEntity(
                40,
                "Apa arti rambu berikut ?",
                listOf(
                    "Wajib berjalan lurus kedepan",
                    "Jalan satu arah lurus",
                    "Awal berlakunya rambu sesuai arah panah lalu lintas ke depan"
                ),
                "A",
                images = "img_40"
            ),
            DataEntity(
                41,
                "Apa arti rambu berikut ?",
                listOf(
                    "Dilarang parkir sampai dengan jarak 15 m dari tempat pemasangan rambu menurut arah lalu lintas kecuali yang dinyatakan lain dengan papan tambahan",
                    "Dilarang berhenti sampai dengan jarak 15m dari tempat pemasangan rambu menurut arah lalu lintas kecuali yang dinyatakan lain dengan papan tambahan",
                    "Larangan mengikuti kendaraan di depan kurang dari 15 meter"
                ),
                "B",
                images = "img_41"
            ),
            DataEntity(
                42,
                "Apa arti rambu berikut ?",
                listOf(
                    "Larangan masuk bagi gerobak dorong dan sejenisnya",
                    "Larangan masuk bagi delman dan sejenisnya",
                    "Larangan masuk bagi gerobak dorong, pedati, dan sejenisnya"
                ),
                "B",
                images = "img_42"
            ),
            DataEntity(
                43,
                "Apa arti rambu berikut ?",
                listOf(
                    "Larangan masuk bagi semua kendaraan bermotor maupun tidak bermotor dari kedua arah",
                    "Larangan masuk bagi semua kendaraan bermotor maupun tidak bermotor dari satu arah masuk",
                    "Larangan masuk bagi semua kendaraan bermotor"
                ),
                "A",
                images = "img_43"
            ),
            DataEntity(
                44,
                "Apa arti rambu berikut ?",
                listOf(
                    "Dilarang berjalan terus apabila mengakibatkan rintangan/hambatan/gangguan bagi lalu lintas dari arah lain yang wajib didahulukan.",
                    "Dilarang berjalan terus, wajib berhenti sesaat dan meneruskan perjalanan setelah mendapat kepastian aman dari lalu lintas arah lainnya.",
                    "Dilarang berjalan terus, wajib berhenti sesaat sebelum bagian jalan tertentu dan meneruskan perjalanan setelah mendahulukan kendaraan dari arah depan secara tersamar."
                ),
                "B",
                images = "img_44"
            ),
            DataEntity(
                45,
                "Apa arti rambu berikut ?",
                listOf(
                    "Semua kendaraan dilarang masuk",
                    "Semua pemakai jalan dilarang masuk",
                    "Semua kendaraan bermotor dilarang"
                ),
                "A",
                images = "img_45"
            ),
            DataEntity(
                46,
                "Apa arti rambu berikut ?",
                listOf(
                    "Wajib mengikuti salah satu lajur yang ditunjuk",
                    "Wajib mengikuti salah satu arah yang ditunjuk",
                    "Wajib berjalan lurus kedepan"
                ),
                "B",
                images = "img_46"
            ),
            DataEntity(
                47,
                "Apa yang harus anda hindari apabila anda melewati rambu ini ?",
                listOf(
                    "Menambah kecepatan",
                    "Mengerem dengan kuat dan mendadak",
                    "Melakukan gerakan gerakan mengemudi yang mendadak atau mengerem dengan kuat dan mendadak"
                ),
                "C",
                images = "img_47"
            ),
            DataEntity(
                48,
                "Apa arti rambu berikut ?",
                listOf(
                    "Semua kendaraan dilarang masuk",
                    "Semua kendaraan bermotor dilarang masuk",
                    "c. Semua kendaraan bermotor dilarang melintas dan parkir "
                ),
                "B",
                images = "img_48"
            ),
            DataEntity(
                49,
                "Demi pengamanan kepala dari cedera apabila mengalami kecelakaan, maka Helmisasi perlu dengan ketentuan :",
                listOf(
                    "Pengemudi dan pembonceng harus memakai helm",
                    "Pengemudi sepeda motor yang kurang dari 100 cc tidak diharuskan memakai helm",
                    "Pembonceng tidak diharuskan memakai helm"
                ),
                "A"
            ),
            DataEntity(
                50,
                "Perubahan pada sepeda motor yang dapat menyebabkan STNK nya tidak Sah lagi adalah :",
                listOf(
                    "Memasang/mengganti mesin dengan kemampuan yang lebih besar",
                    "Mengganti kaca spion",
                    "Mengadakan perubahan pada sistim pembuangan"
                ),
                "A"
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