package com.naeemnoman.simpleuserprofile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserProfileViewModel : ViewModel() {
    private val _userProfile = MutableLiveData<User>()
    val userProfile: LiveData<User> get() = _userProfile

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    private val apiService = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    fun fetchUserProfile() {
        apiService.getUserProfile().enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    _userProfile.value = response.body()
                } else {
                    _error.value = "Failed to load data"
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                _error.value = "Failed to load data"
            }
        })
    }
}