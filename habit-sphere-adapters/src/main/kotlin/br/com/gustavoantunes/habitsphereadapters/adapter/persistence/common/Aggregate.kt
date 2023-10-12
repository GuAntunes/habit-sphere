package br.com.gustavoantunes.habitsphereadapters.adapter.persistence.common

import com.fasterxml.jackson.annotation.JsonValue
import org.springframework.data.domain.AbstractAggregateRoot
import java.util.UUID
import java.util.UUID.fromString

abstract class Aggregate : AbstractAggregateRoot<Aggregate>() {
    abstract val id: AggregateId
}

data class AggregateId(
    @JsonValue private val value: UUID = UUID.randomUUID()
) {
    constructor(value: String) : this(fromString(value))

    fun toUUID(): UUID = value

    override fun toString(): String = value.toString()
}