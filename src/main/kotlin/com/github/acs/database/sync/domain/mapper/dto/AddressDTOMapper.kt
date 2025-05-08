package com.github.acs.database.sync.domain.mapper.dto

import com.github.acs.database.sync.domain.model.AddressDTO
import java.util.SequencedMap

class AddressDTOMapper: BaseDTOMapper<AddressDTO>  {
    override fun mapToDTO(map: SequencedMap<String, *>): AddressDTO {
        TODO("Not yet implemented")
    }

    override fun mapToSequencedMap(dto: AddressDTO): SequencedMap<String, *> {
        TODO("Not yet implemented")
    }

    override fun mapToDTOSet(mapSet: Set<SequencedMap<String, *>>): Set<AddressDTO> {
        TODO("Not yet implemented")
    }

    override fun mapToSequencedMapSet(dtoSet: Set<AddressDTO>): Set<SequencedMap<String, *>> {
        TODO("Not yet implemented")
    }
}