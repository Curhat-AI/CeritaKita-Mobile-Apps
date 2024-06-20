package com.ceritakita.app.recognition.presentation.data.constant

import com.ceritakita.app.R

object SelfHelpData {
    val selfHelpMaterials = mapOf(
        "Cemas" to SelfHelpMaterial(
            imageResId = R.drawable.sample_image,
            mainTitle = "Memahami dan Mengelola Kecemasan",
            mainDescription = "Kecemasan adalah bagian alami dari kehidupan manusia, namun terkadang bisa menjadi berlebihan dan mengganggu. Pelajari apa itu kecemasan, fungsinya, dan bagaimana CeritaKita dapat membantu Anda memahami dan mengelolanya dengan lebih baik.",
            sessions = listOf(
                SelfHelpSession(
                    title = "Apa itu kecemasan?",
                    description = "Kecemasan adalah emosi normal yang dimiliki semua orang. Biasanya dialami untuk mengantisipasi ancaman di masa depan, baik yang nyata maupun yang dirasakan. Hal ini berbeda dengan rasa takut, yang merupakan respons terhadap ancaman langsung. Pengalaman kecemasan terdiri dari cara Anda berpikir, merasa, dan bertindak. "
                ),
                SelfHelpSession(
                    title = "Apa fungsi dari kecemasan?",
                    description = "Emosi, baik yang menyenangkan maupun tidak menyenangkan, merupakan bagian dari diri manusia. Bahkan emosi yang tidak menyenangkan pun berguna karena dapat memberi tahu kita ketika ada sesuatu yang salah dan mendorong kita untuk bertindak. Dengan demikian, kecemasan bertindak sebagai sistem alarm alami tubuh. Jika kita tidak memiliki kecemasan, kita mungkin tidak akan waspada untuk melarikan diri dari situasi berbahaya. Kecemasan juga berguna untuk situasi seperti menghadapi masalah yang sulit di tempat kerja, mengikuti tes, atau membuat keputusan penting. Kecemasan dapat memberi Anda dorongan energi dan fokus, atau memotivasi Anda untuk bekerja keras mengatasi situasi yang dihadapi."
                ),
                SelfHelpSession(
                    title = "Bagaimana CeritaKita dapat membantu kecemasanmu?",
                    description = "Untungnya, ada banyak perawatan yang efektif untuk gangguan kecemasan. CeritaKita membantumu memberikan pandangan atas cerita dan fotomu dengan kemungkinan apa yang kamu rasakan dan alami saat ini menggunakan AI, walaupun diagnosis ini tidak bisa digunakan dalam kebutuhan psikolog medis, akan tetapi ini akan membantumu dalam pertolongan mandiri dan usaha untuk mengenali diri sendiri. Dengan terlibat dengan - dan bukannya menghindari - situasi yang ditakuti, Anda mungkin akan belajar dari waktu ke waktu bahwa hal-hal buruk yang Anda perkirakan akan terjadi tidak akan terjadi. Dan bahwa Anda memiliki kemampuan dan keterampilan untuk menanganinya ketika hal itu terjadi."
                )
            )
        ),
        "Stress" to SelfHelpMaterial(
            imageResId = R.drawable.sample_image,
            mainTitle = "Memahami dan Mengelola Stres",
            mainDescription = "Stres adalah respons alami tubuh terhadap tantangan atau tuntutan. Meskipun sering dianggap negatif, stres sebenarnya memiliki fungsi adaptif yang penting dalam mekanisme bertahan hidup kita. Melalui sesi-sesi ini, Anda akan memahami apa itu stres, bagaimana stres berfungsi dalam kehidupan sehari-hari, serta bagaimana platform CeritaKita dapat membantu Anda mengelola stres secara efektif.",
            sessions = listOf(
                SelfHelpSession(
                    title = "Apa itu Stres?",
                    description = "Stres adalah respons alami tubuh terhadap tantangan atau tuntutan, baik yang berasal dari situasi eksternal maupun dari dalam diri sendiri. Stres bisa terjadi ketika Anda merasa kewalahan atau tidak mampu mengatasi tekanan yang dihadapi. Pengalaman stres terdiri dari cara Anda berpikir, merasa, dan bertindak. Anda mungkin:\n" +
                            "\n" +
                            "Merasa tegang, cemas, atau mudah tersinggung\n" +
                            "Mengalami perubahan suasana hati atau merasa mudah marah\n" +
                            "Mengalami sakit kepala, ketegangan otot, atau gangguan tidur\n" +
                            "Mengalami perubahan dalam nafsu makan atau kebiasaan makan\n" +
                            "Merasa lelah atau tidak bertenaga\n" +
                            "Mengalami kesulitan berkonsentrasi atau membuat keputusan\n"
                ),
                SelfHelpSession(
                    title = "Apa fungsi dari stres?",
                    description = "Meskipun sering dianggap sebagai sesuatu yang negatif, stres sebenarnya memiliki fungsi adaptif yang penting. Stres adalah bagian dari mekanisme bertahan hidup kita, yang dikenal sebagai respons \"fight or flight\". Respons ini mempersiapkan tubuh kita untuk menghadapi atau melarikan diri dari situasi berbahaya. Dalam dosis yang kecil dan jangka pendek, stres bisa meningkatkan kewaspadaan, energi, dan fokus, membantu Anda menyelesaikan tugas atau mengatasi tantangan. Namun, stres yang berkepanjangan dan tidak terkendali dapat berdampak negatif pada kesehatan fisik dan mental Anda."
                ),
                SelfHelpSession(
                    title = "Bagaimana CeritaKita dapat membantu stres?",
                    description = "Untungnya, ada banyak cara untuk mengelola stres secara efektif. CeritaKita dapat membantu Anda dengan memberikan pandangan atas cerita dan foto Anda menggunakan AI untuk mengidentifikasi kemungkinan apa yang Anda rasakan dan alami saat ini. Meskipun ini bukan diagnosis medis, ini dapat membantu dalam upaya pengenalan diri dan pertolongan mandiri. Dengan mengeksplorasi dan memahami perasaan Anda, Anda mungkin dapat menemukan cara-cara baru untuk mengatasi stres. CeritaKita mendorong Anda untuk tidak menghindari perasaan Anda tetapi menghadapi dan mengatasinya, yang bisa menjadi langkah penting menuju kesejahteraan. Dengan dukungan dan alat yang tepat, Anda dapat belajar untuk mengelola stres dan menemukan keseimbangan dalam hidup Anda."
                )
            )
        ),
        "Depresi" to SelfHelpMaterial(
            imageResId = R.drawable.sample_image,
            mainTitle = "Memahami dan Mengatasi Depresi",
            mainDescription = "Depresi adalah kondisi medis serius yang memengaruhi perasaan, pemikiran, dan aktivitas sehari-hari seseorang. Berbeda dengan rasa sedih sementara, depresi lebih intens dan berlangsung lebih lama. Melalui sesi-sesi ini, Anda akan memahami apa itu depresi, bagaimana fungsinya dalam konteks evolusi, serta bagaimana platform CeritaKita dapat membantu Anda mengenali dan mengatasi gejala depresi.",
            sessions = listOf(
                SelfHelpSession(
                    title = "Apa itu depresi?",
                    description = "Depresi adalah kondisi medis yang umum namun serius, yang memengaruhi cara Anda merasa, berpikir, dan menangani aktivitas sehari-hari. Berbeda dengan rasa sedih yang mungkin dialami setiap orang sesekali, depresi lebih intens dan berlangsung lebih lama. Beberapa gejala umum depresi meliputi:\n" +
                            "\n" +
                            "Perasaan sedih atau kosong yang berkepanjangan\n" +
                            "Kehilangan minat atau kesenangan dalam aktivitas yang biasanya dinikmati\n" +
                            "Kesulitan tidur atau tidur terlalu banyak\n" +
                            "Perubahan nafsu makan atau berat badan\n" +
                            "Merasa lelah atau tidak bertenaga hampir setiap hari\n" +
                            "Perasaan tidak berharga atau bersalah yang berlebihan\n" +
                            "Kesulitan berkonsentrasi atau membuat keputusan\n" +
                            "Pikiran tentang kematian atau bunuh diri\n"
                ),
                SelfHelpSession(
                    title = "Apa fungsi dari depresi?",
                    description = "Meski terlihat bertentangan, beberapa teori menyarankan bahwa depresi memiliki fungsi adaptif dalam konteks evolusi. Sebagai contoh, depresi bisa berfungsi sebagai mekanisme perlindungan yang memaksa seseorang untuk menarik diri dari situasi stres yang terus-menerus dan mencari cara untuk mengatasinya. Selain itu, perasaan tidak berdaya dan putus asa yang terkait dengan depresi dapat mendorong individu untuk merefleksikan kehidupan mereka dan membuat perubahan yang diperlukan. Namun, penting untuk dicatat bahwa depresi yang berkepanjangan dan tidak diobati dapat memiliki dampak negatif yang signifikan terhadap kualitas hidup seseorang."
                ),
                SelfHelpSession(
                    title = "Bagaimana CeritaKita dapat membantu depresi?",
                    description = "Untungnya, ada banyak perawatan yang efektif untuk depresi. CeritaKita dapat membantu Anda dengan memberikan pandangan atas cerita dan foto Anda menggunakan AI untuk mengidentifikasi kemungkinan apa yang Anda rasakan dan alami saat ini. Meskipun ini bukan diagnosis medis, ini dapat membantu dalam upaya pengenalan diri dan pertolongan mandiri. Dengan mengeksplorasi dan memahami perasaan Anda, Anda mungkin dapat menemukan cara-cara baru untuk mengatasi depresi. CeritaKita mendorong Anda untuk tidak menghindari perasaan Anda tetapi menghadapi dan mengatasinya, yang bisa menjadi langkah penting menuju pemulihan. Dengan dukungan dan alat yang tepat, Anda dapat belajar untuk menghadapi depresi dan menemukan kembali kebahagiaan serta kesejahteraan dalam hidup Anda."
                )
            )
        ),
        "Emosi" to SelfHelpMaterial(
            imageResId = R.drawable.sample_image,
            mainTitle = "Memahami dan Mengelola Emosi",
            mainDescription = "Emosi merupakan bagian integral dari kehidupan manusia yang memainkan peran penting dalam keberhasilan dan kesejahteraan. Melalui sesi-sesi ini, Anda akan belajar tentang apa itu emosi, bagaimana cara mengelola berbagai jenis emosi seperti marah, cemas, dan sedih, serta bagaimana mengidentifikasi dan merespon emosi Anda secara lebih efektif untuk mencapai keseimbangan dan ketenangan dalam hidup.",
            sessions = listOf(
                SelfHelpSession(
                    title = "Apa itu Emosi?",
                    description = "Emosi merupakan bagian integral dari kehidupan manusia dan memainkan peran penting dalam kehidupan. Seseorang dianggap berhasil jika mampu mengelola emosinya dengan baik, dan bisa saja gagal jika tidak mampu mengelola emosi. Oleh karena itu, kecerdasan bukan satu-satunya faktor penentu keberhasilan. Sebagai manusia, sangat wajar mengalami perubahan emosi sehari-hari, karena emosi dasar manusia meliputi marah, sedih, takut, bahagia, jijik, dan kaget. Akibatnya, tidak jarang terjadi perubahan suasana hati, seperti merasa kesal, bete, atau marah di pagi hari, namun suasana hati membaik di siang hari."
                ),
                SelfHelpSession(
                    title = "Cara Mengelola Emosi",
                    description = "1.\tTanyakan Pada Diri Sendiri, Apa yang dirasakan\n" +
                            "2.\tTanyakan, Apa yang membuat dirimu merasakan emosi ini?\n" +
                            "3.\tCoba Pikirkan dan Rasakan dari sudut pandang lain yang berbeda dari nomor 2. kenapa merasakan emosi tersebut?\n" +
                            "4.\tApa yang sebenarnya ingin kamu lakukan dengan perasaan emosi tersebut? Apa yang kamu sesali?\n" +
                            "5.\tApakah ada cara yang lebih baik dalam meresponnya?\n"
                ),
                SelfHelpSession(
                    title = "Bagaimana cara cepat mengelola emosi marah?",
                    description = "Emosi marah dapat diatasi melalui teknik psikologis dan latihan yang bertujuan untuk mengurangi intensitasnya. Jika tidak mampu mengelola amarah, kita bisa merugikan diri sendiri. Selain mempengaruhi kesehatan fisik, marah yang tidak terkontrol juga dapat merusak hubungan dan bahkan menimbulkan masalah hukum."
                ),
                SelfHelpSession(
                    title = "Kita perlu mengenali tanda kapan kita marah dengan beberapa pertanyaan꞉",
                    description = "-\tBagaimana saya tahu bahwa saya sedang marah?\n" +
                            "-\tKejadian apa, orang yang seperti apa, tempat yang bagaimana atau hal‐hal apa yang memicu saya menjadi marah?\n" +
                            "-\tTindakan apa yang saya akan lakukan bilamana saya marah?\n" +
                            "-\tBagaimana emosi marah saya mempengaruhi orang lain?\n"
                ),
                SelfHelpSession(
                    title = "Bagaimana cara cepat mengelola emosi cemas?",
                    description = "Kecemasan adalah perasaan normal dan wajar ketika menghadapi situasi yang tidak aman, penuh ancaman, dan tuntutan. Namun, jika kecemasan berlangsung terus-menerus, dengan intensitas yang semakin meningkat dan membuat kita tidak mampu menjalani aktivitas sehari-hari, maka kondisi tersebut dapat dianggap sebagai gangguan kesehatan mental."
                ),
                SelfHelpSession(
                    title = "Berikut hal yang bisa dilakukan jika dirimu merasa cemas:",
                    description = "-\tLakukan grounding saat mengalami kecemasan, yakni fokus pada benda di sekitarmu. Lihat benda tersebut, rasakan teksturnya, rasanya atau baunya. Lakukan 5‐10 menit untuk hanya fokus pada benda tersebut. \n" +
                            "-\tlakukan relaksasi nafas. Hitung 1‐4 untuk menarik nafas, hitung 1‐4 untuk menahan nafas, dan hitung 1‐4 untuk menghembuskan perlahan. Lakukan berulang‐ulang hingga merasa lebih tenang.\n"
                ),
                SelfHelpSession(
                    title = "Bagaimana cara cepat mengelola emosi sedih?",
                    description = "Adalah hal yang wajar merasa sedih ketika mengalami kekecewaan, kegagalan, atau kehilangan sesuatu yang penting. Namun, jika seseorang terus-menerus merasa sedih dalam jangka waktu yang lama tanpa mengetahui penyebabnya, maka kondisi tersebut memerlukan intervensi psikologis."
                ),
                SelfHelpSession(
                    title = "Berikut hal yang bisa dilakukan jika dirimu merasa sedih:",
                    description = "-\tPahamilah bahwa kamu boleh bersedih dan rasa sedih itu valid. Jika kamu bisa menangis, luapkan dengan menangis.\n" +
                            "-\tKamu bisa meluapkan keluh kesahmu kepada orang yang kamu percaya. Buatlah jurnal ‘kebaikan’ yakni dengan mengumpulkan hal‐hal baik di dalam hidupmu yang patut untuk disyukuri.\n"
                )
            )
        ),
    )

    data class SelfHelpMaterial(
        val mainTitle: String,
        val mainDescription: String,
        val sessions: List<SelfHelpSession>,
        val imageResId: Int
    )

    data class SelfHelpSession(
        val title: String,
        val description: String
    )
}
