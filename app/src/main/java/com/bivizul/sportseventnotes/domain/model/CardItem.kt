package com.bivizul.sportseventnotes.domain.model

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bivizul.sportseventnotes.domain.Constants.CARDS_TABLE
import com.bivizul.sportseventnotes.domain.Constants.TEXT_DATE_BUTTON
import com.bivizul.sportseventnotes.domain.Constants.TEXT_TIME_BUTTON
import com.bivizul.sportseventnotes.domain.Constants.UNDEFINED_ID
import com.bivizul.sportseventnotes.domain.Constants.UNDEFINED_STRING

@Keep
@Entity(tableName = CARDS_TABLE)
data class CardItem(
    @PrimaryKey(autoGenerate = true)
    var id: Int = UNDEFINED_ID,
    val event: String = UNDEFINED_STRING,
    val date: String = TEXT_DATE_BUTTON,
    val time: String = TEXT_TIME_BUTTON,
    val team1: String = UNDEFINED_STRING,
    val team2: String = UNDEFINED_STRING,
    val coefficient: String = UNDEFINED_STRING,
    val incomeRisk: String = UNDEFINED_STRING,
)
