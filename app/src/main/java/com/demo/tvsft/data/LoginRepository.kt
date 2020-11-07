package com.demo.tvsft.data

import OutputModel

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository(val dataSource: LoginDataSource) {

    suspend  fun login(ofset: Int): Result<OutputModel> {
        // handle login
        val result = dataSource.login(ofset)
        return result
    }

}