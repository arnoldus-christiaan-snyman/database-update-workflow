package com.github.acs.database.sync.domain.mapper.dto

import com.github.acs.database.sync.domain.model.meter.MeterDTO
import java.util.SequencedMap

class MeterDTOMapper: BaseDTOMapper<MeterDTO> {
    override fun mapToDTO(map: SequencedMap<String, *>): MeterDTO {
        TODO("Not yet implemented")
    }

    override fun mapToSequencedMap(dto: MeterDTO): SequencedMap<String, *> {
        TODO("Not yet implemented")
    }

    override fun mapToDTOSet(mapSet: Set<SequencedMap<String, *>>): Set<MeterDTO> {
        TODO("Not yet implemented")
    }

    override fun mapToSequencedMapSet(dtoSet: Set<MeterDTO>): Set<SequencedMap<String, *>> {
        TODO("Not yet implemented")
    }
}