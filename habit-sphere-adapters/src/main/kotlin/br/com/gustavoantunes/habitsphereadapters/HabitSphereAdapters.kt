package br.com.gustavoantunes.habitsphereadapters

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication(scanBasePackages = ["br.com.gustavoantunes"])
class HabitSphereAdapters

fun main(args: Array<String>) {
	runApplication<HabitSphereAdapters>(*args)
}
