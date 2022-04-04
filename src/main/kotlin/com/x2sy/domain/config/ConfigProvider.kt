package com.x2sy.domain.config

import com.typesafe.config.ConfigFactory
import com.x2sy.domain.config.model.ApplicationConfiguration
import io.github.config4k.extract
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import java.util.concurrent.atomic.AtomicReference

interface ConfigProvider {
    fun getApplicationConfiguration(): ApplicationConfiguration
}

val configModule = module {
    singleOf(::ConfigProviderImpl) bind ConfigProvider::class
}

class ConfigProviderImpl(): ConfigProvider {
    private val cached = AtomicReference<ApplicationConfiguration?>()

    override fun getApplicationConfiguration(): ApplicationConfiguration {
        val current = cached.get()
        return if (current != null) {
            current
        } else {
            val source = ConfigFactory.defaultApplication()
            val newVal = source.extract<ApplicationConfiguration>("application")
            cached.set(newVal)
            newVal
        }

    }
}
