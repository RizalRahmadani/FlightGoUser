package com.rzl.flightgotiketbooking.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.rzl.flightgotiketbooking.database.DataStoreUser
import com.rzl.flightgotiketbooking.model.login.UserDataClass
import com.rzl.flightgotiketbooking.model.login.UserResponse
import com.rzl.flightgotiketbooking.network.ApiUserService
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(var api : ApiUserService, @ApplicationContext appContext: Context): ViewModel() {

    // LivaData
    var livedataToken: MutableLiveData<String> = MutableLiveData()
    var livedataIsLogin: MutableLiveData<Boolean> = MutableLiveData()
    private val adminStore: DataStoreUser = DataStoreUser(appContext)
    var login: MutableLiveData<UserResponse?> = MutableLiveData()


//    init {
//        viewModelScope.launch(Dispatchers.IO) {
//            getLiveAllTic()
//        }
//    }

    fun saveData(role: String, token_: String) {
        GlobalScope.launch {
            adminStore.saveData(role, token_)
        }
    }

    fun getToken() = adminStore.getToken().asLiveData()
    fun getRole() = adminStore.getRole().asLiveData()

    fun saveLoginStatus(status: Boolean) {
        GlobalScope.launch {
            adminStore.setLogin(status)
        }
    }

    fun removeLoginStatus() {
        GlobalScope.launch {
            adminStore.removeLogin()
        }
    }


    fun LoginLive(): LiveData<UserResponse?> {
        return login
    }



    //Retrofit
    fun apiLogin(email: String, pass: String) {
        api.userLogin(UserDataClass(email, pass))
            .enqueue(object : Callback<UserResponse> {
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    if (response.isSuccessful) {
                        val body = response.body()
                        if (body != null) {
                            login.postValue(body)
                            Log.d("SUCCESS", "$body")
                        } else {
                            login.postValue(null)
                            error("NULL" + response.message())
                        }
                    } else {
                        login.postValue(null)
                        error(response.message())
                    }
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    login.postValue(null)
                    Log.e("FAILED", "SOMETHING WRONG", t)
                }

            })
    }

}