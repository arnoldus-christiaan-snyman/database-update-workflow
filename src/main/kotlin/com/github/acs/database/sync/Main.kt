package com.github.acs.database.sync

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan("com.github.acs.database.sync.infrastructure.config")
class Main

fun main(args: Array<String>) {
	runApplication<Main>(*args)
}
