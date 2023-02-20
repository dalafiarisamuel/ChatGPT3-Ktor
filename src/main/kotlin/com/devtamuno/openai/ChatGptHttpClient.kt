package com.devtamuno.openai

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.post
import io.ktor.client.utils.buildHeaders
import io.ktor.http.auth.parseAuthorizationHeader
import io.ktor.http.headersOf
import io.ktor.http.set
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.engine.applicationEngineEnvironment
import io.ktor.server.engine.defaultEnginePipeline

import kotlinx.serialization.json.Json
import kotlin.coroutines.coroutineContext

object ChatGptHttpClient {

    private val client = HttpClient(CIO) {

        defaultRequest {
            url("https://api.openai.com")
            bearerAuth("")
        }
        install(ContentNegotiation) {
            json(Json {
                encodeDefaults = true
                isLenient = true
                ignoreUnknownKeys = true
                allowSpecialFloatingPointValues = true
                allowStructuredMapKeys = true
                prettyPrint = true
            })
        }
    }

    const val COMPLETIONS: String = "v1/completions"
    const val MODERATIONS: String = "v1/moderations"
    const val EMBEDDINGS: String = "v1/embeddings"
    const val IMAGE_GENERATIONS: String = "v1/images/generations"


    suspend fun post(
        urlString: String,
        block: HttpRequestBuilder.() -> Unit = {}
    ) = client.post(urlString, block)


}