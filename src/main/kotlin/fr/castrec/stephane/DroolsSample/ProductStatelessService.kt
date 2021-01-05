package fr.castrec.stephane.DroolsSample

import fr.castrec.stephane.DroolsSample.model.Product
import org.kie.api.runtime.KieContainer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service


@Service
class ProductStatelessService {

    @Autowired
    @Qualifier(value="productKie")
    lateinit var productKie: KieContainer

    fun getDiscount(type: String): Int {
        val kieSession = productKie!!.newStatelessKieSession()
        val product = Product()
        product.type = type

        kieSession.execute(product)
        return product.discount;
    }
}