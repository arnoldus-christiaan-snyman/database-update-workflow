package com.github.acs.database.sync.domain.factory


object ModelFactoryFinder {

    fun findModelFactory(table: String): ModelFactory<*> {
        when(table.lowercase()) {
            "usage" -> return UsageModelFactory()
            "account" -> return AccountModelFactory()
            "address" -> return AddressModelFactory()
            "brand" -> return BrandModelFactory()
            "customer" -> return CustomerModelFactory()
            "geometry" -> return GeometryModelFactory()
            "provider" -> return ProviderModelFactory()
            else -> throw IllegalArgumentException("No model factory found for table: $table")
        }
    }

}