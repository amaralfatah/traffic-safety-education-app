package com.eduproject.trafficsafetyeducation.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "pretest")
data class DataEntity (

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "question")
    var question: String,

    @ColumnInfo(name = "answer")
    var answer: List<String>,

    @ColumnInfo(name = "correctAnswer")
    var correctAnswer: String,

    @ColumnInfo(name = "isAnswered")
    var isAnswered: Boolean = false,

    @ColumnInfo(name = "isCorrect")
    var isCorrect: Boolean = false

): Parcelable

@Parcelize
@Entity(tableName = "postest")
data class Postest (

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "question")
    var question: String,

    @ColumnInfo(name = "answer")
    var answer: List<String>,

    @ColumnInfo(name = "correctAnswer")
    var correctAnswer: String,

    @ColumnInfo(name = "isAnswered")
    var isAnswered: Boolean = false,

    @ColumnInfo(name = "isCorrect")
    var isCorrect: Boolean = false

): Parcelable