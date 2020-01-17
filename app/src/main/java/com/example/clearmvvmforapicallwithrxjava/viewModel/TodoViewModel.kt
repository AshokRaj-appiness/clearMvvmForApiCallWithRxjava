package com.example.clearmvvmforapicallwithrxjava.viewModel

import com.example.clearmvvmforapicallwithrxjava.baseClasses.BaseViewModel
import com.example.clearmvvmforapicallwithrxjava.repository.UserRepository
import com.example.clearmvvmforapicallwithrxjava.repository.data.ResultModel
import com.example.clearmvvmforapicallwithrxjava.repository.data.Todo
import io.reactivex.Observable

class TodoViewModel():BaseViewModel() {
    fun getUsers(userRepository: UserRepository):Observable<ResultModel>{
        return userRepository.getUsers().map {
            ResultModel(it,"Successfully returned")
        }.onErrorReturn {
            ResultModel(null,"Error occured",it)
        }
    }
}