package fr.castrec.stephane.DroolsSample

import fr.castrec.stephane.DroolsSample.model.Answer
import fr.castrec.stephane.DroolsSample.model.BotSession
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*
import kotlin.collections.ArrayList

@SpringBootTest
class BotServicesTest() {

	@Autowired
	private lateinit var botServices: BotService

	@Test
	fun isFirstQuestionTest() {
		val session = BotSession(ArrayList())

		val questionId: Int? = botServices.findNextQuestion(session)
		assertNotNull(questionId)
		assertEquals(60, questionId)
	}

	@Test
	fun firstWay() {
		var session = BotSession(mutableListOf())

		var questionId: Int? = botServices.findNextQuestion(session)
		assertNotNull(questionId)
		assertEquals(60, questionId)

		session.answered.add(Answer(60, 1));
		questionId = botServices.findNextQuestion(session)
		assertNotNull(questionId)
		assertEquals(70, questionId)

		session.answered.add(Answer(70, 1));
		questionId = botServices.findNextQuestion(session)
		assertNotNull(questionId)
		assertEquals(71, questionId)
	}

	@Test
	fun secondWay() {
		var session = BotSession(mutableListOf())

		var questionId: Int? = botServices.findNextQuestion(session)
		assertNotNull(questionId)
		assertEquals(60, questionId)

		session.answered.add(Answer(60, 1));
		questionId = botServices.findNextQuestion(session)
		assertNotNull(questionId)
		assertEquals(70, questionId)

		session.answered.add(Answer(70, 2));
		questionId = botServices.findNextQuestion(session)
		assertNotNull(questionId)
		assertEquals(72, questionId)
	}

}
