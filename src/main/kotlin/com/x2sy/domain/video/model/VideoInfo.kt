package com.x2sy.domain.video.model

import kotlinx.serialization.Serializable

@Serializable
data class VideoInfo(val id: Long, val title: String, val description: String)
