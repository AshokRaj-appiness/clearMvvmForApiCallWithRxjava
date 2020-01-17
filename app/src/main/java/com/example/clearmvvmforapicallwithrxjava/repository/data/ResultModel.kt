package com.example.clearmvvmforapicallwithrxjava.repository.data

data class ResultModel(val todo:Todo?,val message:String,val error:Throwable? = null)