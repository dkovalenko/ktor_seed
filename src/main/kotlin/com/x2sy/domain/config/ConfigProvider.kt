package com.x2sy.domain.config

import com.typesafe.config.ConfigFactory
import com.x2sy.domain.config.model.ApplicationConfiguration
import com.x2sy.domain.video.VideoService
import io.github.config4k.extract
import io.ktor.server.config.*
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

interface ConfigProvider {
    fun getApplicationConfiguration(): ApplicationConfiguration
}

val configModule = module {
    singleOf(::ConfigProviderImpl) bind ConfigProvider::class
}

class ConfigProviderImpl(): ConfigProvider {
    override fun getApplicationConfiguration(): ApplicationConfiguration {
        val source = ConfigFactory.defaultApplication()
        return source.extract<ApplicationConfiguration>("application")
    }
}
