package com.demo.tvsft.ui.login

import OutputModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import androidx.lifecycle.viewModelScope
import com.demo.tvsft.data.LoginRepository
import com.demo.tvsft.data.Result

import com.demo.tvsft.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<OutputModel>()
    val loginFormState: LiveData<OutputModel> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login() {
        // can be launched in a separate asynchronous job
        viewModelScope.launch {
            val result = loginRepository.login()

            if (result is Result.Success) {
                _loginResult.value =
                    LoginResult(success = result.data)
            } else {
                _loginResult.value = LoginResult(error = R.string.login_failed)
            }
        }
    }


}