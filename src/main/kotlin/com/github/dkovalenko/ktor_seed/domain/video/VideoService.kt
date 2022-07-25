package com.github.dkovalenko.ktor_seed.domain.video

import com.github.dkovalenko.ktor_seed.domain.video.model.VideoInfo


interface VideoService {
    suspend fun getVideoInfo(id: Long): VideoInfo
}

class VideoServiceImpl(private val videoRepository: VideoRepository) : VideoService {

    override suspend fun getVideoInfo(id: Long): VideoInfo {
        return videoRepository.getVideoInfo(id)
    }
}