package com.github.acs.database.sync.domain.mapper.dto

import com.github.acs.database.sync.domain.model.ProviderDTO
import java.util.SequencedMap

class ProviderDTOMapper: BaseDTOMapper<ProviderDTO> {
    override fun mapToDTO(map: SequencedMap<String, *>): ProviderDTO {
        TODO("Not yet implemented")
    }

    override fun mapToSequencedMap(dto: ProviderDTO): SequencedMap<String, *> {
        TODO("Not yet implemented")
    }

    override fun mapToDTOSet(mapSet: Set<SequencedMap<String, *>>): Set<ProviderDTO> {
        TODO("Not yet implemented")
    }

    override fun mapToSequencedMapSet(dtoSet: Set<ProviderDTO>): Set<SequencedMap<String, *>> {
        TODO("Not yet implemented")
    }
}