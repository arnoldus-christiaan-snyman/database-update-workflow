package com.github.acs.database.sync.domain.mapper.dto

import com.github.acs.database.sync.domain.model.meter.BrandDTO
import java.util.SequencedMap

class BrandDTOMapper: BaseDTOMapper<BrandDTO> {
    override fun mapToDTO(map: SequencedMap<String, *>): BrandDTO {
        TODO("Not yet implemented")
    }

    override fun mapToSequencedMap(dto: BrandDTO): SequencedMap<String, *> {
        TODO("Not yet implemented")
    }

    override fun mapToDTOSet(mapSet: Set<SequencedMap<String, *>>): Set<BrandDTO> {
        TODO("Not yet implemented")
    }

    override fun mapToSequencedMapSet(dtoSet: Set<BrandDTO>): Set<SequencedMap<String, *>> {
        TODO("Not yet implemented")
    }
}