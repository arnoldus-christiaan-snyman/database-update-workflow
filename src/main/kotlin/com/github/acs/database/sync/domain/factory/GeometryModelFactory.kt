package com.github.acs.database.sync.domain.factory

import com.github.acs.database.sync.domain.model.GeometryDTO

class GeometryModelFactory : ModelFactory<GeometryDTO> {
    override fun createEntity(entity: GeometryDTO): GeometryDTO {
        // Implement the logic to create a Geometry entity
        return entity
    }

    override fun updateEntity(entity: GeometryDTO): GeometryDTO {
        // Implement the logic to update a Geometry entity
        return entity
    }
}