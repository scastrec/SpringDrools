package fr.castrec.stephane.DroolsSample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class DroolsSampleApplication

fun main(args: Array<String>) {
	runApplication<DroolsSampleApplication>(*args)
	//SpringApplication.run(Application::class.java, args)
}


