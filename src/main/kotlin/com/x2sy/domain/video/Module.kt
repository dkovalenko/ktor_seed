package com.x2sy.domain.video

import com.x2sy.domain.config.ConfigProvider
import com.x2sy.domain.config.ConfigProviderImpl
import com.x2sy.domain.response.model.ApiResultSuccess
import com.x2sy.plugins.inject
import io.ktor.server.application.*
import io.ktor.server.locations.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val videoModule = module {
    singleOf(::VideoServiceImpl) bind VideoService::class
    singleOf(::VideoRepositoryImpl) bind VideoRepository::class
}

val videoService by inject<VideoService>()

fun Application.registerVideoRoutes() {
    routing {
        videoInfo()
    }
}

fun Route.videoInfo() {
    get<VideoInfoLocation> {
        call.respond( ApiResultSuccess(videoService.getVideoInfo(it.id)) )
    }
}

@Location("/videoInfo/{id}")
class VideoInfoLocation(val id: Long)