package com.example.clearmvvmforapicallwithrxjava.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.clearmvvmforapicallwithrxjava.App
import com.example.clearmvvmforapicallwithrxjava.R
import com.example.clearmvvmforapicallwithrxjava.baseClasses.BaseFragment
import com.example.clearmvvmforapicallwithrxjava.repository.UserRepository
import com.example.clearmvvmforapicallwithrxjava.utils.Logger
import com.example.clearmvvmforapicallwithrxjava.viewModel.TodoViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.todo_fragment.*

class TodoFragment:BaseFragment() {
    lateinit var userListViewModel:TodoViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        userListViewModel = ViewModelProviders.of(this).get(TodoViewModel::class.java)

        return inflater.inflate(R.layout.todo_fragment,container,false)
    }

    override fun onStart() {
        super.onStart()
        subscribe(
            userListViewModel.getUsers(UserRepository(App.injectUserApi()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if(it.error == null){
                        textView.text = it.toString()
                    }
                },{
                    it.message?.let { Logger.debug(it) }
                })
        )
    }
}