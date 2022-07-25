package com.github.dkovalenko.ktor_seed

import io.ktor.server.application.*
import com.github.dkovalenko.ktor_seed.plugins.*

fun main(args: Array<String>): Unit =
        io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.main() {
    configureRouting()
    configureMonitoring()
    configureDI()
}
