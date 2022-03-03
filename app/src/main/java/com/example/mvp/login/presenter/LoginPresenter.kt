package com.example.mvp.login.presenter

import android.util.Log
import com.example.mvp.framework.util.thread.ThreadUtil
import com.example.mvp.login.model.UserinfoModel
import com.example.mvp.login.presenter.controller.LoginController
import com.example.mvp.login.view.ILoginView


class LoginPresenter(var iLoginView:ILoginView):ILoginPresenter {
    override fun clear() {
        iLoginView.onClear()
    }

    override fun showProgress() {
        iLoginView.onShowProgress()
    }

    override fun hideProgress() {
        iLoginView.onHideProgress()
    }

    override fun login(id: String, password: String) {

        clear()


       showProgress()
        LoginController.requestLogin(id=id, password = password, object:LoginController.logincintrollerDeligate
        {
            override fun onSecces(response: String) {
                Log.d("???", "onSecces $response")  //parsing data is hear
             //_____parsing data is hear______
                val userinfoModel=UserinfoModel()
                userinfoModel.nickname="Coding with cat"
                userinfoModel.age=1

                ThreadUtil.startUIThread(0)
                { hideProgress()
                    iLoginView.OnUpdateUserInfo(nickname = userinfoModel.nickname, age =userinfoModel.age )
                }


            }

            override fun onFaile() {
              Log.d("???", "onFailed")
                hideProgress()

            }


        })
    }


}