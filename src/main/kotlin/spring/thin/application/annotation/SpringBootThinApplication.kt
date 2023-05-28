package spring.thin.application.annotation

import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter
import org.springframework.boot.context.TypeExcludeFilter
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FilterType
import spring.thin.autoconfigure.annotation.EnableThinAutoConfiguration
import java.lang.annotation.Inherited

@Target(allowedTargets = [AnnotationTarget.CLASS])
@Retention(value = AnnotationRetention.RUNTIME)
@MustBeDocumented
@Inherited
@SpringBootConfiguration
@EnableThinAutoConfiguration
@ComponentScan(
    excludeFilters = [
        ComponentScan.Filter(type = FilterType.CUSTOM, classes = [TypeExcludeFilter::class]),
        ComponentScan.Filter(type = FilterType.CUSTOM, classes = [AutoConfigurationExcludeFilter::class])
    ]
)
annotation class SpringBootThinApplication
