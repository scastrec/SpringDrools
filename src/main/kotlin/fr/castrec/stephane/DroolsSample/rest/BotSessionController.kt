package fr.castrec.stephane.DroolsSample.rest

import fr.castrec.stephane.DroolsSample.BotService
import fr.castrec.stephane.DroolsSample.model.Answer
import fr.castrec.stephane.DroolsSample.model.BotSession
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
class BotSessionController (val botService: BotService) {

    @GetMapping("/question/{id}")
    fun getQuestions(@PathVariable questionId: String, @RequestParam(required = true) response: String?): Int? {
        val s = BotSession(LinkedList<Answer>())

        val nextQ: Int? = botService.findNextQuestion(s)
        if (nextQ != null) {
            return nextQ;
        } else {
            return null;
        }

    }
}
