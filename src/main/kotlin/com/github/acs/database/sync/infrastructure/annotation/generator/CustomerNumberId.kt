package com.github.acs.database.sync.infrastructure.annotation.generator

import com.github.acs.database.sync.infrastructure.generator.CustomerPrefixNumberGenerator
import org.hibernate.annotations.IdGeneratorType

@IdGeneratorType(CustomerPrefixNumberGenerator::class)
@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY_GETTER)
@Retention(AnnotationRetention.RUNTIME)
internal annotation class CustomerNumberId()
