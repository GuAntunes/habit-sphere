package br.com.gustavoantunes.habitsphereadapters.adapter.resource

import br.com.gustavoantunes.habitsphereadapters.adapter.resource.request.TaskCreateRequest
import br.com.gustavoantunes.habitsphereadapters.adapter.resource.request.TaskUpdateRequest
import br.com.gustavoantunes.habitsphereadapters.port.TaskRestPort
import br.com.gustavoantunes.habitsphereapplication.service.TaskService
import br.com.gustavoantunes.habitspheredomain.model.Task
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/task")
class RestTaskControllerAdapter(private val taskService: TaskService) : TaskRestPort {

    @GetMapping("/list")
    override fun getAllTasks(): List<Task> {
        return taskService.getAllTasks()
    }

    @GetMapping("/{taskId}")
    override fun getTaskById(@PathVariable taskId: UUID): Task? {
        return taskService.getTaskById(taskId)
    }

    @PostMapping
    override fun createTask(@RequestBody task: TaskCreateRequest): Task {
        return taskService.createTask(task.toTask())
    }

    @PutMapping
    override fun updateTask(@RequestBody updatedTask: TaskUpdateRequest): Task {
        return taskService.updateTask(updatedTask.toTask())
    }

    @DeleteMapping("/{taskId}")
    override fun deleteTask(@PathVariable taskId: UUID) {
        taskService.deleteTask(taskId)
    }
}