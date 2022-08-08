package com.bivizul.sportseventnotes.domain.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ResServ(
    @SerializedName("url")
    val resServ: String,
)
