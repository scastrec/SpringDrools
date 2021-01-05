package fr.castrec.stephane.DroolsSample.config

import org.kie.api.KieServices
import org.kie.api.builder.KieBuilder
import org.kie.api.builder.KieFileSystem
import org.kie.api.builder.KieModule
import org.kie.api.runtime.KieContainer
import org.kie.internal.io.ResourceFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration


@Configuration
@ComponentScan("fr.castrec.stephane.DroolsSample")
class DroolsConfig {

    private val drlBotFile = "BOT_RULES.drl"
    private val drlProductFile = "PRODUCT_RULES.drl"

    @Bean
    @Qualifier("botKie")
    fun kieContainer(): KieContainer {
        val kieServices: KieServices = KieServices.Factory.get()
        val kieFileSystem: KieFileSystem = kieServices.newKieFileSystem()
        kieFileSystem.write(ResourceFactory.newClassPathResource(drlBotFile))
        val kieBuilder: KieBuilder = kieServices.newKieBuilder(kieFileSystem)
        kieBuilder.buildAll()
        val kieModule: KieModule = kieBuilder.getKieModule()
        return kieServices.newKieContainer(kieModule.getReleaseId())
    }

    @Bean
    @Qualifier("productKie")
    fun kieProductContainer(): KieContainer {
        val kieServices: KieServices = KieServices.Factory.get()
        val kieFileSystem: KieFileSystem = kieServices.newKieFileSystem()
        kieFileSystem.write(ResourceFactory.newClassPathResource(drlProductFile))
        val kieBuilder: KieBuilder = kieServices.newKieBuilder(kieFileSystem)
        kieBuilder.buildAll()
        val kieModule: KieModule = kieBuilder.getKieModule()
        return kieServices.newKieContainer(kieModule.getReleaseId())
    }
}