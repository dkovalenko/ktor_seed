package com.github.dkovalenko.ktor_seed.domain.config.model

data class ApplicationConfiguration(
  val video: VideoConfiguration
)

data class VideoConfiguration(
    val magicVideoId: Long
)
