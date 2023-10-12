package br.com.gustavoantunes.habitsphereadapters.adapter.persistence.common

import org.springframework.data.jdbc.core.JdbcAggregateOperations
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface AggregateRepository<T : Aggregate> :
    CrudRepository<T, AggregateId>,
    PagingAndSortingRepository<T, AggregateId>

interface AggregateInsertableRepository<T> {
    fun insert(aggregate: T): T
    fun update(aggregate: T): T
}

open class AggregateInsertableRepositoryImpl<T : Aggregate>(
    private val aggregateOperations: JdbcAggregateOperations
) : AggregateInsertableRepository<T> {

    override fun insert(aggregate: T): T {
        return aggregateOperations.insert(aggregate)
    }

    override fun update(aggregate: T): T {
        return aggregateOperations.update(aggregate)
    }
}