package com.bivizul.sportseventnotes.data

import com.bivizul.sportseventnotes.domain.model.LP
import com.bivizul.sportseventnotes.domain.model.ResServ
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiCards {

    @POST("20SportsEventNotes/resserv.php")
    suspend fun getResServ(@Body lp: LP): Response<ResServ>

}