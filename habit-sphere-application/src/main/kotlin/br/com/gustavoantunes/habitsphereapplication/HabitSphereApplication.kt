package br.com.gustavoantunes.habitsphereapplication

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HabitSphereApplication

fun main(args: Array<String>) {
	runApplication<HabitSphereApplication>(*args)
}
