package com.github.dkovalenko.ktor_seed.domain.video

import com.github.dkovalenko.ktor_seed.domain.config.ConfigProvider
import com.github.dkovalenko.ktor_seed.domain.video.model.VideoInfo


interface VideoRepository {
    suspend fun getVideoInfo(id: Long): VideoInfo
}

class VideoRepositoryImpl(private val configProvider: ConfigProvider) : VideoRepository {

    override suspend fun getVideoInfo(id: Long): VideoInfo {
        if (id == configProvider.getApplicationConfiguration().video.magicVideoId) {
            return VideoInfo(id, "foo", "bar")
        } else {
            throw Exception("Video not found")
        }
    }
}