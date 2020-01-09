package ru.tuzhilov.reactivespringboot;

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller
import reactor.core.publisher.Flux

@Controller
class RSocketController(val priceService: PriceService) {
    @MessageMapping("stockPrices")
    fun prices(symbol: String) = priceService.generatePrices(symbol)
}
