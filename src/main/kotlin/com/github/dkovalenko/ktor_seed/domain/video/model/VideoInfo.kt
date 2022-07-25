package com.github.dkovalenko.ktor_seed.domain.video.model

import kotlinx.serialization.Serializable

@Serializable
data class VideoInfo(val id: Long, val title: String, val description: String)
