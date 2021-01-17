package com.github.api.remote

import com.github.api.model.DetailUser
import com.github.api.model.User
import com.github.api.model.UserList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserList>

    @GET("users/{username}")
    fun getUserDetail(
        @Path("username") username : String
    ): Call<DetailUser>

    @GET("users/{username}/followers")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>
}