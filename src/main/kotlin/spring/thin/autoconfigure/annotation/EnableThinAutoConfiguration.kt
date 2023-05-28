package spring.thin.autoconfigure.annotation

import org.springframework.context.annotation.Import
import spring.thin.autoconfigure.selector.ThinAutoConfigurationSelector

@Import(value = [ThinAutoConfigurationSelector::class])
annotation class EnableThinAutoConfiguration
