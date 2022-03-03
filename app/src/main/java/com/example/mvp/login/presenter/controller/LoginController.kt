package com.example.mvp.login.presenter.controller

import com.example.mvp.framework.util.thread.ThreadUtil


object LoginController {

    interface logincintrollerDeligate{
        fun onSecces(response:String)
        fun onFaile()
    }
    fun requestLogin(id:String, password:String, deligate: logincintrollerDeligate)
    {
        ThreadUtil.startThread {

            Thread.sleep(3000)

            deligate.onSecces("response from server, user info is a jsonObjectString")
        }
    }
}