package com.rzl.flightgotiketbooking.network

import com.rzl.flightgotiketbooking.model.login.UserDataClass
import com.rzl.flightgotiketbooking.model.login.UserResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiUserService {


    @POST("login")
    fun userLogin(@Body login: UserDataClass): Call<UserResponse>

    @GET("logout")
    fun userLogout(@Header("Authorization") token: String): Call<String>

 }