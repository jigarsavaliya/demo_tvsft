package com.demo.tvsft.data

import OutputModel
import android.icu.util.Output

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository(val dataSource: LoginDataSource) {



    fun login(): Result<OutputModel> {
        // handle login
        val result = dataSource.login(10)


        return result
    }

}