package br.com.gustavoantunes.habitsphereadapters.adapter.kafka.config

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumerService {

    @KafkaListener(topics = ["your-topic"])
    fun listen(message: String) {
        // Process the received message
        println("Received message: $message")
    }
}