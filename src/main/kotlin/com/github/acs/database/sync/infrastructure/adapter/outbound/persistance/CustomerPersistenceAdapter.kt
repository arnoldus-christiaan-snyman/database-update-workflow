package com.github.acs.database.sync.infrastructure.adapter.outbound.persistance

import com.github.acs.database.sync.application.port.output.EntityDeletePort
import com.github.acs.database.sync.application.port.output.EntityPersistencePort
import com.github.acs.database.sync.application.port.output.EntitySearchPort
import com.github.acs.database.sync.application.port.output.EntityUpdatePort
import com.github.acs.database.sync.infrastructure.persistence.Customer
import com.github.acs.database.sync.infrastructure.repository.CustomerRepository
import org.springframework.stereotype.Component

@Component
class CustomerPersistenceAdapter(
    val customerRepository: CustomerRepository
) :
    EntityPersistencePort<Customer>,
    EntitySearchPort<Customer>,
    EntityUpdatePort<Customer>,
    EntityDeletePort<Customer>
{

    override fun saveEntity(entity: Customer): Customer {
        return this.customerRepository.save(entity)
    }

    override fun findEntityById(id: Long): Customer? {
        return this.customerRepository.findById(id).get()
    }

    override fun findEntitiesByField(
        fieldName: String,
        fieldValue: Any
    ): Set<Customer>? {
        return emptySet()
    }

    override fun findAllEntities(): Set<Customer> {
        return this.customerRepository.findAll().toSet()
    }

    override fun updateEntity(entity: Customer): Customer {
        return this.customerRepository.save(entity)
    }

    override fun deleteEntity(entity: Customer): Unit {
        this.customerRepository.delete(entity)
    }
}