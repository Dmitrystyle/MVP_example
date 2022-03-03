package com.example.mvp.login.view

import android.provider.ContactsContract

interface ILoginView {

    fun onClear()
    fun onShowProgress()
    fun onHideProgress()
    fun OnUpdateUserInfo(nickname: String, age:Int)



}