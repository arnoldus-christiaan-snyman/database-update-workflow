package com.github.acs.database.sync.domain.mapper.dto

import com.github.acs.database.sync.domain.model.CustomerDTO
import java.util.SequencedMap

class CustomerDTOMapper: BaseDTOMapper<CustomerDTO> {
    override fun mapToDTO(map: SequencedMap<String, *>): CustomerDTO {
        TODO("Not yet implemented")
    }

    override fun mapToSequencedMap(dto: CustomerDTO): SequencedMap<String, *> {
        TODO("Not yet implemented")
    }

    override fun mapToDTOSet(mapSet: Set<SequencedMap<String, *>>): Set<CustomerDTO> {
        TODO("Not yet implemented")
    }

    override fun mapToSequencedMapSet(dtoSet: Set<CustomerDTO>): Set<SequencedMap<String, *>> {
        TODO("Not yet implemented")
    }
}