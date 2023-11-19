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
                "Pertanyaan 1 (jawaban A)",
                listOf("pilih ini 1", "ini 1", "ini 1", "atau ini 1"),
                "A",
                images = "dishub_logo"
            ),
            DataEntity(
                2,
                "Pertanyaan 2 (jawaban D)",
                listOf("pilih ini 2", "ini 2", "ini 2", "atau ini 2"),
                "D"
            ),
            DataEntity(
                3,
                "Pertanyaan 3 (jawaban B)",
                listOf("pilih ini 3", "ini 3", "ini 3", "atau ini 3"),
                "B"
            ),
            DataEntity(
                4,
                "Pertanyaan 4 (jawaban C)",
                listOf("pilih ini 4", "ini 4", "ini 4" , "atau ini4"),
                "C"
            ),
            DataEntity(
                5,
                "Pertanyaan 5 (jawaban A)",
                listOf("pilih ini 5", "ini 5", "ini 5", "atau ini 5"),
                "A"
            ),
            DataEntity(
                6,
                "Pertanyaan 6 (jawaban D)",
                listOf("pilih ini 6", "ini 6", "ini 6", "atau ini 6"),
                "D"
            )
        )

    }

    fun postestQuestions(): List<Postest> {
        return listOf(
            Postest(
                1,
                "Pertanyaan 1 (jawaban A)",
                listOf("pilih ini", "ini", "ini", "atau ini"),
                "A"
            ),
            Postest(
                2,
                "Pertanyaan 2 (jawaban D)",
                listOf("pilih ini", "ini", "ini", "atau ini"),
                "D"
            ),
            Postest(
                3,
                "Pertanyaan 3 (jawaban B)",
                listOf("pilih ini", "ini", "ini", "atau ini"),
                "B"
            ),
            Postest(
                4,
                "Pertanyaan 4 (jawaban C)",
                listOf("pilih ini", "ini", "ini", "atau ini"),
                "C"
            ),
            Postest(
                5,
                "Pertanyaan 5 (jawaban A)",
                listOf("pilih ini", "ini", "ini", "atau ini"),
                "A"
            ),
            Postest(
                6,
                "Pertanyaan 6 (jawaban D)",
                listOf("pilih ini", "ini", "ini", "atau ini"),
                "D"
            ),
            Postest(
                7,
                "Pertanyaan 7 (jawaban B)",
                listOf("pilih ini", "ini", "ini", "atau ini"),
                "B"
            ),
            Postest(
                8,
                "Pertanyaan 8 (jawaban C)",
                listOf("pilih ini", "ini", "ini", "atau ini"),
                "C"
            ),
        )
    }
}