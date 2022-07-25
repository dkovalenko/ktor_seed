package com.github.dkovalenko.ktor_seed.plugins

import com.github.dkovalenko.ktor_seed.domain.config.configModule
import io.ktor.server.application.*
import com.github.dkovalenko.ktor_seed.domain.video.videoModule
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureDI() {

    install(Koin) {
        slf4jLogger()
        modules(configModule, videoModule)
    }


}


