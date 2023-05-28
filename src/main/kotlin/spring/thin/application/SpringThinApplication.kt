package spring.thin.application

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import spring.thin.application.annotation.SpringBootThinApplication

@SpringBootThinApplication
class SpringThinApplication(private val applicationContext: ApplicationContext) : ApplicationRunner {
    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<SpringThinApplication>(*args)
        }
    }

    override fun run(args: ApplicationArguments) {
        this.applicationContext.beanDefinitionNames.forEach(this.log::info)

        this.log.info("beanDefinitionCount: {}", this.applicationContext.beanDefinitionCount)
    }
}
