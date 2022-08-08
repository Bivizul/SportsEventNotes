package com.bivizul.sportseventnotes.domain.model

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bivizul.sportseventnotes.domain.Constants.CARDS_TABLE
import com.bivizul.sportseventnotes.domain.Constants.UNDEFINED_ID

@Keep
@Entity(tableName = CARDS_TABLE)
data class CardItem(
    @PrimaryKey(autoGenerate = true)
//    var id: Int = UNDEFINED_ID,
    var id: Int,
    val nameEvent: String = "",
    val date: String = "",
    val team1: String = "",
    val team2: String = "",
    val spread: Int?,
    val total: Int?,
    val money: Int?,
//    val count: Int,
    val enable: Boolean,
)
