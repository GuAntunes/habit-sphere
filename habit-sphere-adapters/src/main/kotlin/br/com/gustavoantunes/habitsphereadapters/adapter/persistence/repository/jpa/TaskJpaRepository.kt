package br.com.gustavoantunes.habitsphereadapters.adapter.persistence.repository.jpa

import br.com.gustavoantunes.habitsphereadapters.adapter.persistence.common.AggregateInsertableRepository
import br.com.gustavoantunes.habitsphereadapters.adapter.persistence.common.AggregateRepository
import br.com.gustavoantunes.habitsphereadapters.adapter.persistence.entity.TaskEntity
import org.springframework.stereotype.Repository

@Repository
interface TaskJpaRepository : AggregateRepository<TaskEntity>, AggregateInsertableRepository<TaskEntity>
