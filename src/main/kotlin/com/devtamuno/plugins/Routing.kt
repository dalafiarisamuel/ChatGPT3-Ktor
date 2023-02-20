package com.devtamuno.plugins

import com.devtamuno.openai.openAiQuery
import io.ktor.server.plugins.autohead.*
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    install(AutoHeadResponse)
    routing {
        openAiQuery()
    }
}
