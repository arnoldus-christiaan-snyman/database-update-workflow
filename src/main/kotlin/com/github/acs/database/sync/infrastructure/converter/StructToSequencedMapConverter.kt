package com.github.acs.database.sync.infrastructure.converter

import org.apache.camel.Converter
import org.apache.kafka.connect.data.Struct
import org.apache.kafka.connect.data.Field
import java.util.SequencedMap

@Converter(generateLoader = true)
class StructToSequencedMapConverter {

    companion object {
        @JvmStatic
        @Converter
        fun toSequencedMap(struct: Struct): SequencedMap<String, Any> {
            val map: SequencedMap<String, Any> = LinkedHashMap()
            for(field: Field in struct.schema().fields()) {
                val value = struct[field]
                if (value is Struct) {
                    map[field.name()] = toSequencedMap(value)
                } else {
                    map[field.name()] = value
                }
            }
            return map
        }
    }

}