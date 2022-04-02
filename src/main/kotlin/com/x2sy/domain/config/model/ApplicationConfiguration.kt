package com.x2sy.domain.config.model

data class ApplicationConfiguration(
  val video: VideoConfiguration
)

data class VideoConfiguration(
    val magicVideoId: Long
)
