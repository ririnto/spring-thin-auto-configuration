package spring.thin.autoconfigure.selector

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.context.annotation.ImportCandidates
import org.springframework.context.annotation.DeferredImportSelector
import org.springframework.context.annotation.Import
import org.springframework.core.type.AnnotationMetadata
import spring.thin.autoconfigure.annotation.EnableThinAutoConfiguration

@Import(value = [ThinAutoConfigurationSelector::class])
class ThinAutoConfigurationSelector(private val classLoader: ClassLoader) : DeferredImportSelector {
    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    override fun selectImports(importingClassMetadata: AnnotationMetadata): Array<String> {
        val candidates: Array<String> =
            ImportCandidates.load(EnableThinAutoConfiguration::class.java, this.classLoader).candidates.toTypedArray()

        this.log.info("candidates: {}", candidates)

        return candidates
    }
}
