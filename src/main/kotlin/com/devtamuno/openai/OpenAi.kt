package com.devtamuno.openai

import com.devtamuno.openai.data.BasicRequestBody
import com.devtamuno.openai.data.BasicServerPostBody
import com.devtamuno.openai.data.completion.TextCompletionResponse
import io.ktor.client.call.body
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.server.application.call
import io.ktor.server.request.receiveNullable
import io.ktor.server.response.respond
import io.ktor.server.routing.Routing
import io.ktor.server.routing.post
import kotlinx.coroutines.withTimeoutOrNull


fun Routing.openAiQuery() {

    post("/open-ai-query") {

        val parsedBody: BasicServerPostBody? = call.receiveNullable()
        if (parsedBody?.prompt.isNullOrEmpty()) {
            return@post call.respond(
                status = HttpStatusCode.BadRequest,
                message = mapOf("error" to "prompt property is a required field and cannot be empty")
            )
        }

        if (parsedBody?.maxToken == null) {
            return@post call.respond(
                status = HttpStatusCode.BadRequest,
                message = mapOf("error" to "maxToken property is a required field")
            )
        }

        val result = withTimeoutOrNull(timeMillis = 10_000) {
            with(ChatGptHttpClient) {
                post(COMPLETIONS) {
                    contentType(ContentType.Application.Json)
                    setBody(
                        body = BasicRequestBody(
                            model = OpenAiModels.Text.DAVINCI_003,
                            prompt = parsedBody.prompt!!,
                            maxTokens = parsedBody.maxToken
                        )
                    )
                }
            }

        } ?: return@post call.respond(status = HttpStatusCode.RequestTimeout, message = "request time out")

        val apiResponse = result.body<TextCompletionResponse>()
        call.respond(
            status = result.status,
            message = mapOf("response" to apiResponse.choices.map { it.text })
        )

    }
}