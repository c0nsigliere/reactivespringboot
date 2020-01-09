package ru.tuzhilov.reactivespringboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.awt.PageAttributes
import java.time.Duration
import java.time.LocalDateTime
import java.util.concurrent.ThreadLocalRandom

@SpringBootApplication
class ReactivespringbootApplication

fun main(args: Array<String>) {
    runApplication<ReactivespringbootApplication>(*args)

}

@RestController
class RestController(val priceService: PriceService) {

    @GetMapping(value = ["/stocks/{symbol}"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun prices(@PathVariable symbol: String) = priceService.generatePrices(symbol)
}

data class StockPrice(val symbol: String, val price: Double, val time: LocalDateTime)
