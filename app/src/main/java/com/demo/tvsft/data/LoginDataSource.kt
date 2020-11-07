package com.demo.tvsft.data

import OutputModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(offset: Int): Result<OutputModel> {
        try {

            GlobalScope.launch {

                
            }
            return Result.Success()
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}