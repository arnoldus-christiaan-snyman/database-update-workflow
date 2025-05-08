package com.github.acs.database.sync.domain.mapper.dto

import com.github.acs.database.sync.domain.model.AccountDTO
import com.github.acs.database.sync.domain.model.DomainType
import java.util.SequencedMap

class AccountDTOMapper: BaseDTOMapper<AccountDTO> {
    override fun mapToDTO(map: SequencedMap<String, *>): AccountDTO {
        return AccountDTO(
            accountNumber = map["ACCOUNT_NUMBER"] as String,
            domainType = DomainType.valueOf(map["DOMAIN_TYPE"] as String),
            customerNumber = map["CUSTOMER_NUMBER"] as String,
            customerName = map["CUSTOMER_NAME"] as String,
            address = map["ADDRESS"] as String,
            geometry = map["GEOMETRY"] as String
        )
    }

    override fun mapToSequencedMap(dto: AccountDTO): SequencedMap<String, *> {
        TODO("Not yet implemented")
    }

    override fun mapToDTOSet(mapSet: Set<SequencedMap<String, *>>): Set<AccountDTO> {
        TODO("Not yet implemented")
    }

    override fun mapToSequencedMapSet(dtoSet: Set<AccountDTO>): Set<SequencedMap<String, *>> {
        TODO("Not yet implemented")
    }
}