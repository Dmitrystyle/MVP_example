package com.example.mvp.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mvp.R
import com.example.mvp.databinding.ActivityLoginBinding
import com.example.mvp.databinding.ActivityMainBinding
import com.example.mvp.login.presenter.ILoginPresenter
import com.example.mvp.login.presenter.LoginPresenter

class LoginActivity : AppCompatActivity(), ILoginView {

    lateinit var binding: ActivityLoginBinding
    lateinit var iLoginPresenter: ILoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initPresenter()
        setListener()

    }

    private fun initPresenter(){
        iLoginPresenter=LoginPresenter(iLoginView =this )
    }



    private fun setListener() {

        binding.buttonLogin.setOnClickListener {

            iLoginPresenter.login(id=binding.editTextID.text.toString().trim(), password = binding.editTextPW.text.toString().trim())
        }

    }

    override fun onClear() {
      binding.editTextID.setText("")
        binding.editTextPW.setText("")
    }

    override fun onShowProgress() {
        binding.fromeLayoutProgress.visibility= View.VISIBLE
    }

    override fun onHideProgress() {
        binding.fromeLayoutProgress.visibility= View.GONE
    }

    override fun OnUpdateUserInfo(nickname: String, age: Int) {
        binding.textViewLoginResultInfo.text="nickname is $nickname, age is $age"
    }

    //textViewLoginResultInfo  buttonLogin    editTextPW    editTextID

}