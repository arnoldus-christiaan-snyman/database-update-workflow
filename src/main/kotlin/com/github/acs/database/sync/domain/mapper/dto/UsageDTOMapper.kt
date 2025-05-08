package com.github.acs.database.sync.domain.mapper.dto

import com.github.acs.database.sync.domain.model.UsageDTO
import java.util.SequencedMap

class UsageDTOMapper: BaseDTOMapper<UsageDTO> {
    override fun mapToDTO(map: SequencedMap<String, *>): UsageDTO {
        TODO("Not yet implemented")
    }

    override fun mapToSequencedMap(dto: UsageDTO): SequencedMap<String, *> {
        TODO("Not yet implemented")
    }

    override fun mapToDTOSet(mapSet: Set<SequencedMap<String, *>>): Set<UsageDTO> {
        TODO("Not yet implemented")
    }

    override fun mapToSequencedMapSet(dtoSet: Set<UsageDTO>): Set<SequencedMap<String, *>> {
        TODO("Not yet implemented")
    }
}