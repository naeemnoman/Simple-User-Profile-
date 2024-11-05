package com.naeemnoman.simpleuserprofile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response






class UserViewModel : ViewModel() {
    val user = MutableLiveData<User>()
    val errorMessage = MutableLiveData<String>()

    fun fetchUserProfile() {
        RetrofitInstance.api.getUserProfile().enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    user.value = response.body()
                } else {
                    errorMessage.value = "Failed to load data"
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                errorMessage.value = "Error: ${t.message}"
            }
        })
    }
}
