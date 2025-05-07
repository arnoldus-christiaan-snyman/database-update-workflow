package com.github.acs.database.sync.infrastructure.adapter.inbound

import com.github.acs.database.sync.infrastructure.constant.CamelComponent
import org.apache.camel.ExchangePattern
import org.apache.camel.builder.RouteBuilder
import org.apache.camel.component.debezium.oracle.configuration.OracleConnectorEmbeddedDebeziumConfiguration
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.SequencedMap

@Component
class OracleDatabaseConnector(
    @Value("\${camel.component.debezium-oracle.name}") val connectorName: String,
    @Value("\${camel.component.debezium-oracle.topic}") val topic: String,
) : RouteBuilder() {

    companion object {
        const val ROUTE_ID: String = "OracleDatabaseConnector"
    }

    override fun configure() {
        from("${CamelComponent.DEBEZIUM_ORACLE.component}?name=${connectorName}&topic=${topic}")
            .setExchangePattern(ExchangePattern.InOnly)
            .routeId(ROUTE_ID)
            .log("Received '\${header.CamelDebeziumOperation}' event from Oracle database:\n\${body}")
            .convertBodyTo(SequencedMap::class.java)
            .process { exchange ->
                val debeziumRecord = exchange.getIn().getBody(OracleConnectorEmbeddedDebeziumConfiguration::class.java)
                // Process the debezium record here
                println(debeziumRecord)
            }
            .to("direct:processChangeEvent")
    }
}