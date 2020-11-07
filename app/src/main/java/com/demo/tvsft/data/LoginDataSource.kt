package com.demo.tvsft.data

import OutputModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.demo.tvsft.Api.Retrofit
import com.demo.tvsft.ui.login.LoginResult
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    suspend  fun login(offset: Int): Result<OutputModel> {
        try {

                val output = Retrofit().apiService.GetUserList(offset);

            return Result.Success(output.body()!!);
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}