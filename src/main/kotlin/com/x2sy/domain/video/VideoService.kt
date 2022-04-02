package com.x2sy.domain.video

import com.x2sy.domain.video.model.VideoInfo


interface VideoService {
    suspend fun getVideoInfo(id: Long): VideoInfo
}

class VideoServiceImpl(private val videoRepository: VideoRepository) : VideoService {

    override suspend fun getVideoInfo(id: Long): VideoInfo {
        return videoRepository.getVideoInfo(id)
    }
}