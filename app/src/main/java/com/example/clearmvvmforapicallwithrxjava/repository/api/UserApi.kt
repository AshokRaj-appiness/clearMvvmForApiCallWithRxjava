package com.example.clearmvvmforapicallwithrxjava.repository.api

import com.example.clearmvvmforapicallwithrxjava.repository.data.Todo
import io.reactivex.Observable
import retrofit2.http.GET

interface UserApi {
    @GET("/todos/1")
    fun getUsers():Observable<Todo>
}