package com.rzl.flightgotiketbooking.model.auth


import com.google.gson.annotations.SerializedName

data class userLoginResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean
)