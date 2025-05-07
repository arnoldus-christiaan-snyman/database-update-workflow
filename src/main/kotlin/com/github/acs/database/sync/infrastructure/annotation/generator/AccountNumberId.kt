package com.github.acs.database.sync.infrastructure.annotation.generator

import com.github.acs.database.sync.infrastructure.generator.AccountPrefixNumberGenerator
import org.hibernate.annotations.IdGeneratorType

@IdGeneratorType(AccountPrefixNumberGenerator::class)
@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY_GETTER)
@Retention(AnnotationRetention.RUNTIME)
internal annotation class AccountNumberId()
