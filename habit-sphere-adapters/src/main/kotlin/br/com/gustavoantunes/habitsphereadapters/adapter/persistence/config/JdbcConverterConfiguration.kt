package br.com.gustavoantunes.habitsphereadapters.adapter.persistence.config

import br.com.gustavoantunes.habitsphereadapters.adapter.persistence.common.AggregateId
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.ReadingConverter
import org.springframework.data.convert.WritingConverter
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration
import java.util.UUID

@Configuration
class JdbcConverterConfiguration: AbstractJdbcConfiguration() {

    override fun jdbcCustomConversions(): JdbcCustomConversions =
        JdbcCustomConversions(
            listOf(
                AggregateIdToUuidConverter(),
                UuidToAggregateIdConverter()
            )
        )

    @WritingConverter
    inner class AggregateIdToUuidConverter : Converter<AggregateId, UUID> {
        override fun convert(source: AggregateId): UUID {
            return source.toUUID()
        }
    }

    @ReadingConverter
    inner class UuidToAggregateIdConverter : Converter<UUID, AggregateId> {
        override fun convert(source: UUID): AggregateId {
            return AggregateId(source)
        }
    }
}

