package com.example.clearmvvmforapicallwithrxjava.repository

import android.util.Log
import com.example.clearmvvmforapicallwithrxjava.repository.api.UserApi
import com.example.clearmvvmforapicallwithrxjava.repository.data.Todo
import com.example.clearmvvmforapicallwithrxjava.utils.Logger
import io.reactivex.Observable

class UserRepository(val userApi: UserApi) {

    fun getUsers(): Observable<Todo> {
        return userApi.getUsers().doOnNext {
            Logger.debug(it.toString())
        }
    }
}