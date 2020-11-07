package com.demo.tvsft.ui.login

import OutputModel

/**
 * Authentication result : success (user details) or error message.
 */
data class LoginResult(
    val success: OutputModel? = null,
    val error: Int? = null
)