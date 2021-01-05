package fr.castrec.stephane.DroolsSample

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductServicesTest() {

	@Autowired
	private lateinit var productServices: ProductService

	@Test
	fun isFirstQuestionTest() {
		val discount: Int? = productServices.getDiscount("gold")
		assertNotNull(discount)
		assertEquals(25, discount)
	}

}
