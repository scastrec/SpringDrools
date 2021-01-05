package fr.castrec.stephane.DroolsSample

import fr.castrec.stephane.DroolsSample.model.BotSession
import org.kie.api.runtime.KieContainer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service


@Service
class BotService {

    @Autowired
    @Qualifier(value="botKie")
    lateinit var botKie: KieContainer


    fun findNextQuestion(botSession: BotSession): Int? {
        val kieSession = botKie!!.newKieSession()
        kieSession.insert(botSession)
        kieSession.fireAllRules()
        kieSession.dispose()
        return botSession.nextQuestion;
    }
}