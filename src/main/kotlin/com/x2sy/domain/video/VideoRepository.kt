package com.x2sy.domain.video

import com.x2sy.domain.config.ConfigProvider
import com.x2sy.domain.video.model.VideoInfo


interface VideoRepository {
    suspend fun getVideoInfo(id: Long): VideoInfo
}

class VideoRepositoryImpl(private val configProvider: ConfigProvider) : VideoRepository {

    override suspend fun getVideoInfo(id: Long): VideoInfo {
        if (id == configProvider.getApplicationConfiguration().video.magicVideoId) {
            return VideoInfo(id, "foo", "bar1")
        } else {
            throw Exception("Video not found")
        }
    }
}