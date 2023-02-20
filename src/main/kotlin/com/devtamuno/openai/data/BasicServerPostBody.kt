package com.devtamuno.openai.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BasicServerPostBody(
    @SerialName("prompt")
    val prompt: String? = null,

    @SerialName("max_token")
    val maxToken: Int? = null
)
