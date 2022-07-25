package com.github.dkovalenko.ktor_seed.domain.response.model

import kotlinx.serialization.Serializable

@Serializable
abstract class ApiResponse {
    abstract val result: String
    abstract val code: Int
}

@Serializable
data class ApiResultSuccess<T>(val data: T): ApiResponse() {
    override val result = "ok"
    override val code   = 200
}

@Serializable
data class ApiResultError(override val code: Int, val message: String): ApiResponse() {
    override val result = "error"
}