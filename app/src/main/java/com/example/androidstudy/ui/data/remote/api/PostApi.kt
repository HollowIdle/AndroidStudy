package com.example.androidstudy.ui.data.remote.api

import com.example.androidstudy.ui.data.remote.dto.ResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface PostApi {
    companion object{
        const val GET_POSTS_REQUEST = "top-headlines"

        const val SOURCE_CONST = "techcrunch"
        const val SOURCE_PARAM = "sources"

        const val KEY_PARAM = "apiKey"
        const val API_KEY = "624201ccba47409bbd428b24faaf6073"
    }

    @GET(GET_POSTS_REQUEST)
    suspend fun getLastNews(
        @Query(SOURCE_PARAM) source: String = SOURCE_CONST,
        @Query(KEY_PARAM) apiKey: String = API_KEY
    ) : ResponseDto

}