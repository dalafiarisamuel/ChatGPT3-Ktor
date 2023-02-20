package com.devtamuno.openai.data.completion

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TextCompletionResponse(

    @SerialName("id")
    val id: String,

    @SerialName("object")
    val `object`: String,

    @SerialName("created")
    val created: Long,

    @SerialName("model")
    val model: String,

    @SerialName("choices")
    val choices: List<TextCompletionChoice>,

    @SerialName("usage")
    val usage: TextCompletionUsage
)

@Serializable
data class TextCompletionChoice(
    @SerialName("text")
    val text: String,

    @SerialName("index")
    val index: Int,

    @SerialName("finish_reason")
    val finishReason: String
)

@Serializable
data class TextCompletionUsage(

    @SerialName("prompt_tokens")
    val promptTokens: Int,

    @SerialName("completion_tokens")
    val completionTokens: Int,

    @SerialName("total_tokens")
    val totalTokens: Int
)