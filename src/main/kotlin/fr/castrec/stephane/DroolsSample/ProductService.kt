package fr.castrec.stephane.DroolsSample

import fr.castrec.stephane.DroolsSample.model.Product
import org.kie.api.runtime.KieContainer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service


@Service
class ProductService {

    @Autowired
    @Qualifier(value="productKie")
    lateinit var productKie: KieContainer

    fun getDiscount(type: String): Int {
        val kieSession = productKie!!.newKieSession()
        val product = Product()
        product.type = type

        kieSession.insert(product)
        kieSession.fireAllRules()
        kieSession.dispose()
        return product.discount;
    }

    fun disposeSession() {

    }
}