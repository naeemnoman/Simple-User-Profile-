package com.naeemnoman.simpleuserprofile

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users/1")
    fun getUserProfile(): Call<User>
}