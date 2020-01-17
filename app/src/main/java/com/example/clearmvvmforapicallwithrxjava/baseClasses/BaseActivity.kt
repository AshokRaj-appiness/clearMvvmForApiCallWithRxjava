package com.example.clearmvvmforapicallwithrxjava.baseClasses

import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseActivity:AppCompatActivity() {
    val subscriptions = CompositeDisposable()

    fun subscribe(disposable: CompositeDisposable):Disposable{
        subscriptions.add(disposable)
        return disposable
    }

    override fun onStop() {
        super.onStop()
        subscriptions.clear()
    }
}