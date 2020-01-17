package com.example.clearmvvmforapicallwithrxjava

import android.app.Application
import com.example.clearmvvmforapicallwithrxjava.repository.UserRepository
import com.example.clearmvvmforapicallwithrxjava.repository.api.UserApi
import com.example.clearmvvmforapicallwithrxjava.utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class App: Application() {
    companion object{
        private lateinit var retrofit:Retrofit
        private lateinit var userApi:UserApi
        private lateinit var userRepository: UserRepository

        fun injectUserApi() = userApi
    }

    override fun onCreate() {
        super.onCreate()
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        userApi = retrofit.create(UserApi::class.java)


    }
}