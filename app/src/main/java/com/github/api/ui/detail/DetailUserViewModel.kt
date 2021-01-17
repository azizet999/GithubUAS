package com.github.api.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.api.remote.RetrofitUser
import com.github.api.model.DetailUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailUserViewModel : ViewModel(){
    val user = MutableLiveData<DetailUser>()

    fun setUserDetail(username: String){
        RetrofitUser.apiInstance
            .getUserDetail(username)
            .enqueue(object : Callback<DetailUser> {
                override fun onFailure(call: Call<DetailUser>, t: Throwable) {
                    t.message?.let { Log.d("Failure", it) }
                }

                override fun onResponse(
                    call: Call<DetailUser>,
                    response: Response<DetailUser>
                ) {
                    if(response.isSuccessful){
                        user.postValue(response.body())
                    }
                }

            })
    }

    fun getUserDetail() : LiveData<DetailUser> {
        return user
    }
}