package com.github.acs.database.sync.domain.mapper.dto

import com.github.acs.database.sync.domain.model.GeometryDTO
import java.util.SequencedMap

class GeometryDTOMapper: BaseDTOMapper<GeometryDTO> {
    override fun mapToDTO(map: SequencedMap<String, *>): GeometryDTO {
        TODO("Not yet implemented")
    }

    override fun mapToSequencedMap(dto: GeometryDTO): SequencedMap<String, *> {
        TODO("Not yet implemented")
    }

    override fun mapToDTOSet(mapSet: Set<SequencedMap<String, *>>): Set<GeometryDTO> {
        TODO("Not yet implemented")
    }

    override fun mapToSequencedMapSet(dtoSet: Set<GeometryDTO>): Set<SequencedMap<String, *>> {
        TODO("Not yet implemented")
    }
}