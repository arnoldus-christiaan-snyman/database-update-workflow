package com.github.acs.database.sync.infrastructure.adapter.outbound.persistance

import com.github.acs.database.sync.application.port.output.EntityDeletePort
import com.github.acs.database.sync.application.port.output.EntityPersistencePort
import com.github.acs.database.sync.application.port.output.EntitySearchPort
import com.github.acs.database.sync.application.port.output.EntityUpdatePort
import com.github.acs.database.sync.infrastructure.persistence.CustomerEntity
import com.github.acs.database.sync.infrastructure.repository.CustomerRepository
import org.springframework.stereotype.Component

@Component
class CustomerPersistenceAdapter(
    val customerRepository: CustomerRepository
) :
    EntityPersistencePort<CustomerEntity>,
    EntitySearchPort<CustomerEntity>,
    EntityUpdatePort<CustomerEntity>,
    EntityDeletePort<CustomerEntity>
{

    override fun saveEntity(entity: CustomerEntity): CustomerEntity {
        return this.customerRepository.save(entity)
    }

    override fun findEntityById(id: Long): CustomerEntity? {
        return this.customerRepository.findById(id).get()
    }

    override fun findEntitiesByField(
        fieldName: String,
        fieldValue: Any
    ): Set<CustomerEntity>? {
        return emptySet()
    }

    override fun findAllEntities(): Set<CustomerEntity> {
        return this.customerRepository.findAll().toSet()
    }

    override fun updateEntity(entity: CustomerEntity): CustomerEntity {
        return this.customerRepository.save(entity)
    }

    override fun deleteEntity(entity: CustomerEntity): Unit {
        this.customerRepository.delete(entity)
    }
}