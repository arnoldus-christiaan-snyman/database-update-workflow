package com.github.acs.database.sync.domain.mapper.dto

import java.util.SequencedMap

interface BaseDTOMapper<T> {

    fun mapToDTO(map: SequencedMap<String, *>): T

    fun mapToSequencedMap(dto: T): SequencedMap<String, *>

    fun mapToDTOSet(mapSet: Set<SequencedMap<String, *>>): Set<T>

    fun mapToSequencedMapSet(dtoSet: Set<T>): Set<SequencedMap<String, *>>

}