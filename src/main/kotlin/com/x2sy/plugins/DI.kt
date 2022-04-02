package com.x2sy.plugins

import com.x2sy.domain.config.configModule
import io.ktor.server.application.*
import com.x2sy.domain.video.videoModule
import org.koin.logger.slf4jLogger

fun Application.configureDI() {

    install(CustomKoinPlugin) {
        slf4jLogger()
        modules(configModule, videoModule)
    }


}


