package fr.castrec.stephane.DroolsSample.rest

import fr.castrec.stephane.DroolsSample.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class ProductController (val productService: ProductService) {

    @GetMapping("/discount")
    fun getDiscount(@RequestParam(required = true) type: String): Int {

        val discount: Int = productService.getDiscount(type)
        return discount;
    }
}
