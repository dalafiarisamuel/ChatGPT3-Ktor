package com.devtamuno.openai.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BasicRequestBody(

    @SerialName("model")
    val model: String,

    @SerialName("prompt")
    val prompt: String,

    @SerialName("temperature")
    val temperature: Int = 0,

    @SerialName("max_tokens")
    val maxTokens: Int = 64,

    @SerialName("top_p")
    val topP: Double = 1.0,

    @SerialName("frequency_penalty")
    val frequencyPenalty: Double = 0.0,
)
