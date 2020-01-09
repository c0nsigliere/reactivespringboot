package ru.tuzhilov.reactivespringboot

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.time.Duration
import java.time.LocalDateTime
import java.util.concurrent.ThreadLocalRandom

@Service
class PriceService {

    fun generatePrices(symbol: String): Flux<StockPrice> = Flux.interval(Duration.ofSeconds(1)).map {
        StockPrice(symbol, randomStickPrice(), LocalDateTime.now())
    }

    private fun randomStickPrice() = ThreadLocalRandom.current().nextDouble(100.00)
}
